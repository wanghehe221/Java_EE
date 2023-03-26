package org.wl.servlet_train.jluee.dao;


import javax.naming.Context;
import javax.naming.InitialContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;


public class BaseDao {
    private String bindName;
    private String bindValue;



    private Connection con; //数据库连接对象

    private PreparedStatement pstm; //数据库预编译处理对象

    public void setBindName(String bindName) {
        this.bindName = bindName;
    }

    public void setBindValue(String bindValue) {
        this.bindValue = bindValue;
    }

    public void getCon(){
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:/jboss/jdbc/servlet_train");
            con = ds.getConnection();
        }catch(Exception e){
            System.out.println("加载数据库驱动程序失败！");
            e.printStackTrace();
        }
    }
    //对象数组。如：String[] obj = new String[]{"宾桀锋","201321173083"};
    public void doPstm(String sql,Object[] params){
        if(sql!=null && !sql.equals("")){
            System.out.println(sql);
            if(con==null)
                getCon();
            try {
                pstm=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                if(params==null){
                    params=new Object[0];
                }
                for(int i=0;i<params.length;i++){
                    pstm.setObject(i+1,params[i]);
                    System.out.println(params[i]+"@@@@");
                }
                pstm.execute();
            } catch (SQLException e) {
                System.out.println("调用DB类中doPstm方法时出错！");
                e.printStackTrace();
            }
        }
    }

    public ResultSet getRs(){
        try {
            return pstm.getResultSet();
        } catch (SQLException e) {
            System.out.println("DB类中的getRs()方法出错！");
            e.printStackTrace();
            return null;
        }
    }

    public int getUpdate(){
        try {
            return pstm.getUpdateCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void closed(){
        try{
            if(pstm!=null)
                pstm.close();
        }catch(Exception e){
            System.out.println("关闭pstm对象失败！");
        }
        try{
            if(con!=null)
                con.close();
        }catch(Exception e){
            System.out.println("关闭con对象失败！");
        }
    }


}