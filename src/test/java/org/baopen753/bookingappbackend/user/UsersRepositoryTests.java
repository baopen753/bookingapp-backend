package org.baopen753.bookingappbackend.user;

import org.baopen753.bookingappbackend.entities.User;
import org.baopen753.bookingappbackend.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class UsersRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetUserSuccess() {
        int userId = 1;
        User user = userRepository.findUsersByUserId(userId);

        System.out.println(user);
    }

    @Test
    public void testUpdateUserSuccess() {
        String firstName = "John_New";

        int userId = 1;
        User user = userRepository.findUsersByUserId(userId);
        user.setFirstName(firstName);
        userRepository.save(user);
        System.out.println(user.getFirstName());
    }

    @Test
    public void testGetUserDetailService() {
        String username = "sta_hoa";

        Optional<User> user = userRepository.findByUsername(username);
        System.out.println(user.get());
    }
}
