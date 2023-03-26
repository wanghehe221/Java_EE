package org.wl.servlet_train.jluee.biz;
import org.wl.servlet_train.jluee.dao.UserDao;
import org.wl.servlet_train.jluee.entity.User;
public class UserBiz {

    public User UserLog(User user1){
        UserDao userdao1=new UserDao();
        User reUser=userdao1.UserLogin(user1);
        return reUser;
    }
}
