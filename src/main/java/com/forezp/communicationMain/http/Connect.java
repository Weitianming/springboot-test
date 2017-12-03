package com.forezp.communicationMain.http;

import com.alibaba.fastjson.JSONObject;

/**
 * 对接收信息反馈对应数据
 *
 * Created by Administrator on 2017/11/22/0022.
 */
public class Connect {
    private JSONObject jsonObject = new JSONObject();
    private String message = "";

    /**
     * 反馈登录信息
     * @param Result
     * @return
     */
    public JSONObject LoginResponse(String Result) {
        jsonObject.put("feedback",Result );
        jsonObject.put("operation","LoginResponse" );
        if (Result == "OK") {
            message = "登录成功";
        } else if (Result == "NOPassword") {
            message = "密码错误";
        } else {
            message = "账号未注册";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }

    /**
     * 反馈记住密码登录信息
     * @param Result
     * @return
     */
    public JSONObject AutomaticLoginResponse(String Result) {
        jsonObject.put("feedback",Result );
        jsonObject.put("operation","LoginResponse" );
        if (Result == "OK") {
            message = "登录成功";
        } else if (Result == "NOPassword") {
            message = "密码错误";
        } else {
            message = "账号未注册";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }

    /**
     * 反馈注册信息
     * @param Result
     * @return
     */
    public JSONObject RegisterResponse(String Result) {
        jsonObject.put("feedback",Result );
        jsonObject.put("operation","RegisterResponse" );
        if (Result == "OK") {
            message = "注册成功";
        } else if (Result == "NO") {
            message = "账号已注册";
        } else {
            message = "服务器出错";
        }
        jsonObject.put("message",message);
        return jsonObject;
    }

    /**
     * 获取账号下的所有好友
     * @param Result
     * @return
     */
    public JSONObject getAllUsersName(JSONObject Result) {
        jsonObject.put("feedback",Result );
        jsonObject.put("operation","getAllUsersName" );
        return jsonObject;
    }

    /**
     * 反馈消息信息
     * @param Result
     * @return
     */
    public JSONObject NoticeResponse(String Result) {
        jsonObject.put("feedback",Result );
        jsonObject.put("operation","NoticeResponse" );
        return jsonObject;
    }

    /**
     * 反馈注销信息
     * @param Result
     * @return
     */
    public JSONObject LogoutResponse(String Result) {
        jsonObject.put("feedback",Result );
        jsonObject.put("operation","LogoutResponse" );
        return jsonObject;
    }

    /**
     * 提示上线通知
     * @param Result
     * @return
     */
    public JSONObject onLoginResponse(String Result) {
        jsonObject.put("feedback",Result );
        jsonObject.put("operation","onLogin" );
        return jsonObject;
    }

    /**
     * 提示下线通知
     * @param Result
     * @return
     */
    public JSONObject onLogoutResponse(String Result) {
        jsonObject.put("feedback",Result );
        jsonObject.put("operation","onLogout" );
        return jsonObject;
    }

}
