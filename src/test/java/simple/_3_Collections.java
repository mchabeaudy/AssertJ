package simple;

import static character.Race.DWARF;
import static character.Race.ELF;
import static character.Race.HOBBIT;
import static character.Race.MAIAR;
import static character.Race.MAN;
import static character.Race.ORC;

import character.TolkienCharacter;
import java.util.List;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class _3_Collections extends TolkienTest {

    @Test
    void satisfyExample() {
        assertThat(fellowshipOfTheRing).allSatisfy(character ->
                assertThat(character.getHeight()).isGreaterThan(1.0)
        );

        assertThat(fellowshipOfTheRing).anySatisfy(character -> {
            assertThat(character.getName()).isEqualTo("Frodo");
            assertThat(character.getRace()).isEqualTo(HOBBIT);
        });

        assertThat(fellowshipOfTheRing).noneSatisfy(character ->
                assertThat(character.getName()).isEqualTo("Sauron")
        );
    }

    @Test
    void matchExample() {
        assertThat(fellowshipOfTheRing)
                .allMatch(character -> character.getHeight() > 1.0)
                .anyMatch(character -> character.getName().contains("F"))
                .noneMatch(character -> character.getRace() == ORC);
    }

    @Test
    void extractionExample() {
        assertThat(fellowshipOfTheRing)
                .extracting(TolkienCharacter::getRace)
                .containsOnly(HOBBIT, MAN, DWARF, ELF, MAIAR)
                .doesNotContain(ORC);

        assertThat(fellowshipOfTheRing)
                .extracting(
                        TolkienCharacter::getRace,
                        TolkienCharacter::getName)
                .containsOnly(
                        tuple(HOBBIT, "Frodo"),
                        tuple(HOBBIT, "Sam"),
                        tuple(HOBBIT, "Merry"),
                        tuple(HOBBIT, "Pippin"),
                        tuple(MAIAR, "Gandalf"),
                        tuple(MAN, "Boromir"),
                        tuple(MAN, "Aragorn"),
                        tuple(DWARF, "Gimli"),
                        tuple(ELF, "Legolas"));

        // flat extracting
        assertThat(fellowshipOfTheRing)
                .flatExtracting(
                        TolkienCharacter::getName,
                        TolkienCharacter::getRace)
                .contains("Frodo", HOBBIT, "Gimli", DWARF);
        assertThat(List.of(frodo, sam))
                .flatExtracting(TolkienCharacter::getFriends)
                .contains(merry, pippin);
    }

    @Test
    void filterExample() {
        assertThat(fellowshipOfTheRing)
                .filteredOn(TolkienCharacter::getRace, HOBBIT)
                .containsExactlyInAnyOrder(frodo, sam, merry, pippin);

        assertThat(fellowshipOfTheRing)
                .filteredOn("race", not(HOBBIT))
                .containsExactlyInAnyOrder(aragorn, gandalf, legolas, gimli, boromir);

        assertThat(fellowshipOfTheRing)
                .filteredOnNull("name")
                .isEmpty();

        var tallFellowshipMember = new Condition<TolkienCharacter>(
                character -> fellowshipOfTheRing.contains(character) &&
                        character.getHeight() > 1.6, "tall fellowship member");
        assertThat(List.of(aragorn, boromir, frodo, sauron))
                .filteredOn(tallFellowshipMember)
                .containsExactlyInAnyOrder(aragorn, boromir);
    }

}
