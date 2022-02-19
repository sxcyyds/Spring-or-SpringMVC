package second.fuxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import second.fuxi.dao.AccountDao;
@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public void money(){
//        减钱
        accountDao.reduceMoney();
        System.out.println(10/0);

//        加钱
        accountDao.addMoney();
    }
}
