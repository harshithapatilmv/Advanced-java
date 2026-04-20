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
        int minutes = Integer.parseInt(request.getParameter("time"));

        // Create session
        HttpSession session = request.getSession();

        // Set expiry time (minutes → seconds)
        session.setMaxInactiveInterval(minutes * 60);

        // Store user name
        session.setAttribute("user", name);

        out.println("<h2>Hello " + name + "!</h2>");
        out.println("<p>Session set for " + minutes + " minute(s).</p>");
        out.println("<p>Click below to check within session time or wait to see expiry.</p>");
        out.println("<a href='SessionServlet'>Check Session</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get existing session (do not create new)
        HttpSession session = request.getSession(false);

        if (session == null) {
            out.println("<h2>Session expired!</h2>");
        } else {
            String name = (String) session.getAttribute("user");

            if (name == null) {
                out.println("<h2>Session expired!</h2>");
            } else {
                out.println("<h2>Hello " + name + "!</h2>");
                out.println("<p>Session is still active.</p>");
            }
        }
    }
}