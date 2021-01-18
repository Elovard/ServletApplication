package by.tms.servlet;

import by.tms.model.User;
import by.tms.storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	private final InMemoryUserStorage inMemoryUserStorage
			= new InMemoryUserStorage();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String login = req.getParameter("login");
		String password = req.getParameter("password");

//		if (login.length() < 3) {
//			req.setAttribute("messageShortLog", "Your login is too short! (min 3 symbols)");
//			getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
//		} else if (password.length() < 4) {
//			req.setAttribute("messageShortPass", "Your password is too short! (min 4 symbols)");
//			getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
//		}
//
//		User user = new User(name, login, password);
//		boolean save = inMemoryUserStorage.save(user);
//		if (save) {
//			req.setAttribute("messageSuccessReg", "You've successfully registered!");
//			getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
//		} else {
//			req.setAttribute("messageExist", "User is exist!");
//			getServletContext().getRequestDispatcher("/pages/reg.jsp").forward(req, resp);
//		}

	}
}
