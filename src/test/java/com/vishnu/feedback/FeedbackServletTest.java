package com.vishnu.feedback;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class FeedbackServletTest {

    @Test
    void doGetReturnsStudentFeedbackPage() throws Exception {
        FeedbackServlet servlet = new FeedbackServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter content = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(content));

        servlet.doGet(request, response);

        verify(response).setContentType("text/html");

        String html = content.toString();

        assertTrue(html.contains("Student Feedback Portal"));
        assertTrue(html.contains("Hi, There this is vishnu saravana"));
    }
}
