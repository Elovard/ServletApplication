package by.tms.filter;

import by.tms.model.Role;
import by.tms.model.User;
import by.tms.storage.InMemoryUserStorage;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "AuthorizationServlet")
public class AuthorizationFilter extends HttpFilter {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            User byLogin = inMemoryUserStorage.getByLogin(login);
            if (byLogin == null) {
                req.setAttribute("messageNotRegistered", " Error! You are not registered here! (user is not found)");
                getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, res);
            } else {
                chain.doFilter(req, res);
            }
            if(byLogin.getRole().equals(Role.ADMIN)){
                req.getSession().setAttribute("isAdmin", true);
            } else {
                chain.doFilter(req, res);
            }
            if (!byLogin.getPassword().equals(password)) {
                req.setAttribute("messageWrongPassword", "Error! Wrong Password!");
                getServletContext().getRequestDispatcher("/pages/auth.jsp").forward(req, res);

            } else {
                req.getSession().setAttribute("user", byLogin);
                req.setAttribute("messageHomeReg", "Welcome back!");
                getServletContext().getRequestDispatcher("/pages/index.jsp").forward(req, res);
                req.getSession().setAttribute("isGuest", false);
                req.getSession().setAttribute("isUser", true);



            }

        } else {
            chain.doFilter(req, res);
        }
    }
}

