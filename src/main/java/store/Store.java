package store;

import model.Candidate;
import model.City;
import model.Post;
import model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    Collection<City> findAllCities();

    Collection<User> findAllUsers();

    void save(Post post);

    void save(Candidate candidate);

    void saveUser(User user);

    void savePhoto(String photoId);

    void deleteCandidate(int id);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    User findUserByEmail(String email);
}
