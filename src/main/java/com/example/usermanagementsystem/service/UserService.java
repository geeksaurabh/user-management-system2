package com.example.usermanagementsystem.service;

import com.example.usermanagementsystem.model.UserModel;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {
    private static List<UserModel> users=new ArrayList<>();
    private static int usersCount=0;

    static {
        users.add(new UserModel(1,"saurabh","saurabh pandey","lko city gomtinagar","3208732986"));
        users.add(new UserModel(2,"gaurav","gaurav pandey","lko city aloganj","98357394"));
        users.add(new UserModel(3,"nitesh","nitesh awasthi","lko city jankipuram","0934827"));
        users.add(new UserModel(4,"alok","alok shukla","lko city hazratganj","0937598346"));
        users.add(new UserModel(5,"andrew","TOP G","romania jail","0373945"));
        
    }

    public List<UserModel> findAll() { // Business Logic
        return users;
    }
//
    public UserModel findByUserId(int userId) {
//        Predicate<? super UserModel> predicate = user -> user.getUserId() == userId;
//        UserModel user = users.stream().filter(predicate).findFirst().get();
//        return user;
        for(UserModel u:users){
           if(u.getUserId()==userId) {
               return u;
           }
        }
         return null;
    }
//
    public void addUser(UserModel user) {
        users.add(user);
    }

//
    public void deleteUser(int userId) {

        Predicate<? super UserModel> predicate = user -> user.getUserId() == userId;
        users.removeIf(predicate);
    }

    public void updateUser(int userId,UserModel newUser) {


        UserModel user=findByUserId(userId);// step 1

        user.setUserId(newUser.getUserId());
        user.setUserName(newUser.getUserName());
        user.setAddress(newUser.getAddress());
    }
}
