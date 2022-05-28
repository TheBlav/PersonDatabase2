package IO;

import data.Person;
import data.PersonDatabase;
import data.SearchType;
import data.choice;
import interfaces.Printer;

import java.awt.*;
import java.util.Arrays;

public class Loop implements Printer {
    io inOut = new io();
    choice choices;
    SearchType searchTypes;

    public void loop(Person[] persons){
        PersonDatabase database = new PersonDatabase();
        boolean endOfProgram = false;
        do{
            try {
                System.out.println(Arrays.toString(choice.values()));
                print("Wybierz działanie: ");
                String userChoice = inOut.getString().toUpperCase();
                choices = choice.valueOf(userChoice);

                switch (choices) {

                    case ADD -> {
                        print("Podaj ilość osób, które chcesz wprowadzić do systemu: ");
                        int amount = inOut.getInt();
                        for (int i = 0; i<amount; i++){
                        persons = database.addPerson(persons);
                        }
                        userChoice = inOut.getString();
                    }
                    case PRINT -> {
                        database.printArray(persons);
                    }
                    case GET -> {
                        SearchType find;

                        System.out.println(Arrays.toString(searchTypes.values()));
                        print("Wybieram: ");
                        String searchType = inOut.getString();
                        find = SearchType.valueOf(searchType.toUpperCase());
                        switch (find) {

                            case LP -> {
                                getPersonFromIndex(persons, database);
                            }
                            case NN -> {
                                getPersonFromNames(persons, database);
                            }
                            case PESEL -> {
                                getPersonFromPesel(persons, database);
                            }
                        }
                    }

                    case SIZE -> {
                        database.size(persons);
                    }
                    case REMOVE -> {
                        int index = 0;
                        for (Person person : persons) {
                            System.out.print(index + " - " + person.getFirstName());
                            index++;
                        }
                        print("Wybierz osobę, której dane chcesz usunąć: ");
                        persons = database.remove(persons, persons[index]);
                    }
                    case EXIT -> {
                        endOfProgram = true;
                    }
                    default -> {
                        print("Błędny wybór, spróbuj ponownie");
                    }
                }
            }  catch ( IllegalArgumentException e){
                System.err.println("Podano błędny wybór");
            }

        } while (!endOfProgram);
    }

    private void getPersonFromPesel(Person[] persons, PersonDatabase database) {
        boolean equal = false;
        print ("Podaj poszukiwany numer PESEL: ");
        String searchedPesel = inOut.getString();
        for (int i=0; i<persons.length && !equal; i++){
            if (persons[i] != null){
                equal = true;
                print(persons[i]);
            }
        }
        if (!equal)
            print("Nie odnaleziono osoby z podanym numerem pesel: " + searchedPesel);
    }

    private void getPersonFromNames(Person[] persons, PersonDatabase database) {
        boolean equal = false;
        print("Podaj imię: ");
        String seachedName = inOut.getString().toLowerCase();
        print("Podaj nazwisko: ");
        String searchedLastName = inOut.getString().toLowerCase();
        Person foundPerson = null;
        StringBuilder personsFound = new StringBuilder();
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null) {
                if (persons[i].getFirstName().toLowerCase().equals(seachedName) &&
                        persons[i].getLastName().toLowerCase().equals(searchedLastName)) {
                    equal = true;
                    personsFound.append(persons[i] + "\n");
                }
            }
        }
        if (equal) {
            print("Znaleziono osobę: ");
            print(personsFound);
        }
        else
            print("Nie znaleziono osoby o podanym Imieniu: " + seachedName + ", oraz Nazwisku: " + searchedLastName);
    }

    private void getPersonFromIndex(Person[] persons, PersonDatabase database) {
        int index = 0;
        for (Person person : persons) {
            System.out.print(index + " - " + person.getFirstName());
            index++;
        }
        print("Podaj numer osoby której dane chcesz wyświetlić: ");
        int showPerson = inOut.getInt();
        database.get(persons, showPerson);
    }
}
