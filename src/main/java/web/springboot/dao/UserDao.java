package web.springboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import web.springboot.model.User;

import java.util.List;


@Repository
@Transactional
public class UserDao {


    @PersistenceContext
    private EntityManager entityManager;


    public List<User> getAllUser(){
        return entityManager
                .createQuery("from User", User.class)
                .getResultList();
    }

    @Transactional
    public User getParticularUser(Long id){
        return entityManager.find(User.class, id);
    }

    public void addNewUser(User user){
        entityManager.persist(user);
    }

    @Transactional
    public void updateUser(User user){
        entityManager.merge(user);
    }


    public void deleteUser(Long id) {
        entityManager.remove(getParticularUser(id));
    }
}
