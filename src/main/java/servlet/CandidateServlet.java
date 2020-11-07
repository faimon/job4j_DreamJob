package servlet;

import model.Candidate;
import store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> images = new ArrayList<>();
        for (File name : new File("images").listFiles()) {
            images.add(name.getName());
        }
        req.setAttribute("user", req.getSession().getAttribute("user"));
        req.setAttribute("images", images);
        req.setAttribute("candidates", PsqlStore.instOf().findAllCandidates());
        req.setAttribute("cities", PsqlStore.instOf().findAllCities());
        req.getRequestDispatcher("candidate/candidates.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Candidate newCandidate = new Candidate(Integer.parseInt(req.getParameter("id")),
                req.getParameter("name"), Integer.parseInt(req.getParameter("city")));
        PsqlStore.instOf().save(newCandidate);
        resp.sendRedirect(req.getContextPath() + "/upload?candidateId=" + newCandidate.getId());
    }
}
