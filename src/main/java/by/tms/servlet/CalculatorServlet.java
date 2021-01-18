package by.tms.servlet;

import by.tms.storage.CalculatorInside;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstNumStr = req.getParameter("firstNum");
        String secondNumStr = req.getParameter("secondNum");
        String operation = req.getParameter("operation");
        CalculatorInside calculatorInside = new CalculatorInside();
        int firstNum = Integer.parseInt(firstNumStr);
        int secondNum = Integer.parseInt(secondNumStr);
        String result = calculatorInside.result(firstNum, secondNum, operation);
        req.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/pages/Calculator.jsp").forward(req, resp);



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/Calculator.jsp").forward(req, resp);

    }
}
