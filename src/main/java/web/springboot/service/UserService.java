package web.springboot.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.springboot.dao.UserDaoInt;
import web.springboot.model.User;

import java.util.List;
@Service
public class UserService implements UserServiceInt {
     private final UserDaoInt userDao;

     @Autowired
     public UserService(UserDaoInt userDao) {
          this.userDao = userDao;
     }

     public List<User> getAllUsers(){
          return userDao.getAllUsers();
     }

     public User getParticularUser(Long id){
          return userDao.getParticularUser(id);
     }

     @Transactional
     public void addNewUser(User user){
          userDao.addNewUser(user);
     }

     @Transactional
     public void updateUser(User user){
          userDao.updateUser(user);
     }

     @Transactional
     public void deleteUser(Long id) {
          userDao.deleteUser(id);
     }
}
