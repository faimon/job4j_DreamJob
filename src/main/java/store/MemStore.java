package store;

import model.Candidate;
import model.Post;
import model.User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {
    private static final MemStore INST = new MemStore();
    private Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();
    private static AtomicInteger POST_ID = new AtomicInteger(4);
    private static AtomicInteger CANDIDATE_ID = new AtomicInteger(4);

    private MemStore() {
//        posts.put(1, new Post(1, "Java Job", "Need Java developer", LocalDate.now()));
//        posts.put(2, new Post(2, "PHP Job", "Need PHP developer", LocalDate.now()));
//        posts.put(3, new Post(3, "C++ Job", "Need C++ developer", LocalDate.now()));
//        candidates.put(1, new Candidate(1, "Candidate #1"));
//        candidates.put(2, new Candidate(2, "Candidate #2"));
//        candidates.put(3, new Candidate(3, "Candidate #3"));
    }

    public static MemStore instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    @Override
    public Collection<User> findAllUsers() {
        return null;
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }

    public Candidate findCandidateById(int id) {
        return candidates.get(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    public void save(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void savePhoto(String photoId) {

    }

    @Override
    public void deleteCandidate(int id) {
        candidates.remove(id);
    }
}
