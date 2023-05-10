package com.example.pharmacy_management_system.DAO;

import com.example.pharmacy_management_system.entity.User;

import java.util.List;

public interface UserDAO {
    boolean addUser(User user);
    boolean removeUser(int id);
    boolean updateUser(User user);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    List<User> getManagers();
    List<User> getPharmacists();
    List<User> getCashiers();
}
