package com.animalrenting.services;

import com.animalrenting.models.City;
import com.animalrenting.models.UserType;
import com.animalrenting.models.Users;
import com.animalrenting.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServices {

    private final List<Users> userList;
    private final UsersRepository usersRepository;

    public UserServices(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        userList = new ArrayList<>();
        userList.add(generateRenter());
        userList.add(generateRentee());
    }

    public static Users getByID(long ID) {
        for (Users user : userList) {
            if (user.getID() == ID) {
                return user;
            }
        }
        throw new RuntimeException("Value not found provided id:" + ID);
    }

    private Users generateRenter() {
        Users user1 = new Users();
        user1.setID(0001);
        user1.setUsername("EfnanM");
        user1.setName("Efnan");
        user1.setLastName("Merdan");
        user1.setEmail("efnanmerdan@gmail.com");
        user1.setPassword("Efnan123");
        user1.setCity(City.Sarajevo);
        user1.setAddress("address");
        user1.setUserType(UserType.renter);
        user1.setPhoneNumber(1234567);
        user1.setDateOfBirth(24 - 3 - 2000);

        return user1;
    }

    private Users generateRentee() {
        Users user2 = new Users();
        user2.setID(0002);
        user2.setUsername("Iris111");
        user2.setName("Iris");
        user2.setLastName("Mehanovic");
        user2.setEmail("irismehanovic@gmail.com");
        user2.setPassword("petrent");
        user2.setCity(City.Sarajevo);
        user2.setAddress("address");
        user2.setUserType(UserType.rentee);
        user2.setPhoneNumber(1234567);
        user2.setDateOfBirth(24 - 3 - 2000);

        return user2;
    }

    public List<Users> getUsers() {

        return usersRepository.findAll();
    }

    public static Users createUser(Users user) {
        return usersRepository.save(user);
    }

    public void updateUser(Users users, long ID) {
        userList.stream().map(user -> {
            if (user.getID() == ID) {
                user.setUsername(users.getUsername());
                user.setName(users.getName());
                user.setLastName(users.getLastName());
                user.setEmail(users.getEmail());
                user.setPassword(users.getPassword());
                user.setCity(users.getCity());
                user.setAddress(users.getAddress());
                user.setUserType(users.getUserType());
                user.setPhoneNumber(users.getPhoneNumber());
                user.setDateOfBirth(users.getDateOfBirth());
            }
            return user;
        }).collect(Collectors.toList());
    }

    public static Users getByCity(String City) {
        for (Users user : userList) {
            if (user.getCity() == City) {
                return user;
            }
        }
        return null;
    }
}