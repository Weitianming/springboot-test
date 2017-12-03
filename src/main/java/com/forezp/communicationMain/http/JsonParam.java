package com.forezp.communicationMain.http;


import com.alibaba.fastjson.JSONObject;
import com.forezp.communicationMain.database.DataBaseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/11/22/0022.
 */
@Service
public class JsonParam {
    private HttpServletRequest req;

    @Autowired
    private DataBaseHelper dataBaseHelper;


    public JSONObject Param(HttpServletRequest req) {
        this.req = req;
        return JsonAnalytical(req.getRequestURI());
    }

    public JSONObject JsonAnalytical(String str) {

        if (str.equals("/communication/login")) { // 登录请求
            return new Connect().LoginResponse(dataBaseHelper.LoginDB(
                    req.getParameter("username"), req.getParameter("password"), Boolean.parseBoolean(req.getParameter("isRemember")),req.getParameter("macAddress")
            ));
        }else if (str.equals("/communication/automaticLogin")){ // 记住密码
            return new Connect().AutomaticLoginResponse(dataBaseHelper.LoginDB(
                    req.getParameter("username"), req.getParameter("password"), Boolean.parseBoolean(req.getParameter("isRemember")),req.getParameter("macAddress")
            ));
        } else if (str.equals("/communication/register")) { // 注册请求
            return new Connect().RegisterResponse(dataBaseHelper.RegistrDB(
                    req.getParameter("username"), req.getParameter("password")
            ));
        } else if (str.equals("/communication/getAllUsersName")) { // 获取好友列表
//            return new Connect().getAllUsersName("");
            return new Connect().getAllUsersName(dataBaseHelper.FriendsDB(
                    req.getParameter("username")
            ));
        } else if (str.equals("/communication/notice")) { // 消息
            return new Connect().NoticeResponse("");
        } else if (str.equals("/communication/logout")) { // 注销
            return new Connect().LogoutResponse("");
        } else if (str.equals("/communication/onLogin")) { // 上线提醒
            return new Connect().onLoginResponse("");
        } else if (str.equals("/communication/onLogout")) { // 下线提醒
            return new Connect().onLogoutResponse("");
        }

        return null;
    }

}
