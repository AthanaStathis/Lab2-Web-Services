package se.iths.springdemo.mappers;

import org.springframework.stereotype.Component;
import se.iths.springdemo.dtos.DogDto;
import se.iths.springdemo.entities.Dog;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DogMapper {

    public DogMapper() {

    }

    public DogDto mapp(Dog dog) {
        return new DogDto(dog.getId(),dog.getName(),dog.getType(), dog.getAge(), dog.getGender());
    }

    public Dog mapp(DogDto dogDto) {
        return new Dog(dogDto.getId(),dogDto.getName(),dogDto.getType(), dogDto.getAge(), dogDto.getGender());
    }

    public Optional<DogDto> mapp(Optional<Dog> optionalDog) {
        if (optionalDog.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalDog.get()));

    }

    public List<DogDto> mapp(List<Dog> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}
