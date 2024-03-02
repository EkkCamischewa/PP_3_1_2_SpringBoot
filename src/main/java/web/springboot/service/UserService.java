package web.springboot.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.springboot.dao.UserDao;
import web.springboot.model.User;

import java.util.List;

@Service
@Transactional
public class UserService {
     private final UserDao userDao;

     @Autowired
     public UserService(UserDao userDao) {
          this.userDao = userDao;
     }

     public List<User> getAllUsers(){
          return userDao.getAllUser();
     }
     public User getParticularUser(Long id){
          return userDao.getParticularUser(id);
     }

     public void addNewUser(User user){
          userDao.addNewUser(user);
     }

     public void updateUser(User user){
          userDao.updateUser(user);
     }


     public void deleteUser(Long id) {
          userDao.deleteUser(id);
     }
}
