package servlet;

import store.PsqlStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeleteCandidateServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int candidateId = Integer.parseInt(req.getParameter("id"));
        PsqlStore.instOf().deleteCandidate(candidateId);
        Files.deleteIfExists(Paths.get("images" + File.separator + candidateId));
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
