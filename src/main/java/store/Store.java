package store;

import model.Candidate;
import model.Post;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void save(Post post);

    void save(Candidate candidate);

    void savePhoto(String photoId);

    void deleteCandidate(int id);

    Post findPostById(int id);

    Candidate findCandidateById(int id);
}
