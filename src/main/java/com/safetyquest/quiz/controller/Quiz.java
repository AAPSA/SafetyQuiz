package com.safetyquest.quiz.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/quiz")
public class Quiz extends HttpServlet {

    private static final String[] questions = {
        "1. What is the primary purpose of inspecting a property for risks?",
        "2. Which of the following is a common property security measure?",
        "3. How often should fire alarms be tested in a property?"
    };

    private static final String[][] options = {
        {"A. To increase property value", "B. To identify and mitigate potential hazards", "C. To improve aesthetic appeal", "D. To lower insurance premiums"},
        {"A. Installing smoke detectors", "B. Painting the walls", "C. Mowing the lawn", "D. Upgrading kitchen appliances"},
        {"A. Once a year", "B. Once a month", "C. Every six months", "D. Every week"}
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("questions", questions);
        request.setAttribute("options", options);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int score = 0;
        String[] userAnswers = request.getParameterValues("answer");

        char[] correctAnswers = {'B', 'A', 'B'};
        
        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i].charAt(0) == correctAnswers[i]) {
                score += 10;
            }
        }

        request.setAttribute("score", score);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
