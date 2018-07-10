package ua.nure.skrypnyk.servlets;

import ua.nure.skrypnyk.DTO.UserDTO;
import ua.nure.skrypnyk.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserDTO userDTO = UserServiceImpl.getInstance().getByLogin(login);

        if(userDTO != null && userDTO.getPassword().equals(password)){
            request.getSession().setAttribute("user", userDTO);
            response.sendRedirect(request.getSession().getAttribute("url").toString());
        }else{
            request.getSession().setAttribute("message", "Wrong users name or password");
            response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
