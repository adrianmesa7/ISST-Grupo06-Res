package es.upm.dit.isst.resumen.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormSuscribeServlet")
public class FormSuscribeServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
               getServletContext().getRequestDispatcher("/FormLoginServlet?email=%40lector.es&password=").forward(req,resp);
        }
}

