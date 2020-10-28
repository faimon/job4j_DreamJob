package store;

import model.Candidate;
import model.Post;

public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        store.save(new Post(0, "Java Job"));
        store.save(new Candidate(0, "new Candidate"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }
        for (Candidate can : store.findAllCandidates()) {
            System.out.println(can.getId() + " " + can.getName());
        }
        System.out.println(store.findPostById(3).getName() + " - описание вакансии");
        System.out.println(store.findCandidateById(2).getName() + " - описание вакансии");
    }
}
