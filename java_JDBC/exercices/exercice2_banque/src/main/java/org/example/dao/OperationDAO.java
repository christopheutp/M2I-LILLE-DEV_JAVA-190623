package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.model.Operation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OperationDAO extends BaseDAO<Operation> {
    public OperationDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Operation element) throws SQLException {
        request = "INSERT INTO operation (amount, account_id, status) values (?,?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, element.getAmount());
        statement.setInt(2, element.getAccountId());
        statement.setInt(3, element.getStatus().ordinal());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            element.setId(resultSet.getInt(1));
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(Operation element) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("operation DAO");
    }

    @Override
    public boolean delete(Operation element) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("operation DAO");
    }

    @Override
    public Operation get(int id) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("operation DAO");
    }

    @Override
    public List<Operation> get() throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("operation DAO");
    }

    public List<Operation> getAllByAccountId(int accountId) throws  SQLException {
        List<Operation> operations = new ArrayList<>();
        request = "SELECT * FROM operation where account_id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, accountId);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Operation o = new Operation(resultSet.getInt("id"), resultSet.getDouble("amount"), accountId);
            operations.add(o);
        }
        return operations;
    }
}
