package data;

public enum choice{
ADD(1, "Dodanie nowej osoby"),
PRINT(2, "Wydruk istniejącej tablicy"),
GET(3, "Znajdź osobę"),
SIZE(4, "Podaj ilość rekordó w tablicy"),
REMOVE(5, "Usuń dane osoby"),
EXIT(9, " Wyjście z programu");
private final int value;
private final String description;

    choice(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

}
