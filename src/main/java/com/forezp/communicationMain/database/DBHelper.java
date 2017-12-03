package com.forezp.communicationMain.database;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * MySql数据库连接工具
 */
@Repository
public class DBHelper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询类方法
     * @param sql SQL语句
     * @param object 所需条件的参数
     * @return JSON格式
     */
    public JSONObject query (String sql, Object[] object) {
        JSONObject json = JSONObject.parseObject("{'object':" +  JSON.toJSONString(jdbcTemplate.queryForList(sql, object), true) + "}");
        return json;
    }

    /**
     * 增加类方法
     * @param sql SQL语句
     * @param object 所需条件的参数
     * @return 数字格式
     */
    public int adddate (String sql, Object[] object) {
        int i = jdbcTemplate.update(sql, object);
        return i;
    }

    /**
     * 删、改类方法
     * @param sql SQL语句
     * @param object 所需条件的参数
     * @return 数字格式
     */
    public int update (String sql, Object[] object) {
        int i = jdbcTemplate.update(sql, object);
        return i;
    }

}
