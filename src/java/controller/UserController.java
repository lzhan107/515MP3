/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Assignment;
import domain.Course;
import domain.Instructor;
import domain.Student;
import ejb.InstructorBean;
import ejb.StudentBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lei
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    @EJB
    private StudentBean studentBean;
    @EJB
    private InstructorBean instructorBean;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Instructor instructor = null;
        Student student = null;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            if (request.isUserInRole("STUDENT")) {
                student = studentBean.findByStuName(request.getRemoteUser());
                out.println("<h1>You are logged in, you are " + student.getUser().getUsername() + "</h1>");
                if (student.getCourses().size() > 0 && student.getCourses() != null) {
                    out.println("<h1>You selected below courses</h1>");
                    out.println("<ul>");
                    for (Course course : student.getCourses()) {
                        out.println("<li>" + course.getCourseName() + "</li>");
                        if (course.getAssignments().size() > 0 && course.getAssignments() != null) {
                            out.println("<h6>Assignments</h6>");
                            out.println("<ul>");
                            for (Assignment assignment : course.getAssignments()) {
                                out.println("<li>" + assignment.getAssignmentName() + "</li>");
                            }
                            out.println("</ul>");
                        }
                    }
                    out.println("</ul>");
                }
            } else if (request.isUserInRole("INSTRUCTOR")) {
                instructor = instructorBean.findByInstName(request.getRemoteUser());
                out.println("<h1>You are logged in, you are " + instructor.getUser().getUsername() + "</h1>");
                if (instructor.getCourses().size() > 0 && instructor.getCourses() != null) {
                    out.println("<h1>You are teaching below courses</h1>");
                    out.println("<ul>");
                    for (Course course : instructor.getCourses()) {
                        out.println("<li>" + course.getCourseName() + "</li>");
                    }
                    out.println("</ul>");
                }
            }
            out.println("<a href='" + request.getContextPath() + "/LogoutServlet'>Logout</a>");
            out.println("<p id=\"readme\"><a href=\"./README.pdf\">Read Me Link >></a></p>\n"
                    + "        <p id=\"javadoc\"><a href=\"./javadoc/index.html\">JavaDoc Link >></a></p>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
