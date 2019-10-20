package com.dongjiawei.tree_hold.entity;

import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserMapper {

    @Select("select * from manage_user where user_name=#{name}")
    UserInfo login(@Param("name") String name);

    @Update("UPDATE manage_user SET token=#{token} WHERE user_name=#{name} AND password=#{password}")
    void updateToken(@Param("name") String name,
                     @Param("password") String password,
                     @Param("token") String token);


    @Select("select * from manage_user limit #{start} , #{end}")
    List<UserInfo> findAll(@Param("start") int start,
                           @Param("end") int end);

    @Select("select count(*) from manage_user")
    int userSize();

    @Insert("insert into manage_user(user_name,password,token) values(#{user},#{pwd},#{token})")
    int addUser(@Param("user") String userName,
                @Param("pwd") String md5Password,
                @Param("token") String token);

    @Delete("delete from manage_user where id = #{id}")
    int deleteUser(@Param("id") String id);

    @Select("select * from manage_user where token=#{token}")
    UserInfo getUserFromToken(@Param("token") String token);
}
