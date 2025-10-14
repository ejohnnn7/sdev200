package WeeklyProjects.Mod7Prog1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ComputeLoan {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double annualInterestRate = Double.parseDouble(request.getParameter("annualInterestRate"));
        int numOfYears = Integer.parseInt(request.getParameter("numOfYears"));

        Loan loan = new Loan(annualInterestRate, numOfYears, loanAmount);

        out.println("<html>");
        out.println("<head><title>Loan Payment</title></head>");
        out.println("<body>");
        out.println("Loan Amount: " + loanAmount + "<br>");
        out.println("Annual Interest Rate: " + annualInterestRate + "<br>");
        out.println("Number of Years: " + numOfYears + "<br>");
        out.println("Monthly Payment: " + loan.getMonthlyPayment() + "<br>");
        out.println("Total Payment: " + loan.getTotalPayment() + "<br>");
        out.println("</body></html>");
    }
}
