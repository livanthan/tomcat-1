package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students/delete")
public class deleteStudentServlet extends HttpServlet {
    private final StudentDAO da = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        // String name = req.getParameter("name");
        String idstr = req.getParameter("id");

        // if (name == null || name.isBlank() || ageStr == null || ageStr.isBlank()) {
        //     req.getSession().setAttribute("msg", "Name and Age are required.");
        //     resp.sendRedirect(req.getContextPath() + "/addStudent.jsp");
        //     return;
        // }

        try {
            int id = Integer.parseInt(idstr);
            da.delete(id);
            // redirect to list after insert (PRG pattern)
            resp.sendRedirect(req.getContextPath() + "/students");
        } catch (NumberFormatException nfe) {
            req.getSession().setAttribute("msg", "Age must be a number.");
            resp.sendRedirect(req.getContextPath() + "/deleteStudent.jsp");
        }
    }
}
