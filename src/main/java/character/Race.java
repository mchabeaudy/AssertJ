package character;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Race {
    HOBBIT("Hobbit"),
    MAN("Man"),
    DWARF("Drawf"),
    ELF("Elf"),
    MAIAR("Maiar"),
    ORC("Orc");
    private final String name;


}
