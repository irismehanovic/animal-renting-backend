package com.animalrenting;

import com.animalrenting.models.City;
import com.animalrenting.models.UserType;
import com.animalrenting.models.Users;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsersTest {

    public static Users users() {
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
        user2.setDateOfBirth(24-3-2000);

        return user2;
    }
}
