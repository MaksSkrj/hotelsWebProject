package ua.nure.skrypnyk.DAO.impl;

import ua.nure.skrypnyk.model.Position;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static ua.nure.skrypnyk.DAO.impl.SQLs.INSERT_POSITION;
import static ua.nure.skrypnyk.DAO.impl.SQLs.UPDATE_POSITION;

public class PositionDAOImpl extends CrudDAO<Position> {

    public PositionDAOImpl() {
        super(Position.class);
    }

    private void setStatement(Position entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getName());
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Position entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_POSITION);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, Position entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POSITION, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    public List<Position> readAll(ResultSet resultSet) throws SQLException {
        List<Position> result = new LinkedList<>();
        Position position = null;
        while (resultSet.next()) {
            position = new Position();
            position.setId(resultSet.getInt("id"));
            position.setName(resultSet.getString("name"));
            result.add(position);
        }
        return result;
    }
}
