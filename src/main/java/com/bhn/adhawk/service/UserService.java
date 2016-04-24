package com.bhn.adhawk.service;

import com.bhn.adhawk.beans.User;
import com.bhn.adhawk.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dnaga00 on 4/21/16.
 */

@Service("userService")
public class UserService {

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findById(Integer id) {
        return userDao.findById(id);
    }

    public User findByPhone(String phoneNumber) {
        return userDao.findByPhone(phoneNumber);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void saveOrUpdate(User user) {

        User initUser = findById(user.getShareFrom());
        System.out.println("initial user credit :"+initUser.getBhnCredit());

        if(user.getBhnCredit() < initUser.getBhnCredit()) {

            initUser.setBhnCredit(initUser.getBhnCredit() - user.getBhnCredit());
            userDao.update(initUser);

            if (findByPhone(user.getPhoneNumber()) == null) {

                User newUser = new User();
                newUser.setPhoneNumber(user.getPhoneNumber());
                newUser.setBhnCredit(user.getBhnCredit());

                System.out.println("Create new user "+newUser.getPhoneNumber());
                userDao.save(newUser);

            } else {
                User finalUser = findByPhone(user.getPhoneNumber());
                System.out.println("Existing user "+finalUser.getUserName());

                finalUser.setBhnCredit(finalUser.getBhnCredit()+user.getBhnCredit());
                System.out.println("Save Existing user amount "+finalUser.getBhnCredit());
                userDao.update(finalUser);
            }

        }else
        {
            System.out.println("Cannot process transactions. Funds are not sufficient");
        }

    }

    public void delete(int id) {
        userDao.delete(id);
    }

}
