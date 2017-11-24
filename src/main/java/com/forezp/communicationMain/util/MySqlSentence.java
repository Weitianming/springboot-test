package com.forezp.communicationMain.util;

/**
 * Created by Administrator on 2017/11/23/0023.
 */
public class MySqlSentence {
    public String REGISTRQUERY = "select * from personal where username = ?"; // 查询账号是否存在
    public String LOGINDB = "select * from personal where username = ? and password = ?"; // 登录账号
    public String REGISTRDB = "insert into personal(username, password) values(?, ?)"; // 注册账号


}
