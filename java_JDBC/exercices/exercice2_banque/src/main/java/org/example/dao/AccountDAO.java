package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.model.BankAccount;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AccountDAO extends BaseDAO<BankAccount> {
    public AccountDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(BankAccount element) throws SQLException {
        request = "INSERT INTO bank_account (total_amount, customer_id) values (?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, element.getTotalAmount());
        statement.setInt(2, element.getCustomerId());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            element.setId(resultSet.getInt(1)) ;
        }
        return nbRow == 1;
    }

    @Override
    public boolean update(BankAccount element) throws SQLException {
        request = "UPDATE bank_account set total_amount = ? where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setDouble(1, element.getTotalAmount());
        statement.setInt(2, element.getId());
        int nbRow = statement.executeUpdate();
        return nbRow == 1;
    }

    @Override
    public boolean delete(BankAccount element) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Account");
    }

    @Override
    public BankAccount get(int id) throws SQLException {
        BankAccount bankAccount = null;
        request = "SELECT * FROM bank_account where id = ?";
        statement = _connection.prepareStatement(request);
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if(resultSet.next()) {
            bankAccount = new BankAccount(resultSet.getInt("id"),
                    resultSet.getInt("customer_id"),
                    resultSet.getDouble("total_amount")
            );
        }
        return bankAccount;
    }

    @Override
    public List<BankAccount> get() throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Account");
    }
}
