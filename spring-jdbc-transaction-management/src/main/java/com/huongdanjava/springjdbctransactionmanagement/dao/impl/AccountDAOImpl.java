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

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public BigDecimal getCurrentAmount(int id) {
    String sql = "SELECT amount FROM account WHERE id=" + id;

    return jdbcTemplate.query(sql, new ResultSetExtractor<BigDecimal>() {
      public BigDecimal extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        if (resultSet.next()) {
          return BigDecimal.valueOf(resultSet.getInt("amount"));
        }

        return BigDecimal.ZERO;
      }
    });
  }

  public void updateAmount(int id, BigDecimal amount) {
    String sql = String.format("UPDATE account SET amount=%f WHERE id=%d", amount, id);

    jdbcTemplate.execute(sql);
  }
}
