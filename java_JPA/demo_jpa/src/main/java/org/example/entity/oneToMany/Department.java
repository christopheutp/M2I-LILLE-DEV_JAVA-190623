package org.example.entity.oneToMany;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Department {

    @Id
    private int id;

    private String dname;

    @OneToMany(mappedBy = "d")
    private Collection<Employee> emps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Collection<Employee> getEmps() {
        return emps;
    }

    public void setEmps(Collection<Employee> emps) {
        this.emps = emps;
    }
}
