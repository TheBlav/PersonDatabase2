package data;

public enum SearchType {
    LP(1, " - Wyszukiwanie po numerze porządkowym, wpisz LP\n"),
    NN(2, " - Wyszukiwanie po Imieniu oraz Nazwisku, wpsisz NN\n"),
    PESEL(3, " - Wyszukiwanie po numerze PESEL, wpisz PESEL\n");
    private  final int value;
    private final String description;
    SearchType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }
}
