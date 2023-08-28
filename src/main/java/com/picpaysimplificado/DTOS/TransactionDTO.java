package com.picpaysimplificado.DTOS;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, long senderId, long reciverId) {
}
