package com.forezp.web;


import com.alibaba.fastjson.JSONObject;
import com.forezp.communicationMain.http.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/communication/*", description = "实时通讯软件")
public class HelloController extends HttpServlet {
    private JSONObject jsonObject;
    private String str = "";

    @RequestMapping("/")
    public String index() {
        return "实时通讯后台服务已开启";
    }

    @Autowired
    private JsonParam jsonParam;

    // Get请求接口
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp); // 将get请求转向post请求
//        initResp(resp).getWriter().write("get请求测试");
    }

    // Post请求接口
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        jsonObject = jsonParam.Param(req);
        if (jsonObject.size() > 0) {
            str = jsonObject.toString();
        } else {
            str = "post请求测试";
        }
        System.out.println(str);
        initResp(resp).getWriter().write(str);
    }

    // 接口格式
    private HttpServletResponse initResp (HttpServletResponse resp) {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        return resp;
    }

}