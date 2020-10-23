package ch.heigvd.amt.stackovergoat.infrastructure.persistence.jdbc;

import ch.heigvd.amt.stackovergoat.application.answer.AnswersQuery;
import ch.heigvd.amt.stackovergoat.domain.answer.Answer;
import ch.heigvd.amt.stackovergoat.domain.answer.AnswerId;
import ch.heigvd.amt.stackovergoat.domain.answer.IAnswerRepository;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Named("JdbcAnswerRepository")
public class JdbcAnswerRepository implements IAnswerRepository {
    @Resource(lookup = "jdbc/StackOverflowDS")
    DataSource dataSource;

    public JdbcAnswerRepository(){}

    public JdbcAnswerRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Collection<Answer> find(AnswersQuery query) {
        if (query == null) {
            return findAll();
        }
        boolean fromAuthor  = (!query.getAuthor().equals(""));
        boolean fromId      = (!query.getIdQuestion().equals(""));
        boolean fromText    = (!query.getText().equals(""));

        if (!(fromAuthor || fromId || fromText)) {
            return findAll();
        }
        List<Answer> answers = findAll().stream()
                .filter(answer -> (
                        (fromAuthor && answer.getAuthor().equals(query.getAuthor()))              ||
                                (fromId     && answer.getId().asString().equals(query.getIdQuestion()))   ||
                                (fromText   && answer.getText().equals(query.getText()))))
                .collect(Collectors.toList());
        return answers;
    }

    @Override
    public Collection<Answer> findAll() {
        List<Answer> answers = new LinkedList<>();
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("SELECT * FROM Answer");
            ResultSet resultSet = sql.executeQuery();

            while (resultSet.next()) {
                answers.add(getAnswer(resultSet, connection));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return answers;
    }

    @Override
    public void save(Answer entity) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("INSERT INTO Answer (idAnswer, text, idUser) VALUES (?,?,?)");
            sql.setString(1, entity.getId().toString());
            sql.setString(2, entity.getText());

            PreparedStatement userSql = connection.prepareStatement("SELECT * FROM User WHERE username = ?");
            userSql.setString(1, entity.getAuthor());
            String authorId = "";
            ResultSet resultSetUser = userSql.executeQuery();
            if(resultSetUser.getFetchSize() == 1) {
                authorId = resultSetUser.getString("idAnswer");
            }

            sql.setString(3, authorId);

            int nbRow = sql.executeUpdate();
            connection.close();

            if(nbRow > 1){
                throw new IllegalArgumentException("Task went wrong");
            }

        } catch (SQLException e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void remove(AnswerId id) {
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("DELETE FROM Answer WHERE idAnswer = ?");
            sql.setString(1, id.toString());
            int nbRow = sql.executeUpdate();
            connection.close();
        }catch(SQLException e){
            throw new IllegalArgumentException(e);
        }
    }


    @Override
    public Optional<Answer> findById(AnswerId answer) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("SELECT * FROM Answer WHERE idAnswer = ?");
            sql.setString(1, answer.asString());
            ResultSet res = sql.executeQuery();

            while(res.next()) {
                return Optional.of(getAnswer(res, connection));
            }

        } catch (SQLException e) {
            //traitement de l'exception
            throw new IllegalArgumentException(e);
        }
        return Optional.empty();
    }

    private Answer getAnswer(ResultSet resultSet, Connection connection) throws SQLException {
        AnswerId answerId = new AnswerId(resultSet.getString("idQuestion"));
        String userId = resultSet.getString("idUser");
        String text = resultSet.getString("text");
        String author = "";

        PreparedStatement userSql = connection.prepareStatement("SELECT * FROM User WHERE userId = ?");
        userSql.setString(1, userId);
        ResultSet resultSetUser = userSql.executeQuery();
        if(resultSetUser.getFetchSize() == 1) {
            author = resultSetUser.getString("username");
        }

        Answer submittedAnswer = Answer.builder()
                .id(answerId)
                .author(author)
                .text(text)
                .build();
        return submittedAnswer;
    }
}