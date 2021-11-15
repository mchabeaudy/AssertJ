package simple;

import character.TolkienCharacter;
import org.junit.jupiter.api.Test;

public class _2_Exceptions extends TolkienTest {

    @Test
    void throwable() {
        var throwable = new IllegalArgumentException("wrong argument");

        assertThat(throwable)
                .hasMessage("wrong argument")
                .hasMessageStartingWith("wrong")
                .hasMessageMatching("wrong *")
                .hasNoCause();
    }

    @Test
    void causeExample() {
        try {
            var character = new TolkienCharacter();
            setNameToLowerCase(character);

            fail("npe should have been thrown");
            // or
            failBecauseExceptionWasNotThrown(NullPointerException.class);
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(NullPointerException.class)
                    .hasNoCause();
        }

        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> setNameToLowerCase(new TolkienCharacter()))
                .withMessageContaining("null");

        var character = new TolkienCharacter();
        character.setName("Sauron");
        assertThatCode(() -> setNameToLowerCase(character))
                .doesNotThrowAnyException();
    }

    void setNameToLowerCase(TolkienCharacter character) {
        character.setName(character.getName().toLowerCase());
    }

}
