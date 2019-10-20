package com.dongjiawei.tree_hold.entity;


import java.util.List;


public interface UserService {
    List<UserInfo> findAll(int start, int end);
//    int addUser(UserInfo userInfo);

    UserInfo login(String name);

    int totalUser();

    List<UserInfo> getUserList(int start, int end);

    void upDateToken(String name,String password,String token);

    int addUser(String userName, String md5Password,String token);

    int deleteUser(String id);

    UserInfo getUserFromToken(String token);

//    int addThermometer(Thermometer thermometer);
//    List<Thermometer> getThermometers(String startTime, String endTime);
}
