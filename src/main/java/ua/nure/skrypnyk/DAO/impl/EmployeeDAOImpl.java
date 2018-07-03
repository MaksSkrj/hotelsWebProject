package ua.nure.skrypnyk.DAO.impl;

import ua.nure.skrypnyk.model.Employee;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static ua.nure.skrypnyk.DAO.impl.SQLs.INSERT_EMPLOYEE;
import static ua.nure.skrypnyk.DAO.impl.SQLs.UPDATE_EMPLOYEE;

public class EmployeeDAOImpl extends CrudDAO<Employee> {

    public EmployeeDAOImpl() {
        super(Employee.class);
    }

    private void setStatement(Employee entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getLastName());
        preparedStatement.setDate(3, (Date) entity.getDOB());
        preparedStatement.setString(4, entity.getEducation());
        preparedStatement.setInt(5, entity.getPositionId());
        preparedStatement.setDouble(6, entity.getSalary());
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Employee entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, Employee entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    public List<Employee> readAll(ResultSet resultSet) throws SQLException {
        List<Employee> result = new LinkedList<>();
        Employee employee = null;
        while (resultSet.next()) {
            employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setDOB(resultSet.getDate("DOB"));
            employee.setEducation(resultSet.getString("education"));
            employee.setPositionId(resultSet.getInt("position_id"));
            employee.setSalary(resultSet.getDouble("salary"));
            result.add(employee);
        }
        return result;
    }
}
