package ua.nure.skrypnyk.DAO.impl;

import ua.nure.skrypnyk.model.Preferences;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static ua.nure.skrypnyk.DAO.impl.SQLs.INSERT_PREFERENCES;
import static ua.nure.skrypnyk.DAO.impl.SQLs.UPDATE_PREFERENCES;

public class PreferencesDAOImpl extends CrudDAO<Preferences> {

    public PreferencesDAOImpl() {
        super(Preferences.class);
    }

    private void setStatement(Preferences entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getName());
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Preferences entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PREFERENCES);
        setStatement(entity, preparedStatement);

        return preparedStatement;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, Preferences entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PREFERENCES, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    public List<Preferences> readAll(ResultSet resultSet) throws SQLException {
        List<Preferences> result = new LinkedList<>();
        Preferences preferences = null;
        while (resultSet.next()) {
            preferences = new Preferences();
            preferences.setId(resultSet.getInt("id"));
            preferences.setName(resultSet.getString("name"));
            result.add(preferences);
        }
        return result;
    }
}
