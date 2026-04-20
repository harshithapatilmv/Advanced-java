package com.example;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        // Create or get session
        HttpSession session = request.getSession();
        
        // Set session timeout to 1 minute (60 seconds)
        session.setMaxInactiveInterval(60);

        // Store username in session
        session.setAttribute("user", name);

        out.println("<h2>Hello " + name + "!</h2>");
        out.println("<p>Session created. It will expire in 1 minute.</p>");
        out.println("<a href='SessionServlet'>Check Session Status</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if (session == null) {
            out.println("<h2>Session expired!</h2>");
        } else {
            String name = (String) session.getAttribute("user");
            out.println("<h2>Hello again " + name + "!</h2>");
            out.println("<p>Your session is still active.</p>");
        }
    }
}
