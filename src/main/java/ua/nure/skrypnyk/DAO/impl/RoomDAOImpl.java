package ua.nure.skrypnyk.DAO.impl;

import ua.nure.skrypnyk.model.Room;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static ua.nure.skrypnyk.DAO.impl.SQLs.INSERT_ROOM;
import static ua.nure.skrypnyk.DAO.impl.SQLs.UPDATE_ROOM;

public class RoomDAOImpl extends CrudDAO<Room> {

    public RoomDAOImpl() {
        super(Room.class);
    }

    private void setStatement(Room entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getRoomClassificationId());
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Room entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROOM);
        setStatement(entity, preparedStatement);

        return preparedStatement;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, Room entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    public List<Room> readAll(ResultSet resultSet) throws SQLException {
        List<Room> result = new LinkedList<>();
        Room room = null;
        while (resultSet.next()) {
            room = new Room();
            room.setId(resultSet.getInt("id"));
            room.setRoomClassificationId(resultSet.getInt("room_classification_id"));
            result.add(room);
        }
        return result;
    }
}
