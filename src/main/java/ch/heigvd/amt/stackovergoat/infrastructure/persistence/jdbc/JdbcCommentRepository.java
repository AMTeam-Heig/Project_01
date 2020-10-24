package ch.heigvd.amt.stackovergoat.infrastructure.persistence.jdbc;

import ch.heigvd.amt.stackovergoat.application.comment.CommentsQuery;
import ch.heigvd.amt.stackovergoat.domain.comment.Comment;
import ch.heigvd.amt.stackovergoat.domain.comment.CommentId;
import ch.heigvd.amt.stackovergoat.domain.comment.ICommentRepository;

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
@Named("JdbcCommentRepository")
public class JdbcCommentRepository implements ICommentRepository {
    // TODO : change comment in ddb to user comments answer or question /!\ not the same tables !
    @Resource(lookup = "jdbc/StackOverflowDS")
    DataSource dataSource;

    public JdbcCommentRepository(){}

    public JdbcCommentRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public Collection<Comment> find(CommentsQuery query) {
        if (query == null) {
            return findAll();
        }
        boolean fromAuthor  = (!query.getAuthor().equals(""));
        boolean fromId      = (!query.getIdQuestion().equals(""));
        boolean fromText    = (!query.getComment().equals(""));

        if (!(fromAuthor || fromId || fromText)) {
            return findAll();
        }
        List<Comment> comments = findAll().stream()
                .filter(comment -> (
                        (fromAuthor && comment.getAuthor().equals(query.getAuthor()))              ||
                                (fromId     && comment.getId().asString().equals(query.getIdQuestion()))   ||
                                (fromText   && comment.getComment().equals(query.getComment()))))
                .collect(Collectors.toList());
        return comments;
    }

    @Override
    public Collection<Comment> findAll() {
        List<Comment> comments = new LinkedList<>();
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("SELECT * FROM Comment");
            ResultSet resultSet = sql.executeQuery();

            while (resultSet.next()) {
                comments.add(getComment(resultSet, connection));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return comments;
    }

    @Override
    public Collection<Comment> getByAnswer(String answerId) {
        List<Comment> comments = findAll().stream()
                .filter(comment -> (comment.isForAnswer() && comment.getSubjectId().equals(answerId)))
                .collect(Collectors.toList());
        return comments;
    }

    @Override
    public Collection<Comment> getByQuestion(String questionId) {
        List<Comment> comments = findAll().stream()
                .filter(comment -> (!comment.isForAnswer() && comment.getSubjectId().equals(questionId)))
                .collect(Collectors.toList());
        return comments;
    }

    @Override
    public void save(Comment entity) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("INSERT INTO Comment (idComment, text, idUser) VALUES (?,?,?)");
            sql.setString(1, entity.getId().toString());
            sql.setString(2, entity.getComment());

            PreparedStatement userSql = connection.prepareStatement("SELECT * FROM User WHERE username = ?");
            userSql.setString(1, entity.getAuthor());
            String authorId = "";
            ResultSet resultSetUser = userSql.executeQuery();
            if(resultSetUser.getFetchSize() == 1) {
                authorId = resultSetUser.getString("idComment");
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
    public void remove(CommentId id) {
        try{
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("DELETE FROM Comment WHERE idComment = ?");
            sql.setString(1, id.toString());
            int nbRow = sql.executeUpdate();
            connection.close();
        }catch(SQLException e){
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public int getSize() {
        return 0;
    }


    @Override
    public Optional<Comment> findById(CommentId comment) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement sql = connection.prepareStatement("SELECT * FROM Comment WHERE idComment = ?");
            sql.setString(1, comment.asString());
            ResultSet res = sql.executeQuery();

            while(res.next()) {
                return Optional.of(getComment(res, connection));
            }

        } catch (SQLException e) {
            //traitement de l'exception
            throw new IllegalArgumentException(e);
        }
        return Optional.empty();
    }

    private Comment getComment(ResultSet resultSet, Connection connection) throws SQLException {
        CommentId commentId = new CommentId(resultSet.getString("idComment"));
        String userId = resultSet.getString("idUser");
        String comment = resultSet.getString("comment");
        String author = "";

        PreparedStatement userSql = connection.prepareStatement("SELECT * FROM User WHERE userId = ?");
        userSql.setString(1, userId);
        ResultSet resultSetUser = userSql.executeQuery();
        if(resultSetUser.getFetchSize() == 1) {
            author = resultSetUser.getString("username");
        }

        Comment submittedComment = Comment.builder()
                .id(commentId)
                .author(author)
                .comment(comment)
                .build();
        return submittedComment;
    }
}
