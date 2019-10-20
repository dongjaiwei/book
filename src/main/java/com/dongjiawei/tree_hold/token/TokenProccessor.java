package com.dongjiawei.tree_hold.token;

import org.springframework.util.DigestUtils;

import java.util.Random;

public class TokenProccessor {

    private TokenProccessor(){};
    private static final TokenProccessor instance = new TokenProccessor();

    public static TokenProccessor getInstance() {
        return instance;
    }

    /**
     * 生成Token
     * @return
     */
    public String makeToken() {
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        return DigestUtils.md5DigestAsHex(token.getBytes());
    }
}
