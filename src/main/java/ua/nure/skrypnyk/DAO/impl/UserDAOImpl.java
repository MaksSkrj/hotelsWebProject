package ua.nure.skrypnyk.DAO.impl;

import ua.nure.skrypnyk.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static ua.nure.skrypnyk.DAO.impl.SQLs.INSERT_USER;
import static ua.nure.skrypnyk.DAO.impl.SQLs.UPDATE_USER;

public class UserDAOImpl extends CrudDAO<User> {

    public UserDAOImpl() {
        super(User.class);
    }

    private void setStatement(User entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1,entity.getLogin());
        preparedStatement.setString(2, entity.getName());
        preparedStatement.setString(3, entity.getLastName());
        preparedStatement.setDate(4, (Date) entity.getDOB());
        preparedStatement.setString(5, entity.getSex());
        preparedStatement.setInt(6, entity.getPreferencesId());
        preparedStatement.setInt(7, entity.getBookingId());
        preparedStatement.setString(8, entity.getPassword());
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
        setStatement(entity, preparedStatement);

        return preparedStatement;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    public List<User> readAll(ResultSet resultSet) throws SQLException {
        List<User> result = new LinkedList<>();
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("login"));
            user.setName(resultSet.getString("name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setDOB(resultSet.getDate("DOB"));
            user.setSex(resultSet.getString("sex"));
            user.setPreferencesId(resultSet.getInt("preferences_id"));
            user.setBookingId(resultSet.getInt("booking_id"));
            user.setPassword(resultSet.getString("password"));

            result.add(user);
        }
        return result;
    }
}
