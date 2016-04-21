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


    public List<User> findAll() {
        return userDao.findAll();
    }


    public void saveOrUpdate(User user) {

        if (findById(user.getId())==null) {
            userDao.save(user);
        } else {
            userDao.update(user);
        }

    }


    public void delete(int id) {
        userDao.delete(id);
    }

}
