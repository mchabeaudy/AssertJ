package simple;

import static character.Race.DWARF;
import static character.Race.ELF;
import static character.Race.HOBBIT;
import static character.Race.MAIAR;
import static character.Race.MAN;

import character.TolkienCharacter;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import simple.conf.MyProjectWithAssertions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TolkienTest implements MyProjectWithAssertions {

    TolkienCharacter frodo;
    TolkienCharacter sam;
    TolkienCharacter pippin;
    TolkienCharacter merry;
    TolkienCharacter boromir;
    TolkienCharacter legolas;
    TolkienCharacter sauron;
    TolkienCharacter elrond;
    TolkienCharacter aragorn;
    TolkienCharacter gimli;
    TolkienCharacter gandalf;
    List<TolkienCharacter> fellowshipOfTheRing;

    @BeforeAll
    void init() {
        sauron = new TolkienCharacter("Sauron", MAIAR, 30000, 1.95);
        frodo = new TolkienCharacter("Frodo", HOBBIT, 33, 1.2);
        sam = new TolkienCharacter("Sam", HOBBIT, 27, 1.3);
        pippin = new TolkienCharacter("Pippin", HOBBIT, 26, 1.25);
        merry = new TolkienCharacter("Merry", HOBBIT, 25, 1.19);
        frodo.setFriends(List.of(sam, merry, pippin));
        sam.setFriends(List.of(frodo, merry, pippin));
        pippin.setFriends(List.of(sam, merry, frodo));
        merry.setFriends(List.of(sam, frodo, pippin));
        boromir = new TolkienCharacter("Boromir", MAN, 35, 1.8);
        aragorn = new TolkienCharacter("Aragorn", MAN, 80, 1.9);
        legolas = new TolkienCharacter("Legolas", ELF, 1000, 1.7);
        elrond = new TolkienCharacter("Elrond", ELF, 30000, 1.7);
        gandalf = new TolkienCharacter("Gandalf", MAIAR, 30000, 1.8);
        gimli = new TolkienCharacter("Gimli", DWARF, 119, 1.35);
        fellowshipOfTheRing = List.of(frodo, sam, pippin, merry, boromir, gimli, gandalf, aragorn, legolas);
    }

}
