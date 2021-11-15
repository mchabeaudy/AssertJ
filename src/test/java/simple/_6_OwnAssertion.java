package simple;

import org.junit.jupiter.api.Test;

class _6_OwnAssertion extends TolkienTest {

    @Test
    void testNameAndRace() {
        assertThat(frodo)
                .isAHobbit()
                .hasName("Frodo");
    }

    @Test
    void testFriendNames() {
        assertThat(frodo).hasFriendsWithNames(
                "Sam",
                "Merry",
                "Pippin",
                "Curious character",
                "xxxx"
        );
    }

}
