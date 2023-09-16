package com.picpaysimplificado.controllers;

import com.picpaysimplificado.dtos.TransactionDTO;
import com.picpaysimplificado.domain.transaction.Transactions;
import com.picpaysimplificado.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/transactions")

public class TransactionController {
    @Autowired
    private TransactionsService transactionsService;

    @PostMapping
    public Transactions CreateTransactions(@RequestBody TransactionDTO transaction) throws Exception {
        Transactions newTransactions = transactionsService.createTransaction(transaction);
        return new ResponseEntity<>(newTransactions, HttpStatus.CREATED).getBody();
    }
    @GetMapping
    public ResponseEntity<List<Transactions>> getAllTransactions(){
        List<Transactions> transactions = this.transactionsService.findAll();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
