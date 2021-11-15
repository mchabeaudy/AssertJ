package simple;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

public class _4_RecursiveComparison implements WithAssertions {

    public class Person {
        String name;
        double height;
        Address address;

        public Person(String name, double height, Address address) {
            this.name = name;
            this.height = height;
            this.address = address;
        }
    }

    public class Address {
        String street;

        public Address(String street) {
            this.street = street;
        }
    }

    public class PersonDTO {
        String name;
        double height;
        AddressDTO address;

        public PersonDTO(String name, double height, AddressDTO address) {
            this.name = name;
            this.height = height;
            this.address = address;
        }
    }

    public class AddressDTO {
        String street;

        public AddressDTO(String street) {
            this.street = street;
        }
    }


    @Test
    void example() {
        var person = new Person("Sherlock", 1.72, new Address("Crime street"));
        var personDTO = new PersonDTO("Sherlock", 1.72, new AddressDTO("Crime street"));

        assertThat(person)
                .usingRecursiveComparison()
                .isEqualTo(personDTO);

        var person2 = new Person("Sherlock", 1.6, new Address("Crime street"));
        assertThat(person)
                .usingRecursiveComparison()
                .ignoringFields("height")
                .isEqualTo(person2);

        var person3 = new Person("Sherlock", 1.72, new Address("Crime street 2"));
        assertThat(person)
                .usingRecursiveComparison()
                .ignoringFields("address.street")
                .isEqualTo(person3);
    }

    @Test
    void example_fail() {
        var person = new Person("Sherlock", 1.72, new Address("Crime street"));
        var personDTO = new PersonDTO("Sherlock", 1.72, new AddressDTO("Crime street"));

        assertThat(person)
                .usingRecursiveComparison()
                .withStrictTypeChecking()
                .isEqualTo(personDTO);
    }
}
