package org.example.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int id;
    private int customerId;

    private Customer customer;

    private List<Operation> operations;

    private double totalAmount;


    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BankAccount(int customerId, double totalAmount) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.operations = new ArrayList<>();
    }

    public BankAccount(int id, int customerId, double totalAmount) {
        this(customerId, totalAmount);
        this.id = id;
    }


    public boolean makeDeposit(Operation operation) throws SQLException {
        if(operation.getAmount() > 0) {
            operations.add(operation);
            totalAmount += operation.getAmount();
            return true;
        }
        return false;
    }
    public boolean makeWithDrawl(Operation operation) throws SQLException {
        if(operation.getAmount() < 0 && getTotalAmount() >= operation.getAmount()*-1) {
            operations.add(operation);
            totalAmount += operation.getAmount();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", customer=" + customer +
                ", operations=" + operations +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
