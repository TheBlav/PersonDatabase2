package IO;

import data.Person;
import interfaces.Printer;

import java.util.Scanner;

public class io implements Printer {
    Scanner sc = new Scanner(System.in);
    public Person createPerson(){
        print("Podaj imię: ");
        String name = sc.nextLine();
        print("Podaj nazwisko: ");
        String lastName = sc.nextLine();
        print("Podaj numer pesel: ");
        String pesel = sc.nextLine();

        return new Person(name, lastName, pesel);
    }

    public String getString(){
        return sc.nextLine();
    }
    public int getInt() {return sc.nextInt();}

    public void closeScanner(){
        sc.close();
    }



}
