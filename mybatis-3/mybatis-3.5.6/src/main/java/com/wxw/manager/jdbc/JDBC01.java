package com.wxw.manager.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName: JDBC01
 * @author: wxw
 * @date: 2020/7/17 15:26
 */
public class JDBC01 {

  public static void main(String[] args){
    insert("陈蓉01","uio12fasdHJ");
  }

  public static void insert(String username,String password){
    //使用占位符
    String sql = "insert into user(user_name,password) value(?,?)";

    Connection conn = DBUtil.open();
    try {
      //预编译
      PreparedStatement preparedStatement = conn.prepareStatement(sql);
      preparedStatement.setString(1,username);
      preparedStatement.setString(2,password);
      boolean execute = preparedStatement.execute();
      System.out.println(execute);
    } catch (SQLException e) {
      e.printStackTrace();
    }finally{
        DBUtil.close(conn);
    }


  }
}
