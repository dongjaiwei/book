package com.dongjiawei.tree_hold.server;

import com.dongjiawei.tree_hold.aop.action.LoginAction;
import com.dongjiawei.tree_hold.dto.ListResult;
import com.dongjiawei.tree_hold.dto.MyResponse;
import com.dongjiawei.tree_hold.entity.UserInfo;
import com.dongjiawei.tree_hold.entity.UserService;
import com.dongjiawei.tree_hold.token.TokenProccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class Login {
    final String SUFFIX = "dongjiawei";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public MyResponse login(@RequestBody Map<String, String> json) {
        MyResponse myResponse = new MyResponse(200, "登陆成功", "登陆成功");
        String name = json.get("name");
        String md5Password = DigestUtils.md5DigestAsHex((json.get("password") + SUFFIX).getBytes());
        UserInfo login = userService.login(name);
        String token = TokenProccessor.getInstance().makeToken();
        if (login == null) {
            myResponse.setCode(403);
            myResponse.setMessage("用户不存在");
            myResponse.setData("用户不存在");
        } else {
            if (!login.getPassword().endsWith(md5Password)) {
                myResponse.setCode(403);
                myResponse.setMessage("密码错误");
                myResponse.setData("密码错误");
            } else {
                userService.upDateToken(name, md5Password, token);
                myResponse.setData(token);
            }
        }
        return myResponse;
    }

    @LoginAction
    @RequestMapping(value = "getUserList", method = RequestMethod.POST)
    public MyResponse getUserList(@RequestBody Map<String, String> json) {
        String start = json.get("start");
        String end = json.get("end");
        int i = userService.totalUser();
        List<UserInfo> userList = userService.getUserList(Integer.valueOf(start), Integer.valueOf(end));
        ListResult<UserInfo> userInfoListResult = new ListResult<>(i, userList);
        return new MyResponse<>(200, "请求成功", userInfoListResult);

    }

    @LoginAction
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public MyResponse<Integer> addUser(@RequestBody Map<String, String> json) {
        String userName = json.get("userName");
        String md5Password = DigestUtils.md5DigestAsHex((json.get("password") + SUFFIX).getBytes());
        String token = TokenProccessor.getInstance().makeToken();
        UserInfo login = userService.login(userName);
        if(login != null){
            return new MyResponse<>(400,"用户已存在",200);
        }
        int i = userService.addUser(userName, md5Password, token);
        return new MyResponse<>(200,"添加成功",i);

    }

    @LoginAction
    @RequestMapping(value = "deleteUser",method = RequestMethod.POST)
    public MyResponse<Integer> deleteUser(@RequestBody Map<String, String> json){
        String id = json.get("id");
        int i = userService.deleteUser(id);
        return new MyResponse<>(200,"删除成功",i);
    }

    @RequestMapping(value = "addMessage",method = RequestMethod.POST)
    public MyResponse<Integer> addMessage(@RequestBody Map<String, String> json){
        int i = 0;

        return new MyResponse<>(200,"添加成功",i);

    }

}
