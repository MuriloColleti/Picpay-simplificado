package com.picpaysimplificado.services;

import com.picpaysimplificado.DTOS.TransactionDTO;
import com.picpaysimplificado.domain.transaction.Transactions;
import com.picpaysimplificado.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.picpaysimplificado.Repostory.TransactionRepository;
import org.springframework.web.client.RestTemplate;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionsService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionsService repository;

    @Autowired
    private RestTemplate restTemplate;

    public void createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User reciver = this.userService.findUserById(transaction.reciverId());

        userService.ValidadeTransaction(sender, transaction.value());

        boolean isAuthored = this.authorizeTransaction(sender, transaction.value());
        if (!isAuthored) {
            throw new Exception("Transação não Autorizada");
        }
        Transactions newtransaction = new Transactions();
        newtransaction.setAmount(transaction.value());
        newtransaction.setSender(sender);
        newtransaction.setReciver(reciver);
        newtransaction.setTimesLocalDateTime(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        reciver.setBalance((reciver.getBalance().add(transaction.value())));

        userService.saveUser(sender);
        userService.saveUser(reciver);
    }

    private void save(Transactions newtransaction) {
        this.repository.save(newtransaction);
    }


    public boolean authorizeTransaction(User sender, BigDecimal amount) {
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);

        if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
            String message = (String) authorizationResponse.getBody().get("message");
            return "Autorizado".equalsIgnoreCase(message);
        }
        return false;

    }
}




