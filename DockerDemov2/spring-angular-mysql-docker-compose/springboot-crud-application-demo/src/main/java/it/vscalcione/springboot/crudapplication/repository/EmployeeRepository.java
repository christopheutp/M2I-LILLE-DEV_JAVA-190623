package it.vscalcione.springboot.crudapplication.repository;

import it.vscalcione.springboot.crudapplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
