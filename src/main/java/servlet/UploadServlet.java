package servlet;

import images.UploadImage;
import store.PsqlStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int candidateId = Integer.parseInt(req.getParameter("candidateId"));
        req.setAttribute("candidateId", candidateId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("candidate/upload.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String photoPath = new UploadImage().saveImage(this, req);
        PsqlStore.instOf().savePhoto(photoPath);
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
