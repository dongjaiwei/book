package com.dongjiawei.tree_hold.entity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public List<UserInfo> findAll(int start, int end) {
        return userMapper.findAll(start,end);
    }

    public UserInfo login(String name) {

        return userMapper.login(name);
    }

    public int totalUser() {
        return userMapper.userSize();
    }

    public List<UserInfo> getUserList(int start, int end) {
       return userMapper.findAll(start,end);
    }

    public void upDateToken(String name,String password,String token){
        userMapper.updateToken(name,password,token);
    }

    public int addUser(String userName, String md5Password ,String token) {
       return userMapper.addUser(userName,md5Password,token);
    }


    public int deleteUser(String id) {
       return userMapper.deleteUser(id);
    }

    public UserInfo getUserFromToken(String token) {
        return userMapper.getUserFromToken(token);
    }


//    @Override
//    public int addThermometer(Thermometer thermometer) {
//        userMapper.addThermometer(thermometer);
//        return thermometer.getId();
//    }

//    @Override
//    public List<Thermometer> getThermometers(String startTime, String endTime) {
//        return userMapper.getThermometers(startTime,endTime);
//    }


}

