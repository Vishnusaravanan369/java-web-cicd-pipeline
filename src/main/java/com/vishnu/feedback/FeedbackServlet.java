package com.vishnu.feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Student Feedback Portal</title></head>");
        out.println("<body>");
        out.println("<h1>Student Feedback Portal</h1>");
        out.println("<p>Hi, There this is vishnu saravana u might wounder this is the student feedback portal but who is this man speaking here ya that suprise</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
