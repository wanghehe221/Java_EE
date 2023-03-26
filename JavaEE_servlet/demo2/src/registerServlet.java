import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



public class registerServlet extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JDBC jd=new JDBC();
        req.setCharacterEncoding("UTF-8");
        String sid=req.getParameter("username");
        String spass=req.getParameter("password");
        System.out.println(sid+"@@@"+spass);
        try{

            int pass1=Integer.parseInt(spass);
            int id1=jd.doRes(sid,pass1);
            if(id1>0){
                req.setAttribute("Msg","注册成功,密码为："+id1);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }else{
                req.setAttribute("Msg","注册失败");
                req.getRequestDispatcher("register.html").forward(req,resp);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
