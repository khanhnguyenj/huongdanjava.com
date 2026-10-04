package com.huongdanjava.springjdbctransactionmanagement.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import com.huongdanjava.springjdbctransactionmanagement.dao.AccountDAO;

@Repository
public class AccountDAOImpl implements AccountDAO {

  @Autowired private JdbcTemplate jdbcTemplate;

  public BigDecimal getCurrentAmount(int id) {
    String sql = "SELECT amount FROM account WHERE id=?";

    return jdbcTemplate.query(
        sql,
        new Object[] {id},
        new ResultSetExtractor<BigDecimal>() {
          public BigDecimal extractData(ResultSet resultSet)
              throws SQLException, DataAccessException {
            if (resultSet.next()) {
              return resultSet.getBigDecimal("amount");
            }

            return BigDecimal.ZERO;
          }
        });
  }

  public void updateAmount(int id, BigDecimal amount) {
    String sql = "UPDATE account SET amount=? WHERE id=?";

    jdbcTemplate.update(sql, amount, id);
  }
}
