package by.tms.filter;

import by.tms.storage.CalculatorInside;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(servletNames = "CalculatorServlet")
public class CalculatorFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if(req.getSession().getAttribute("user") != null){
            if(req.getMethod().equals("POST")){
                String firstNumStr = req.getParameter("firstNum");
                String secondNumStr = req.getParameter("secondNum");
                String operation = req.getParameter("operation");
                CalculatorInside calculatorInside = new CalculatorInside();
                Pattern pattern = Pattern.compile("(-)?\\d+");
                Matcher matcherF = pattern.matcher(firstNumStr);
                Matcher matcherS = pattern.matcher(secondNumStr);
                if (matcherF.matches() && matcherS.matches()){
                    if(calculatorInside.getListOper().contains(operation)){
                        int secondNum = Integer.parseInt(secondNumStr);
                        if(secondNum == 0 && operation.equals("div")){
                            req.setAttribute("messageZero", "Divided by zero!");
                            req.getServletContext().getRequestDispatcher("/pages/Calculator.jsp").forward(req,res);
                        } else {
                            chain.doFilter(req, res);
                        }
                    } else {
                        req.setAttribute("messageNoOperation", "Incorrect operation!");
                        req.getServletContext().getRequestDispatcher("/pages/Calculator.jsp").forward(req,res);
                    }
                } else {
                    req.setAttribute("messageWrongNumber", "Incorrect number!");
                    req.getServletContext().getRequestDispatcher("/pages/Calculator.jsp").forward(req,res);
                }
            } else {
                chain.doFilter(req, res);
            }
            } else {
            res.sendRedirect("/");
        }
    }
}
