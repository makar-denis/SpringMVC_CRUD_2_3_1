package dao;

import models.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(long id);
    void change(User user);
    User getUser(long id);
    List<User> all();


}
