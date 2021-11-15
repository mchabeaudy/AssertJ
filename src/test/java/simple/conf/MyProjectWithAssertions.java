package simple.conf;

import character.TolkienCharacter;
import org.assertj.core.api.WithAssertions;

public interface MyProjectWithAssertions extends WithAssertions {

    default TolkienCharacterAssert assertThat(TolkienCharacter actual){
        return MyProjectAssertions.assertThat(actual);
    }

}
