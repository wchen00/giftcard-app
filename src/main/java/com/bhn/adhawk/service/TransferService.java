package com.bhn.adhawk.service;

import com.bhn.adhawk.beans.User;
import com.bhn.adhawk.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dnaga00 on 4/21/16.
 */

@Service("transferService")
public class TransferService {
    @Autowired
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public void transfer(Integer senderPhone, Integer receiverPhone, Double amount) {
//        User user_1 = userService.findById(senderId);
//        user_1.bhnCredit -= amount;
//        User user_2 = userService.findById(senderId);
//        user_2.bhnCredit += amount;
//        userService.saveOrUpdate(user_1);
//        userService.saveOrUpdate(user_2);
    }

}
