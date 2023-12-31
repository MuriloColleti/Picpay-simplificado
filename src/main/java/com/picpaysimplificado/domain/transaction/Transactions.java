package com.picpaysimplificado.domain.transaction;

import com.picpaysimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Transactions")
@Table(name = "Transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
