package service;

import dao.UserDao;
import dao.UserDaoImp;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserService {
    private UserDao dao;

    public void setDao(UserDaoImp dao) {
        this.dao = dao;
    }


    public void add(){
        System.out.println("service add.......");
        dao.update();

//        创建userdao对象
        //原始方式
//        UserDao userDao = new UserDaoImp();
//        userDao.update();

        // spring实现       将创建userdao对象并调用其方法的过程用spring实现
    }

}
