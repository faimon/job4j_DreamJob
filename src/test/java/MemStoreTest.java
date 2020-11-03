import model.Candidate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import servlet.CandidateServlet;
import servlet.DeleteCandidateServlet;
import store.MemStore;
import store.PsqlStore;
import store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PsqlStore.class)
public class MemStoreTest {

    @Test
    public void whenAddCandidate() throws ServletException, IOException {
        MemStore memStore = MemStore.instOf();
        PowerMockito.mockStatic(PsqlStore.class);
        Mockito.when(PsqlStore.instOf()).thenReturn(memStore);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("name")).thenReturn("Ivan");
        when(req.getParameter("id")).thenReturn("1");
        new CandidateServlet().doPost(req, resp);
        assertThat(memStore.findAllCandidates().iterator().next().getName(), is("Ivan"));
    }

    @Test
    public void whenDeleteCandidate() throws ServletException, IOException {
        MemStore memStore = MemStore.instOf();
        memStore.deleteCandidate(1);               // удаляем кандидата из предыдущего теста
        PowerMockito.mockStatic(PsqlStore.class);
        Mockito.when(PsqlStore.instOf()).thenReturn(memStore);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        memStore.save(new Candidate(1, "Vasya"));
        when(req.getParameter("id")).thenReturn("1");
        new DeleteCandidateServlet().doGet(req, resp);
        assertThat(memStore.findAllCandidates().size(), is(0));
    }
}
