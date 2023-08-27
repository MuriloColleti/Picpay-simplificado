package com.picpaysimplificado.picpaysimplificado.domainuser;

import com.picpaysimplificado.picpaysimplificado.Repostory.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepostory repostory;

    public void ValidadeTransaction(User Sender , BigDecimal amount) throws Exception {
        if(Sender.getUserType() == UserType.MERCHAN) {
            throw new Exception("Usuario lojista não esta permitido a realizar transação");
        }
        if(Sender.getBalance().compareTo(amount) < 0 ){
            throw new Exception("Saldo insuficiente");
        }
    }
    public User findUserById(Long id) throws Exception {
        return (User) this.repostory.findUserById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    @Override
    public void Save(User user) {
    }
}
