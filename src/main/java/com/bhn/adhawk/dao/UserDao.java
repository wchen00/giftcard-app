package com.bhn.adhawk.dao;

/**
 * Created by dnaga00 on 4/21/16.
 */
import com.bhn.adhawk.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class UserDao  {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public User findById(Integer id) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String sql = "SELECT * FROM users WHERE id=:id";

        User result = null;
        try {
            result = namedParameterJdbcTemplate
                    .queryForObject(sql, params, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            // do nothing, return null
        }

        return result;

    }


    public List<User> findAll() {

        String sql = "SELECT * FROM users";
        List<User> result = namedParameterJdbcTemplate.query(sql, new UserMapper());
        return result;

    }


    public void save(User user) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO USERS(ID, USERNAME, PASSWORD, PHONE_NUMBER, CREDIT_CARD_NUMBER, CVV, MONTH, YEAR, BHN_CREDIT) "
                + "VALUES ( :id, :username, :password, :phoneNumber, :creditCardNumber, :cvv, :month, :year, :bhnCredit)";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user), keyHolder);
        user.setId(keyHolder.getKey().intValue());

    }


    public void update(User user) {

        String sql = "UPDATE USERS SET BHN_CREDIT=:bhnCredit, PHONE_NUMBER=:phoneNumber";

        namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));

    }


    public void delete(Integer id) {

        String sql = "DELETE FROM USERS WHERE id= :id";
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));

    }

    private SqlParameterSource getSqlParameterByModel(User user) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("userName", user.userName);
        paramSource.addValue("phoneNumber", user.phoneNumber);
        paramSource.addValue("bhnCredit", user.bhnCredit);

        return paramSource;
    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
            user.setBhnCredit(rs.getString("bhnCredit"));
            user.setCreditCardNumber(rs.getString("creditCardNumber"));
            user.setCvv(rs.getString("cvv"));
            user.setMonth(rs.getString("month"));
            user.setYear(rs.getString("year"));

            return user;
        }
    }

    private static List<String> convertDelimitedStringToList(String delimitedString) {

        List<String> result = new ArrayList<String>();

        if (!StringUtils.isEmpty(delimitedString)) {
            result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
        }
        return result;

    }

    private String convertListToDelimitedString(List<String> list) {

        String result = "";
        if (list != null) {
            result = StringUtils.arrayToCommaDelimitedString(list.toArray());
        }
        return result;

    }

}
