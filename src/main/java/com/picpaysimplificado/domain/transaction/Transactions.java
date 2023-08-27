package com.picpaysimplificado.domain.transaction;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Transactions")
@Table(name = "Transactions")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name = "send.id")
    private User sender;
    @ManyToOne
    @JoinColumn(name = "recevir.id")
    private User reciver;
    private LocalDateTime timesLocalDateTime;

}
