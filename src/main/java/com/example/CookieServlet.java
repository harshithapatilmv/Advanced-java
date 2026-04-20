package com.example;



import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        int count = 0;
        boolean newUser = true;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("username")) {
                    name = c.getValue();
                    newUser = false;
                }

                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue());
                    count++;
                }
            }
        }

        if (newUser) {
            count = 1;
        }

        // Create cookies
        Cookie nameCookie = new Cookie("username", name);
        Cookie countCookie = new Cookie("count", String.valueOf(count));

        // Expiry (30 seconds)
        nameCookie.setMaxAge(30);
        countCookie.setMaxAge(30);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        out.println("<html><body>");

        // Greeting
        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<p>You have visited this page " + count + " times.</p>");
        out.println("<p>(Cookie expires in 30 seconds)</p>");

        // List cookies with values
        out.println("<h3>Cookie List with Values:</h3>");

        Cookie[] allCookies = request.getCookies();

        if (allCookies != null) {
            for (Cookie c : allCookies) {
                out.println("<p>Cookie Name: " + c.getName() + "</p>");
                out.println("<p>Value: " + c.getValue() + "</p>");
                out.println("<hr>");
            }
        } else {
            out.println("<p>No cookies found</p>");
        }

        out.println("</body></html>");
    }
}