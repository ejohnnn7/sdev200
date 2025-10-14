<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Addition Quiz</title>
</head>
<body>
    <h2>Addition Quiz</h2>
    <form action="Exercise38_14_Result.jsp" method="post">
        <%
            Random rand = new Random();
            int numQuestions = 10;

            for (int i = 0; i < numQuestions; i++) {
                int num1 = rand.nextInt(20) + 10; // random number 10–29
                int num2 = rand.nextInt(10) + 1;  // random number 1–10

                // Save values as hidden fields for result checking
                out.println(num1 + " + " + num2 + " = ");
                out.println("<input type='text' name='answer" + i + "' size='5' />");
                out.println("<input type='hidden' name='num1_" + i + "' value='" + num1 + "' />");
                out.println("<input type='hidden' name='num2_" + i + "' value='" + num2 + "' /><br>");
            }
        %>
        <br>
        <input type="submit" value="Submit" />
        <p>Click the browser’s Refresh button to get a new quiz.</p>
    </form>
</body>
</html>
