package com.picpaysimplificado.Controllers;

import com.picpaysimplificado.DTOS.TransactionDTO;
import com.picpaysimplificado.domain.transaction.Transactions;
import com.picpaysimplificado.services.TransactionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/transactions")

public class TransactionController {

    private TransactionsService transactionsService;

    @PostMapping
    public Transactions CreateTransactions(@RequestBody TransactionDTO transaction) throws Exception {
        Transactions newTransactions = transactionsService.createTransaction(transaction);
        return new ResponseEntity<>(newTransactions, HttpStatus.CREATED).getBody();
    }
    @PostMapping
    public ResponseEntity<List<Transactions>> getAllTransactions(){
        List<Transactions> transactions = this.transactionsService.findAll();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
