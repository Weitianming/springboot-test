package com.forezp.communicationMain.database;

import com.alibaba.fastjson.JSONObject;
import com.forezp.communicationMain.util.MySqlSentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 对MySql数据库的操作类
 * Created by Administrator on 2017/11/22/0022.
 */
@Service
public class DataBaseHelper extends MySqlSentence {
    private JSONObject json = null;
    private int in = 0;

    @Autowired
    private DBHelper dbHelper;

    /**
     * 查询账号是否存在
     *
     * @param username 账号
     * @return boolean
     */
    public boolean RegistrQuery(String username) {
        json = dbHelper.query(REGISTRQUERY, new Object[]{username});
        List li = (List) json.get("object");
        if (li.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 登录账号
     *
     * @param username 账号
     * @param password 密码
     * @return String
     */
    public String LoginDB(String username, String password) {
        if (RegistrQuery(username)) { // 该账号是否存在
            json = dbHelper.query(LOGINDB, new Object[]{username,password}); // 查询密码是否正确
            List li = (List) json.get("object");
            if (li.size() > 0) {
                return "OK";
            } else {
                return "NOPassword";
            }
        }
        return "NO";
    }

    /**
     * 注册账号
     *
     * @param username  账号
     * @param password 密码
     * @return String
     */
    public String RegistrDB(String username, String password) {
        if (!RegistrQuery(username)) { // 该账号是否存在
            in = dbHelper.update(REGISTRDB,  new Object[]{username,password}); // 查询密码是否正确
            if (in > 0) {
                return "OK";
            } else {
                return "Unknown";
            }
        }
        return "NO";
    }

}
