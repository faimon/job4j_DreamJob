package store;

import model.Candidate;
import model.Post;
import model.User;

public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        store.saveUser(new User(1, "Ivan", "Ivan@yandex.ru", "123"));
        for (User user: store.findAllUsers()
             ) {
            System.out.println(user.getEmail());
        }
        System.out.println(store.findUserByEmail("Ivan@yandex.ru").getName());
    }
}
