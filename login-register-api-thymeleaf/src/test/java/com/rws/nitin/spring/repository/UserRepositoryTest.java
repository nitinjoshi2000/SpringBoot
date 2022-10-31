package com.rws.nitin.spring.repository;

import com.rws.nitin.spring.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    public UserRepository userRepository;

//    Taking User From DB
  @Test
    void findByEmail(){
        User email = userRepository.findByEmail("joshi.nitin2002@gmail.com");
        assertThat(email.getEmail()).isEqualTo("joshi.nitin2002@gmail.com");
 }

 /* Saving new user to DB
    @Test
    void findByEmail(){
        User user = new User("gar","seth","garv@gmail.com","1");
        userRepository.save(user);
        User email = userRepository.findByEmail("gar@gmail.com");
        assertThat(email.getEmail()).isEqualTo("gar@gmail.com");
}
*/
}