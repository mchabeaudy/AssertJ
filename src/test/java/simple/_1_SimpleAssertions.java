package simple;

import static character.Race.HOBBIT;

import character.TolkienCharacter;
import java.util.Comparator;
import org.junit.jupiter.api.Test;


public class _1_SimpleAssertions extends TolkienTest {

    @Test
    void simpleExample() {

        assertThat(frodo.getAge()).isEqualTo(33);
        assertThat(frodo.getName()).isEqualTo("Frodo");

        assertThat(frodo).isIn(fellowshipOfTheRing);
        assertThat(frodo).isIn(frodo, sam, merry);

        assertThat(sauron).isNotIn(fellowshipOfTheRing);

        assertThat(frodo)
                .matches(character -> character.getAge() > 30 &&
                        character.getRace() == HOBBIT);

        assertThat("The Lord of the Rings")
                .isNotNull()
                .startsWith("The")
                .contains("Lord")
                .endsWith("Rings");

        assertThat(frodo)
                .usingComparator(Comparator.comparing(TolkienCharacter::getRace))
                .isEqualTo(sam);
    }

    @Test
    void failingAssertion() {
        assertThat(frodo.getAge()).as("check %s's age", frodo.getName())
                .isEqualTo(100);
    }

    @Test
    void dontDoThis() {
        // Don't do this! it will not do anything
        assertThat(frodo.getName().equals("Sauron"));
    }

}
