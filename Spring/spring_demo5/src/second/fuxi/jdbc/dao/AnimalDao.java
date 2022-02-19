package second.fuxi.jdbc.dao;

import com.atguigu.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import second.fuxi.jdbc.bean.Animal;


import java.util.Arrays;
import java.util.List;

@Repository
public class AnimalDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//添加动物信息
    public int add(Animal animal){
        String sql="insert into t_user(id,username,ustatus) values(?,?,?)";
        int update = jdbcTemplate.update(sql, animal.getId(), animal.getUsername(), animal.getUstatus());
        return update;
    }
//    根据id删除动物信息
    public int delById(Integer id){
        String sql="delete * from t_user where id=?";
        int update = jdbcTemplate.update(sql, id);
        return update;

    }

    //修改动物信息
    public int update(Animal animal){
        String sql="update t_user set username=?,ustatus=? where id=?";
        int update = jdbcTemplate.update(sql, animal.getUsername(), animal.getUstatus(), animal.getId());
        return update;
    }
//    查询一条记录
    public Animal selectOneById(Integer id){
        String sql="select * From t_user where id=?";
        Animal animal = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Animal.class), id);
        return animal;
    }
//    查询多条数据
public java.util.List<Animal> findAllAnimal() {
    String sql="select * from t_user";
    List<Animal> animals =jdbcTemplate.query(sql,new BeanPropertyRowMapper<Animal>(Animal.class));

    return animals;
    }
//批量添加
    public void addPi(List<Object[]> piliang){
        String sql="insert into t_user(id,username,ustatus) values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, piliang);
        System.out.println(Arrays.toString(ints));

    }

}



