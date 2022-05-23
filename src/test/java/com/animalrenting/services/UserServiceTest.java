package com.animalrenting.services;

import com.animalrenting.UsersTest;
import com.animalrenting.models.Users;
import com.animalrenting.repositories.UsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @MockBean
    private UsersRepository usersRepository;

    @TestConfiguration
    static class UserServiceTestContextConfiguration {

        @Bean
        @Primary
        public UserServices userService(UsersRepository usersRepository) {
            return new UserServices(usersRepository);
        }
    }

    @Autowired
    private UserServices userService;

    @Test
    public void givenValidId_whenGetById_thenItemShouldBeFound() {
        Users users = UsersTest.users();

        Mockito.when(usersRepository.findById(users.getID()))
                .thenReturn(Optional.of(users));

        Users resultUsers = UserServices.getByID(users.getID());

        assertThat(resultUsers.getName())
                .isEqualTo(users.getName());
    }


    @Test
    public void givenUsers_whenGetUsers_thenListShouldBeFound() {
        Mockito.when(usersRepository.findAll())
                .thenReturn(List.of(UsersTest.users()));

        List<Users> returnedList = userService.getUsers();

        assertThat(returnedList).hasSize(1);
    }

    @Test
    public void givenNoOfUsers_whenGetUsers_thenListShouldBeEmpty() {
        assertThat(userService.getUsers()).isEmpty();
    }

    @Test
    public void givenUser_whenCreate_thenRepositoryCalled() {
        Users users = UsersTest.users();

        UserServices.createUser(users);

        verify(usersRepository, times(2)).save(users);
    }

    @Test
    public void givenInvalidID_whenUpdateUsers_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> userService.updateUser(UsersTest.users(), 0002))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("does not exist");
    }

}
