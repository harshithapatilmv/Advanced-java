package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        out.println("<html><body>");
        out.println("<h2>Active Cookie List</h2>");

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<p>Name: " + c.getName() + "</p>");
                out.println("<p>Value: " + c.getValue() + "</p>");
                out.println("<hr>");
            }
        } else {
            out.println("<p>No cookies found</p>");
        }

        out.println("<a href='index.html'>Back</a>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String domain = request.getParameter("domain");
        int age = Integer.parseInt(request.getParameter("age"));

        Cookie cookie = new Cookie(name, domain);

        cookie.setMaxAge(age);   // expiry time
        cookie.setDomain(domain); // domain setting

        response.addCookie(cookie);

        out.println("<html><body>");
        out.println("<h2>Cookie Added Successfully</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Domain: " + domain + "</p>");
        out.println("<p>Expiry: " + age + " seconds</p>");

        out.println("<br><a href='CookieServlet'>Go to Active Cookie List</a>");
        out.println("</body></html>");
    }
}