package com.studentms;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    private StudentDAO dao;

    @Override
    public void init() {
        dao = new StudentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "LIST";

        try {
            switch (action) {
                case "NEW":
                    showNewForm(request, response);
                    break;
                case "INSERT":
                    insertStudent(request, response);
                    break;
                case "EDIT":
                    showEditForm(request, response);
                    break;
                case "UPDATE":
                    updateStudent(request, response);
                    break;
                case "DELETE":
                    deleteStudent(request, response);
                    break;
                default:
                    listStudents(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

    private void listStudents(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        List<Student> list = dao.getAllStudents();
        req.setAttribute("studentList", list);
        req.getRequestDispatcher("viewStudents.jsp").forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        req.getRequestDispatcher("addStudent.jsp").forward(req, resp);
    }

    private void insertStudent(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");
        String country = req.getParameter("country");

        Student s = new Student(name, email, course, country);
        dao.insertStudent(s);
        resp.sendRedirect("StudentServlet?action=LIST");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        Student existing = dao.getStudentById(id);
        req.setAttribute("student", existing);
        req.getRequestDispatcher("editStudent.jsp").forward(req, resp);
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String course = req.getParameter("course");
        String country = req.getParameter("country");

        Student s = new Student(id, name, email, course, country);
        dao.updateStudent(s);
        resp.sendRedirect("StudentServlet?action=LIST");
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.deleteStudent(id);
        resp.sendRedirect("StudentServlet?action=LIST");
    }
}
