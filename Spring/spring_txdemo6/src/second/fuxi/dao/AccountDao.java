package second.fuxi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void reduceMoney(){
        String sql="update t_account set  money=money-? where username=?";
        jdbcTemplate.update(sql,100,"lucy");

    }
    public void addMoney(){
        String sql="update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql,100,"mary");

    }


}
