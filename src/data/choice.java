package data;

public enum choice{
ADD(1, "Dodanie nowej osoby - wpisz: Add\n"),
PRINT(2, "Wydruk istniejącej tablicy - wpisz: Print\n"),
GET(3, "Znajdź osobę - wpisz: Get\n"),
SIZE(4, "Podaj ilość rekordó w tablicy - wpisz: Size\n"),
REMOVE(5, "Usuń dane osoby - wpisz: Remove\n"),
EXIT(9, " Wyjście z programu - wpisz: Exit\n");
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
