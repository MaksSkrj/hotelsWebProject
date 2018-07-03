package ua.nure.skrypnyk.DAO.impl;

import ua.nure.skrypnyk.model.RoomClassification;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static ua.nure.skrypnyk.DAO.impl.SQLs.INSERT_ROOM_CLASSIFICATION;
import static ua.nure.skrypnyk.DAO.impl.SQLs.UPDATE_ROOM_CLASSIFICATION;

public class RoomClassificationDAOImpl extends CrudDAO<RoomClassification> {

    public RoomClassificationDAOImpl() {
        super(RoomClassification.class);
    }

    private void setStatement(RoomClassification entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getClassification());
        preparedStatement.setInt(2, entity.getCapacity());
        preparedStatement.setString(3, entity.getAdditionalInformation());
        preparedStatement.setBlob(4, entity.getPictures());
        preparedStatement.setDouble(5, entity.getDailyPrice());
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, RoomClassification entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROOM_CLASSIFICATION);
        setStatement(entity, preparedStatement);

        return preparedStatement;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, RoomClassification entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_CLASSIFICATION, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    public List<RoomClassification> readAll(ResultSet resultSet) throws SQLException {
        List<RoomClassification> result = new LinkedList<>();
        RoomClassification roomClassification = null;
        while (resultSet.next()) {
            roomClassification = new RoomClassification();
            roomClassification.setId(resultSet.getInt("id"));
            roomClassification.setClassification(resultSet.getString("classification"));
            roomClassification.setCapacity(resultSet.getInt("capacity"));
            roomClassification.setAdditionalInformation(resultSet.getString("additional_information"));
            roomClassification.setPictures(resultSet.getBlob("pictures"));
            roomClassification.setDailyPrice(resultSet.getDouble("daily_price"));
            result.add(roomClassification);
        }
        return result;
    }
}
