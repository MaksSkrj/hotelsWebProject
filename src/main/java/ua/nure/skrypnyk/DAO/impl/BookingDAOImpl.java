package ua.nure.skrypnyk.DAO.impl;

import ua.nure.skrypnyk.model.Booking;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static ua.nure.skrypnyk.DAO.impl.SQLs.INSERT_BOOKING;
import static ua.nure.skrypnyk.DAO.impl.SQLs.UPDATE_BOOKING;

public class BookingDAOImpl extends CrudDAO<Booking> {

    public BookingDAOImpl() {
        super(Booking.class);
    }

    private void setStatement(Booking entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getUserId());
        preparedStatement.setString(2, entity.getStatus());
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Booking entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKING);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, Booking entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    public List<Booking> readAll(ResultSet resultSet) throws SQLException {
        List<Booking> result = new LinkedList<>();
        Booking booking = null;
        while (resultSet.next()) {
            booking = new Booking();
            booking.setId(resultSet.getInt("id"));
            booking.setUserId(resultSet.getInt("user_id"));
            booking.setStatus(resultSet.getString("status"));
            result.add(booking);
        }
        return result;
    }
}
