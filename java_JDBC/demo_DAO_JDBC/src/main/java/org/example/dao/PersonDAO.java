package org.example.dao;

import org.example.model.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonDAO extends BaseDAO<Person> {
    protected PersonDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Person element) throws SQLException {
        request = "INSERT INTO person (first_name, last_name) VALUES (?,?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getFirstName());
        statement.setString(2, element.getLastName());
        int nbRows = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRows == 1;
    }

    @Override
    public boolean update(Person element) {
        return false;
    }

    @Override
    public boolean delete(Person element) {
        return false;
    }

    @Override
    public Person get(int id) {
        return null;
    }

    @Override
    public List<Person> get() {
        return null;
    }
}
