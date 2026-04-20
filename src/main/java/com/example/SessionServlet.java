package com.example;



import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Date;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);

        // Set session expiry time (1 minute)
        session.setMaxInactiveInterval(60);

        Integer count = (Integer) session.getAttribute("visitCount");

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        session.setAttribute("visitCount", count);

        out.println("<html><body>");
        out.println("<h2>Session Tracking Information</h2>");

        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>Session Creation Time: " + new Date(session.getCreationTime()) + "</p>");
        out.println("<p>Last Access Time: " + new Date(session.getLastAccessedTime()) + "</p>");
        out.println("<p>Visit Count: " + count + "</p>");
        out.println("<p>(Session expires in 1 minute)</p>");

        out.println("</body></html>");
    }
}