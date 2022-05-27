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

    public void loop(Person[] persons){
        PersonDatabase database = new PersonDatabase();
        boolean endOfProgram = false;
        do{
        System.out.println(Arrays.toString(choice.values()));
        print("Wybierz działanie: ");
        String userChoice = inOut.getString().toUpperCase();
        choices = choice.valueOf(userChoice);

        switch (choices){

            case ADD -> {
                persons = database.addPerson(persons);
            }
            case PRINT -> {
                database.printArray(persons);
            }
            case GET -> {
                SearchType find;
                print("Wybrałeś wyszukiwanie danych osobowych.");
                print("Wybierz sposó identyfikacji: ");
                print("Po numerze porządkowym, wpisz LP");
                print("Po Imieniu oraz Nazwisku, wpisz NN");
                print("Po numerze PESEL, wpisz PESEL ");
                print("Wybieram: ");
                String searchType = inOut.getString();
                find = SearchType.valueOf(searchType);
                switch (find){

                    case LP -> {
                        getPersonFromIndex(persons, database);
                    }
                    case NN -> {
                        getPersonFromNames(persons, database);
                    }
                    case PESEL -> {
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
                persons = database.remove( persons, persons[index]);
            }
            case EXIT -> {
                endOfProgram = true;
            }
            default -> {
                print("Błędny wybór, spróbuj ponownie");
            }
        }


        } while (!endOfProgram);
    }

    private void getPersonFromNames(Person[] persons, PersonDatabase database) {
        boolean equal = false;
        print("Podaj imię: ");
        String seachedName = inOut.getString();
        print("Podaj nazwisko: ");
        String searchedLastName = inOut.getString();
        Person foundPerson = null;
        for (int i = 0; i < persons.length && !equal; i++) {
            if (persons[i].getFirstName().toLowerCase().equals(seachedName.toLowerCase()) &&
                    persons[i].getLastName().toLowerCase().equals(searchedLastName)){
                    equal = true;
                    foundPerson = persons[i];
            }
        }
        if (equal) {
            print("Znaleziono osobę: ");
            print(foundPerson.toString());
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
