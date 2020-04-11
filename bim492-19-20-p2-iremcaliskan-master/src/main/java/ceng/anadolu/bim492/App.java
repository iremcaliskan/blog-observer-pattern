package ceng.anadolu.bim492;

import designpattern.Blog;
import designpattern.observer.User;

public class App {
    public static void main(String[] args) {

        System.out.println("Test project:");

        Blog blog = new Blog();
        User user1 = new User();
        User user2 = new User();
        blog.registerObserver(user1);
        blog.registerObserver(user2);
        user1.setSubject(blog);
        user2.setSubject(blog);

        System.out.println(user1.getArticle());
        blog.postNewArticle();
        System.out.println(user2.getArticle());

    }
}
