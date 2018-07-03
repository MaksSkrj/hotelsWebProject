package ua.nure.skrypnyk.DAO.impl;

import ua.nure.skrypnyk.model.RoomStatus;

import java.sql.*;
import java.time.ZoneOffset;
import java.util.LinkedList;
import java.util.List;

import static ua.nure.skrypnyk.DAO.impl.SQLs.INSERT_ROOM_STATUS;
import static ua.nure.skrypnyk.DAO.impl.SQLs.UPDATE_ROOM_STATUS;

public class RoomStatusDAOImpl extends CrudDAO<RoomStatus> {

   public RoomStatusDAOImpl() {
        super(RoomStatus.class);
    }

    private void setStatement(RoomStatus entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getRoomId());
        preparedStatement.setInt(2, entity.getBookingId());
        //preparedStatement.setDate(3, entity.getArrival().toInstant(ZoneOffset.UTC)); //TODO
        //preparedStatement.setDate(4, entity.getDeparture()); //TODO
        preparedStatement.setInt(5, entity.getEmployeeId());
        preparedStatement.setDouble(6, entity.getFullPrice());
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, RoomStatus entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROOM_STATUS);
        setStatement(entity, preparedStatement);

        return preparedStatement;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, RoomStatus entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_STATUS, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);

        return preparedStatement;
    }

    @Override
    public List<RoomStatus> readAll(ResultSet resultSet) throws SQLException {
        List<RoomStatus> result = new LinkedList<>();
        RoomStatus roomStatus = null;
        while (resultSet.next()) {
            roomStatus = new RoomStatus();
            roomStatus.setId(resultSet.getInt("id"));
            roomStatus.setRoomId(resultSet.getInt("room_id"));
            roomStatus.setBookingId(resultSet.getInt("booking_id"));
            //roomStatus.setArrival(resultSet.getDate("arrival")); //TODO
            //roomStatus.setDeparture(resultSet.getString("departure")); //TODO
            roomStatus.setEmployeeId(resultSet.getInt("employee_id"));
            roomStatus.setFullPrice(resultSet.getDouble("full_price"));
            result.add(roomStatus);
        }
        return result;
    }

}
