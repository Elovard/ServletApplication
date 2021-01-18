package by.tms.filter;

import by.tms.model.User;
import by.tms.storage.InMemoryUserStorage;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "RegistrationServlet")
public class RegistrationFilter extends HttpFilter {
    private final InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")) {
            String name = req.getParameter("name");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            if (login.length() < 3) {
                req.setAttribute("messageShortLog", "Your login is too short! (min. 3 symbols)");
                req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, res);
            } else {
                chain.doFilter(req, res);
            }
                if (password.length() < 4) {
                    req.setAttribute("messageShortPass", "Your password is too short! (min. 4 symbols)");
                    req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, res);
                } else {
                    chain.doFilter(req, res);
                }
                    if (name.length() == 0) {
                        req.setAttribute("messageNullName", "Your name can't be empty!");
                        req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, res);
                    } else {
                        chain.doFilter(req, res);
                    }

                    User user = new User(name, login, password);
                    boolean save = inMemoryUserStorage.save(user);

                    if(save){
                        req.setAttribute("messageSuccessReg", "You've successfully registered! Welcome!");
                        req.getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, res);
                    } else {
                        req.setAttribute("messageExist", "User is already exist!");
                        getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, res);
                    }
                } else {
                    chain.doFilter(req, res);
        }
    }
}