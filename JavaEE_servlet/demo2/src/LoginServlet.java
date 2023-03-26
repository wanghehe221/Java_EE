import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JDBC jd=new JDBC();

        req.setCharacterEncoding("UTF-8");

        String sid=req.getParameter("username");
        String spass=req.getParameter("password");
        HttpSession session=req.getSession();

        session.setAttribute("Name", sid);
        session.setAttribute("Pass", spass);
        System.out.println(sid+"####"+spass);


        try{

            int pass1=Integer.parseInt(spass);
            if(jd.conMy(sid,pass1)){

                req.getRequestDispatcher("success.jsp").forward(req,resp);
            }else{

                req.setAttribute("Msg","用户名或密码错误");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}




class JDBC {

    public  boolean conMy(String name1,int passwordd) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        int passww;

       try{
           Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "wangleikuaile1");

           Statement statement = connection.createStatement();

           String sql = "SELECT passwd1 FROM sys.users1 where name1=";
           sql=sql+"'"+name1+"';";
           ResultSet resultSet = statement.executeQuery(sql);
           if(resultSet==null){
               resultSet.close();
               statement.close();
               connection.close();
               return false;
           }
           while(resultSet.next()){
               passww = resultSet .getInt("passwd1");
               if(passww == passwordd)
               {
                   resultSet.close();
                   statement.close();
                   connection.close();
                   return true;
               }
           }

           resultSet.close();
           statement.close();
           connection.close();
           return false;
       }catch (Exception e){
           System.out.println(e);
       }
     return false;
    }

    public  int doRes(String name2,int passwordd) throws SQLException, ClassNotFoundException {
        int id1=-1;
        String Url1 = "jdbc:mysql://localhost/sys";//参数参考MySql连接数据库常用参数及代码示例
        String name1 = "root";//数据库用户名
        String psd1 = "wangleikuaile1";//数据库密码
        String jdbcName = "com.mysql.cj.jdbc.Driver";//连接MySql数据库
        String sql = "insert into sys.users1(name1,passwd1) values(?,?)";//数据库操作语句（插入）
        try {
            Class.forName(jdbcName);//向DriverManager注册自己
            Connection con = DriverManager.getConnection(Url1, name1, psd1);//与数据库建立连接
            PreparedStatement pst = con.prepareStatement(sql);//用来执行SQL语句查询，对sql语句进行预编译处理
            pst.setString(1, name2);
            pst.setInt(2, passwordd);
            pst.executeUpdate();
            pst.close();
            sql="SELECT id1 from sys.users1  ORDER BY id1 desc limit 1 ";
            Statement stmt=con.createStatement();
            ResultSet res=stmt.executeQuery(sql);
            while(res.next()){
               id1=res.getInt("id1");
               System.out.println(id1);
             }
        }catch(Exception e){
            System.out.println(e);
        }
        return id1;
    }
}