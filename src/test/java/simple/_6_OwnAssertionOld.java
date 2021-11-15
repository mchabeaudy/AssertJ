package simple;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import character.Race;
import character.TolkienCharacter;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class _6_OwnAssertionOld extends TolkienTest {

    @Test
    void testNameAndRace() {
        assertNotNull(frodo);
        assertEquals("Frodo", frodo.getName());
        assertEquals(Race.HOBBIT, frodo.getRace());
    }

    @Test
    void testFriendNames() {
        assertNotNull(frodo);
        var friendNames = frodo.getFriends().stream()
                .map(TolkienCharacter::getName)
                .collect(Collectors.toList());

        // solution 1
        assertTrue(friendNames.contains("Sam"));
        assertTrue(friendNames.contains("Merry"));
        assertTrue(friendNames.contains("Pippin"));
        assertTrue(friendNames.contains("Curious character"));
        assertTrue(friendNames.contains("xxxx"));

        // solution 2
        assertAll(
                () -> assertTrue(friendNames.contains("Sam")),
                () -> assertTrue(friendNames.contains("Merry")),
                () -> assertTrue(friendNames.contains("Pippin")),
                () -> assertTrue(friendNames.contains("Curious character")),
                () -> assertTrue(friendNames.contains("xxxx"))
        );
    }

}
