package dao;

import models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
//@Component
//@Transactional
public class UserDaoImp implements UserDao{

        @PersistenceContext
        private EntityManager entityManager;

        public UserDaoImp() {
            this.entityManager = entityManager;
        }

        @Transactional
        @Override
        public void add (User user) {
            entityManager.persist(user);
        }

        @Transactional
        @Override
        public void delete(long id){
//        User delete = entityManager.find(User.class, id); перенес в remove
            entityManager.remove(entityManager.find(User.class, id));
        }

    public User getUser(long id){
        return entityManager.find(User.class, id);
    }

        @Transactional
        @Override
        public void change(long id, User user){
            User c = entityManager.find(User.class, id);
            c.setLastName(user.getLastName());
            c.setEmail(user.getEmail());
            c.setFirstName(user.getFirstName());
            entityManager.merge(c);
        }
        @Transactional
        @Override
        public List<User> all(){
////        entityManager.createQuery("DELETE from User").executeUpdate();//использоал для очистки таблицы
            return entityManager.createQuery("from Userr", User.class).getResultList();
//            return null;
//
        }
}


