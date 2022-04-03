package servis;

import dao.UserDao;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Repository
@Service
//@Transactional
public class UserServiceImp implements UserService {

//    private List<User> list;
//    {
//        list=new ArrayList<>();
//        list.add(new User("User1", "Lastname1", "user1@mail.ru"));
//    }

//    public UserServiceImp(List<User> list) {
//        this.list = list;
//        list.add(new User("User1", "Lastname1", "user1@mail.ru"));
//    }


    private UserDao userDao;

    @Autowired
    public UserServiceImp (UserDao userDao){
        this.userDao = userDao;
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
    public void change(long id, User user){
        userDao.change(id, user);
    }
    @Transactional
    @Override
    public List<User> all(){
//        return list;
        return userDao.all();
//        return null;
    }

    @Transactional
    @Override
    public User getUser(long id){
        return userDao.getUser(id);
    }


}
