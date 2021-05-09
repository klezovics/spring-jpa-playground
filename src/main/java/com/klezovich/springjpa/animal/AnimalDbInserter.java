package com.klezovich.springjpa.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Profile("insert_animals")
public class AnimalDbInserter implements ApplicationListener<ContextRefreshedEvent> {

    private final AnimalRepository repository;

    @Autowired
    public AnimalDbInserter(AnimalRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        var animal = new Animal();
        animal.setName("Barsik");
        animal.setAge(3);
        repository.save(animal);

        var bird = new Bird();
        bird.setName("Birdy");
        bird.setAge(2);
        bird.setFlightDistanceInKm(10);
        repository.save(bird);

        var dog = new Dog();
        dog.setName("Snoop");
        dog.setAge(10);
        dog.setBarkLoudnessInDb(20);
        dog.setParentInfo(new DogParentInfo("dogMomName", "dogDadName"));
        repository.save(dog);
    }
}
