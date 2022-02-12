import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Float.parseFloat(request.getParameter("first-operand"));
        float secondOperand = Float.parseFloat(request.getParameter("second-operand"));
        char operator = request.getParameter("operator").charAt(0);

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h1>Result:</h1>");
        try{
            float result = Calculator.calculate(firstOperand, secondOperand, operator);
            printWriter.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
        }catch (Exception ex){
            printWriter.println("Error: " + ex.getMessage());
        }
        printWriter.println("</html>");
    }
}
