package org.example.service;

import org.example.dao.AccountDAO;
import org.example.dao.CustomerDAO;
import org.example.dao.OperationDAO;
import org.example.model.BankAccount;
import org.example.model.Customer;
import org.example.model.Operation;
import org.example.util.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BankService {
    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;
    private OperationDAO operationDAO;
    private Connection connection;

    public BankService(){
        try {
            connection = new DataBaseManager().getConnection();
            accountDAO = new AccountDAO(connection);
            customerDAO = new CustomerDAO(connection);
            operationDAO = new OperationDAO(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer createAndSaveCustomer(String firstname,String lastname,String phone){
        Customer customer = new Customer(firstname,lastname,phone);
        try{
            if(customerDAO.save(customer)){
                return customer;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public BankAccount createAndSaveAccount(int customerId) {
        BankAccount bankAccount = new BankAccount(customerId, 0);
        try {
            if(accountDAO.save(bankAccount)) {
               return bankAccount;
            }
        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
        return null;
    }

    public BankAccount getAccountAction(int id) {
        BankAccount bankAccount = null;

        try {
            bankAccount = accountDAO.get(id);
            if(bankAccount != null) {
                return bankAccount;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public boolean makeOperationDeposit(double montant,int idCompte){
        Operation operation = new Operation(montant, idCompte);
        BankAccount bankAccount = getAccountAction(idCompte);
        try {
            if(bankAccount.makeDeposit(operation) && operationDAO.save(operation) && accountDAO.update(bankAccount)) {
                return true;
            }
        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
        return false;
    }

    public boolean makeOperationWithDraw(double montant,int idCompte){
        Operation operation = new Operation(montant, idCompte);
        BankAccount bankAccount = getAccountAction(idCompte);
        try {
            if(bankAccount.makeWithDrawl(operation) && operationDAO.save(operation) && accountDAO.update(bankAccount)) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Operation> getAllOpertionByIdAccount(int id){
        try{
            return operationDAO.getAllByAccountId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
