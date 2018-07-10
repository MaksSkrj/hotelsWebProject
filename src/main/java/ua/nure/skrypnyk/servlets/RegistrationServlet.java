package ua.nure.skrypnyk.servlets;

import ua.nure.skrypnyk.DAO.impl.UserDAOImpl;
import ua.nure.skrypnyk.DTO.UserDTO;
import ua.nure.skrypnyk.datasource.DataSource;
import ua.nure.skrypnyk.model.User;
import ua.nure.skrypnyk.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String confirmPassword = request.getParameter("confirmPassword");
        UserDTO userDTO = UserServiceImpl.getInstance().getByLogin(login);
        System.out.println(userDTO.getLogin() + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Connection connection = DataSource.getInstance().getConnection();

        if (login != null && !login.equals(userDTO) && password.equals(confirmPassword)) {

            try {
                PreparedStatement preparedStatement = new UserDAOImpl().createInsertStatement
                        (connection, new User(login, name, lastName, null, null, 1, 0, password));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("exception in insert statement");
                e.printStackTrace();
            }
            response.sendRedirect(request.getSession().getAttribute("url").toString());
        } else if (!userDTO.equals(null)) {
            request.getSession().setAttribute("message", "This login already exists. Please try again.");
            response.sendRedirect(request.getContextPath() + "/pages/user/registration.jsp");
        } else if (password.equals(confirmPassword)) {
            request.getSession().setAttribute("message", "You entered two different passwords. Please try again.");
            response.sendRedirect(request.getContextPath() + "/pages/user/registration.jsp");
        } else {
            request.getSession().setAttribute("message", "Something went wrong...(((");
            response.sendRedirect(request.getContextPath() + "/pages/user/registration.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
