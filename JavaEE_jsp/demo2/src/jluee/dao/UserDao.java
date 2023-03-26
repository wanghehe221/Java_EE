package jluee.dao;

import java.sql.ResultSet;
import jluee.entity.User;
public class UserDao extends  BaseDao{
    public User UserLogin(User user1){
        BaseDao jdbc=new BaseDao();
        User user2=new User();
        jdbc.getCon();
        String[] obj1 = new String[]{user1.getName1(), user1.getpasswd1()};
        String sql="select * from sys.users1 where name1=? and passwd1=?;";
        jdbc.doPstm(sql,obj1);
        try{
            ResultSet rs= jdbc.getRs();

            while(rs.next()){
                user2.setId1(rs.getInt("id1"));
                user2.setName1(rs.getString("name1"));
                user2.setPasswd1(rs.getString("passwd1"));
                jdbc.closed();
                return user2;
            }
        }catch (Exception e){
            System.out.println("Udao111");
            System.out.println(e);
        }
        jdbc.closed();
        return null;
    }

    public int UserUpdata(User user1){
        BaseDao jdbc=new BaseDao();
        jdbc.getCon();
        String[] obj1 = new String[]{user1.getName1(), user1.getpasswd1()};
        String sql="insert into  sys.users1(name1,passwd1) values(?,?);";
        jdbc.doPstm(sql,obj1);
        try{
            ResultSet rs= jdbc.getRs();
            while(rs.wasNull()){
                jdbc.closed();
                return 1;
            }
        }catch (Exception e){
            System.out.println("Udao");
            System.out.println(e);
        }
        jdbc.closed();
        return 0;
    }
}


