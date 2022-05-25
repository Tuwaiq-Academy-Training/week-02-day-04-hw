package com.example.cardealership.service;

import com.example.cardealership.model.Car;
import com.example.cardealership.model.User;
import com.example.cardealership.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    List<User> users = new ArrayList<>();


    public UserService() {
        ArrayList<Car> cars = null;
        this.users.addAll(
                List.of(
                        new User("101","Suv", "1200",3000,cars),
                        new User("102","Ahmed", "1300",2000,cars),
                        new User("103","Salah", "1400",400,cars),
                        new User("104","Ali", "1500",500,cars)
                ));
    }
    public List<User> getUsers(){
        return users;
    }

    public void updateRide(User user, User c){
        user.setUsername(c.getUsername());
        user.setBalance(c.getBalance());
    }

    public boolean deleteUser(String id){

        if (isUserByID(id)){
            User user = getById(id);
            getUsers().remove(user);
            return true;
        }
        return false;
    }

    public boolean isUserByID(String id){
        int checkForWork = -1;
        User user = getById(id);
        if (user != null){
            checkForWork = Integer.parseInt(id);
        }
        return (checkForWork == -1) ? false :  true;
    }

    public boolean addUser(User user){
        return users.add(user);
    }
    public  User getById(String id){
        for (User user: this.users) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

}
