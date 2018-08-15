/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guruofjava.test.dao;

import com.guruofjava.test.model.Users;
import java.util.List;

/**
 *
 * @author ArshiaAziz
 */
public interface UserDAO {
    public List<Users> getAllUsers();
    public void addUser(Users user);
}
