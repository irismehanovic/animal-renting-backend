package com.animalrenting.services;

import com.animalrenting.data.AnimalTest;
import com.animalrenting.models.Animal;
import com.animalrenting.repositories.AnimalRepository;
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
public class AnimalServicesUnitTest {
    @MockBean
    private AnimalRepository animalRepository;

    @TestConfiguration
    static class AnimalServiceTestContextConfiguration {

        @Bean
        @Primary
        public AnimalServices animalServices(AnimalRepository animalRepository) {
            return new AnimalServices(animalRepository);
        }
    }

    @Autowired
    private AnimalServices animalServices;

    @Test
    public void givenItems_whenGetItems_thenListShouldBeFound() {
        Mockito.when(animalRepository.findAll())
                .thenReturn(List.of(AnimalTest.animal()));

        List<Animal> returnedList = animalServices.getAnimals();

        assertThat(returnedList).hasSize(1);
    }

    @Test
    public void givenNoItems_whenGetAnimals_thenListShouldBeEmpty() {
        assertThat(animalServices.getAnimals()).isEmpty();
    }

    @Test
    public void givenValidId_whenGetByPrice_thenAnimalShouldBeFound() {
        Animal animal = AnimalTest.animal();

        Mockito.when(animalRepository.findById(animal.getId()))
                .thenReturn(Optional.of(animal));

        Animal resultAnimal = animalServices.getById(animal.getId());

        assertThat(resultAnimal.getPrice())
                .isEqualTo(animal.getPrice());
    }



    @Test
    public void givenInvalidId_whenGetById_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> animalServices.getById(2L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("does not exist");
    }

    @Test
    public void givenAnimal_whenCreate_thenIdAssigned() {
        Animal inputAnimal = AnimalTest.animal();
        inputAnimal.setId(0L); // reset id
        Animal outputAnimal = AnimalTest.animal();

        Mockito.when(animalRepository.save(inputAnimal))
                .thenReturn(outputAnimal);

        Animal resultAnimal = animalServices.create(inputAnimal);

        assertThat(resultAnimal.getId()).isNotEqualTo(0L);
    }

    @Test
    public void givenAnimal_whenCreate_thenAnimalReturned() {
        Animal inputAnimal = AnimalTest.animal();
        inputAnimal.setId(0L); // reset id
        Animal outputAnimal = AnimalTest.animal();

        Mockito.when(animalRepository.save(inputAnimal))
                .thenReturn(outputAnimal);

        Animal resultAnimal = animalServices.create(inputAnimal);

        assertThat(resultAnimal).isNotNull();
        assertThat(resultAnimal.getGender()).isEqualTo(inputAnimal.getGender());
    }

    @Test
    public void givenAnimal_whenCreate_thenRepositoryCalled() {
        Animal item = AnimalTest.animal();

        animalServices.create(item);

        verify(animalRepository, times(1)).save(item);
    }

    @Test
    public void givenAnimalAndValidId_whenUpdate_thenAnimalReturned() {
        Animal inputAnimal = AnimalTest.animal();
        inputAnimal.setId(0L); // reset id
        long id = 2L;
        Animal outputAnimal = AnimalTest.animal();
        outputAnimal.setId(id);

        Mockito.when(animalRepository.findById(id))
                .thenReturn(Optional.of(outputAnimal));
        Mockito.when(animalRepository.save(inputAnimal))
                .thenReturn(outputAnimal);

        Animal resultAnimal = animalServices.update(inputAnimal, id);

        assertThat(resultAnimal).isNotNull();
        assertThat(resultAnimal.getLocation()).isEqualTo(inputAnimal.getLocation());
        assertThat(resultAnimal.getId()).isEqualTo(id);
    }

    @Test
    public void givenInvalidId_whenUpdate_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> animalServices.update(AnimalTest.animal(), 2L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("does not exist");
    }

    @Test
    public void givenAnimal_whenDelete_thenRepositoryCalled() {
        long id = 2L;

        animalServices.delete(id);

        verify(animalRepository, times(1)).deleteById(id);
    }

}
