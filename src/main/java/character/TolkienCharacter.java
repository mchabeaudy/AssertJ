package character;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TolkienCharacter {

    private int age;
    double height;
    private String name;
    private Race race;
    private List<TolkienCharacter> friends = new ArrayList<>();


    public TolkienCharacter() {
    }

    public TolkienCharacter(String name) {
        this.name = name;
    }

    public TolkienCharacter(String name, Race race, int age, double height) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return getName();
    }

    public void setFriends(List<TolkienCharacter> friends) {
        Objects.requireNonNull(friends);
        this.friends = new ArrayList<>(friends);
    }
}
