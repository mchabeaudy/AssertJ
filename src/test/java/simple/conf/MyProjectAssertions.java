package simple.conf;

import character.TolkienCharacter;

public class MyProjectAssertions {

    public static TolkienCharacterAssert assertThat(TolkienCharacter actual)
    {
        return new TolkienCharacterAssert(actual);
    }
}
