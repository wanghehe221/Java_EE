package jluee.biz;
import jluee.dao.UserDao;
import jluee.entity.User;
public class UserBiz {

    public User UserLog(User user1){
        UserDao userdao1=new UserDao();
        User reUser=userdao1.UserLogin(user1);
        return reUser;
    }
}
