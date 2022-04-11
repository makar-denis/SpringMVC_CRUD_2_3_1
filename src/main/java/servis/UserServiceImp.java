package servis;

import dao.UserDao;
import dao.UserDaoImp;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Service
//@Transactional
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp (UserDao userDao){
        this.userDao = userDao;
//        init();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void change(User user){
        userDao.change(user);
    }

    @Transactional
    @Override
    public List<User> all(){
        return userDao.all();
    }

    @Transactional
    @Override
    public User getUser(long id){
        return userDao.getUser(id);
    }

//    @Transactional
//    @PostConstruct
//    public void init() {
//        add(new User( "Denis", "Markachev", "@1"));
//        add(new User("Dima", "Markachev", "@2"));
//        add(new User("Julia", "Markacheva", "@3"));
//    }
}
