package org.example.entity.oneToMany;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

    private String password;

    private Date createTime;

    @ManyToOne
    @JoinColumn(name="id_group")
    private Group groupe;

    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Group getGroup() {
        return groupe;
    }

    public void setGroup(Group group) {
        this.groupe = group;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", group=" + groupe +
                '}';
    }
}
