package ch.heigvd.amt.stackovergoat.infrastructure.persistence.jdbc;

import ch.heigvd.amt.stackovergoat.application.question.QuestionsQuery;
import ch.heigvd.amt.stackovergoat.domain.question.IQuestionRepository;
import ch.heigvd.amt.stackovergoat.domain.question.Question;
import ch.heigvd.amt.stackovergoat.domain.question.QuestionId;
import ch.heigvd.amt.stackovergoat.domain.user.User;
import ch.heigvd.amt.stackovergoat.domain.user.UserId;

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
@Named("JdbcUserRepository")
public class JdbcQuestionRepository implements IQuestionRepository {
    @Resource(lookup = "jdbc/StackOverflowDS")
    DataSource dataSource;

    public JdbcQuestionRepository(){}

    public JdbcQuestionRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Collection<Question> find(QuestionsQuery query) {
        List<Question> questions = findAll().stream()
                .filter(question -> (question.getAuthor().equals(query.getAuthor()) ||
<<<<<<< HEAD
                        question.getId().toString().equals(query.getIdQuestion()) ||
                        question.getText().equals(query.getText())))
=======
                                    question.getId().toString().equals(query.getIdQuestion()) ||
                                    question.getText().equals(query.getText())))
>>>>>>> b8d32940b912f253e6eafaff5d95db55944b0eab
                .collect(Collectors.toList());
        return questions;
    }

    @Override
    public Collection<Question> findAll() {
        List<Question> questions = new LinkedList<>();
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("SELECT * FROM Question");
            ResultSet resultSet = sql.executeQuery();

            while (resultSet.next()) {
                questions.add(getQuestion(resultSet, connection));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return questions;
    }

    @Override
    public void save(Question entity) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("INSERT INTO Question (idQuestion, text, idUser) VALUES (?,?,?)");
            sql.setString(1, entity.getId().toString());
            sql.setString(2, entity.getText());

            PreparedStatement userSql = connection.prepareStatement("SELECT * FROM User WHERE username = ?");
            userSql.setString(1, entity.getAuthor());
            String authorId = "";
            ResultSet resultSetUser = userSql.executeQuery();
            if(resultSetUser.getFetchSize() == 1) {
                authorId = resultSetUser.getString("idQuestion");
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
    public void remove(QuestionId id) {
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("DELETE FROM Question WHERE idQuestion = ?");
            sql.setString(1, id.toString());
            int nbRow = sql.executeUpdate();
            connection.close();
        }catch(SQLException e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Optional<Question> findById(QuestionId question) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("SELECT * FROM Question WHERE idQuestion = ?");
            sql.setString(1, question.asString());
            ResultSet res = sql.executeQuery();

            while(res.next()) {
                return Optional.of(getQuestion(res, connection));
            }

        } catch (SQLException e) {
            //traitement de l'exception
            throw new IllegalArgumentException(e);
        }
        return Optional.empty();
    }

    private Question getQuestion(ResultSet resultSet, Connection connection) throws SQLException {
        QuestionId questionId = new QuestionId(resultSet.getString("idQuestion"));
        String userId = resultSet.getString("idUser");
        String text = resultSet.getString("text");
        String author = "";

        PreparedStatement userSql = connection.prepareStatement("SELECT * FROM User WHERE userId = ?");
        userSql.setString(1, userId);
        ResultSet resultSetUser = userSql.executeQuery();
        if(resultSetUser.getFetchSize() == 1) {
            author = resultSetUser.getString("username");
        }

        Question submittedQuestion = Question.builder()
                .id(questionId)
                .author(author)
                .text(text)
                .build();
        return submittedQuestion;
    }
}
