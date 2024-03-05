package web.springboot.dao;



import web.springboot.model.User;

import java.util.List;

public interface UserDaoInt {
    List<User>  getAllUsers();
    User getParticularUser(Long id);
    void addNewUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}
