package com.mywork.util;

import com.mywork.dto.User;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class SessionUtil {
    public static HttpSession session = null;
    //Session 跟踪技术
    public static boolean login(HttpSession session1,User user, String balance){
        session1.setAttribute("u_id",user.getId());
        session1.setAttribute("username",user.getName());
        session1.setAttribute("balance",balance);
        session = session1;
        //此时就会自动响应一个JSESSIONID给客户端
        return true;
    }

    public static HttpSession takeSession(){
        //客户端再次发送请求时，就会携带一个JSESSIONID给服务器
        //接着服务端就会根据该JSESSIONID来映射一个唯一的session对象，
        //该session对象一直存储在服务器中。
        return session;
    }

    public static void deleteSession(){
        session.invalidate();
    }

    public static boolean isLogin(HttpServletRequest request){
        if (request.getSession() == session){
            return true;
        }else {
            return false;
        }

    }
}
