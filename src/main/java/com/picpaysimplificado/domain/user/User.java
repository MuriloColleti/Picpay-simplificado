package com.picpaysimplificado.domain.user;

import com.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal Balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO date){
        this.firstName = date.firtName();
        this.userType = date.userType();
        this.password = date.passoword();
        this.email = date.email();
        this.Balance = date.Balance();
        this.document = date.document();
    }

}
