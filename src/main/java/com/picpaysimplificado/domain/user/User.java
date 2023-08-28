package com.picpaysimplificado.domain.user;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.UserDatabase;

import java.math.BigDecimal;
import java.util.Iterator;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements org.apache.catalina.User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String Name;
    private String lastName;

    @Column(unique = true)
    private String Doccument;

    @Column(unique = true)
    private String email;

    private String passoword;

    private BigDecimal Balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;


    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public void setFullName(String s) {

    }

    @Override
    public Iterator<Group> getGroups() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String s) {

    }

    @Override
    public Iterator<Role> getRoles() {
        return null;
    }

    @Override
    public UserDatabase getUserDatabase() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public void setUsername(String s) {

    }

    @Override
    public void addGroup(Group group) {

    }

    @Override
    public void addRole(Role role) {

    }

    @Override
    public boolean isInGroup(Group group) {
        return false;
    }

    @Override
    public boolean isInRole(Role role) {
        return false;
    }

    @Override
    public void removeGroup(Group group) {

    }

    @Override
    public void removeGroups() {

    }

    @Override
    public void removeRole(Role role) {

    }

    @Override
    public void removeRoles() {

    }
}
