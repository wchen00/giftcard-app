package com.bhn.adhawk.dao;

/**
 * Created by dnaga00 on 4/21/16.
 */

import com.bhn.adhawk.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserDao  {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    HashMap<String, User> users = new HashMap<>();

    @Autowired
    public void setNamedParameterJdbcTemplate(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Autowired
    public void setUsers()
    {
        this.users = users;
    }

    public User findById(String id) {
        User result=null;

/*        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String sql = "SELECT * FROM users WHERE id=:id";

        User result = null;
        try {
            result = namedParameterJdbcTemplate
                    .queryForObject(sql, params, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }*/

        if(users.size() > 0) {
           result = users.get(id);
        }

        return result;
    }

    public User findByPhone(String phoneNumber) {

/*        System.out.println("Find user with phone number :"+phoneNumber);
        Map<String, String> params = new HashMap<String, String>();
        params.put("phoneNumber", phoneNumber);

        String sql = "SELECT * FROM users WHERE PHONENUMBER=:phoneNumber";

        User result = null;
        try {
            result = namedParameterJdbcTemplate
                    .queryForObject(sql, params, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Exception while retrieving account with phone number "+e.getMessage());
        }

        if(result!=null) {
            System.out.println("result :" + result.getId());
        }*/

        User result = users.get(phoneNumber);
        return result;
    }

    public List<User> findAll() {

        /*String sql = "SELECT * FROM users";
        List<User> result = namedParameterJdbcTemplate.query(sql, new UserMapper());*/

        List<User> result = new ArrayList<User>( users.values());
        return result;

    }


    public void save(User user) {

/*        System.out.println("Saving user with phone number "+user.getPhoneNumber());
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO USERS(USERNAME,  PHONENUMBER, BHNCREDIT) "
                + "VALUES ( :userName,  :phoneNumber,  :bhnCredit)";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user), keyHolder);*/

        System.out.println("User phone number "+user.getPhoneNumber());
        user.setId(user.getPhoneNumber());
        users.put(user.getPhoneNumber(), user);
        System.out.println("Saving user with phone number "+user.getId());

    }

    public void update(User user) {

/*        String sql = "UPDATE USERS SET BHNCREDIT=:bhnCredit, PHONENUMBER=:phoneNumber";
        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));*/

        System.out.println("Updating user "+user.getPhoneNumber()+":"+user.getBhnCredit());
        users.put(user.getId(), user);

    }


    public void delete(Integer id) {

        String sql = "DELETE FROM USERS WHERE id= :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

    }

    private SqlParameterSource getSqlParameterByModel(User user) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("userName", user.getUserName());
        paramSource.addValue("phoneNumber", user.getPhoneNumber());
        paramSource.addValue("bhnCredit", user.getBhnCredit());

        return paramSource;
    }
/*
    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("USERNAME"));
            user.setBhnCredit(rs.getInt("BHNCREDIT"));
            user.setPhoneNumber(rs.getString("phoneNumber"));
            user.setCreditCardNumber(rs.getString("CREDIT_CARD_NUMBER"));
            user.setCvv(rs.getInt("cvv"));
            user.setMonth(rs.getString("month"));
            user.setYear(rs.getString("year"));

            return user;
        }
    }*/
}
