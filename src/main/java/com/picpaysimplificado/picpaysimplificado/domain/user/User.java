package com.picpaysimplificado.picpaysimplificado.domain.user;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
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





}
