package com.example.proj.repo;

import com.example.proj.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(value = false) // test일 경우 다시 롤백하는데, 결과값 확인을 위해 롤백 하지 않음.
class UserRepoTest {
    @Autowired
    private UserRepo repo;

    @Test
    void userRepoTest() {
        final String emailFormat = "@gmail.com";

        User user1 = new User("a" + emailFormat, "user1", "pw");
        User user2 = new User("a" + emailFormat, "user2", "pw");
        User user3 = new User("c" + emailFormat, "user3", "pw");

        repo.save(user1);
        Assertions.assertEquals(repo.findById(user1.getEmail()).get().getEmail(), user1.getEmail());

        repo.save(user2); // repo merge..

        repo.save(user3);

        Assertions.assertEquals(repo.count(), 2);
    }

}