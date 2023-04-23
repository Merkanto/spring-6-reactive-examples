package merkanto.spring6reactiveexamples.repositories;

import merkanto.spring6reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonRepositoryImpl implements PersonRepository {

    Person miro = Person.builder()
            .id(1)
            .firstName("Miro")
            .lastName("Ivanov")
            .build();

    Person gogo = Person.builder()
            .id(2)
            .firstName("Gogo")
            .lastName("Gogov")
            .build();

    Person valio = Person.builder()
            .id(3)
            .firstName("Valentin")
            .lastName("Petrov")
            .build();

    Person stoyan = Person.builder()
            .id(4)
            .firstName("Stoyan")
            .lastName("Georgiev")
            .build();

    @Override
    public Mono<Person> getById(final Integer id) {
        return findAll().filter(person -> person.getId().equals(id)).next();
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just(miro, gogo, valio, stoyan);
    }
}
