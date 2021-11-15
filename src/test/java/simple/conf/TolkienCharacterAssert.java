package simple.conf;

import character.Race;
import character.TolkienCharacter;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.assertj.core.api.AbstractAssert;

public class TolkienCharacterAssert
        extends AbstractAssert<TolkienCharacterAssert, TolkienCharacter> {

    public TolkienCharacterAssert(TolkienCharacter actual) {
        super(actual, TolkienCharacterAssert.class);
    }


    public TolkienCharacterAssert hasName(String name) {
        // check that actual object is not null
        isNotNull();
        // logic
        if (!Objects.equals(actual.getName(), name)) {
            failWithMessage("Expected character's name to be <%s> but was <%s>", name, actual.getName());
        }
        return this;
    }

    public TolkienCharacterAssert isAHobbit() {
        isNotNull();
        if (actual.getRace() != Race.HOBBIT) {
            failWithMessage("Expected character's race to be <%s> but was <%s>", Race.HOBBIT.getName(),
                    actual.getRace().getName());
        }
        return this;
    }

    public TolkienCharacterAssert hasFriendsWithNames(String... names) {
        isNotNull();
        // Friend names
        var friendNames = actual.getFriends().stream()
                .map(TolkienCharacter::getName)
                .collect(Collectors.toList());
        // Names not found in friend names
        var notFoundNames = Arrays.stream(names)
                .filter(Predicate.not(friendNames::contains))
                .collect(Collectors.toList());
        if (!notFoundNames.isEmpty()) {
            failWithMessage(
                    "Expected character's friends names to contains:\n[%s]\nbut some elements were not found:\n[%s]",
                    String.join(", ", names),
                    String.join(", ", notFoundNames));
        }
        return this;
    }

}
