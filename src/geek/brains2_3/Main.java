package geek.brains2_3;

import java.util.Arrays;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        String[] words = new String[]{"Слово", "Слово2", "Слово3", "Слово4", "Слово5", "Слово6", "Слово7", "Слово", "Слово8", "Слово9", "Слово10", "Слово",
                "Слово11", "Слово12", "Слово5", "Слово13", "Слово", "Слово6", "Слово4", "Слово15", "Слово2"};

        //Words.printUnicWords(words);
        //Words.countOfWords(words);

        TelephoneBook.add("+79096878787", "Астафьев");
        TelephoneBook.add("+7909000000", "Петров");
        TelephoneBook.add("+798996878787", "Дементьев");
        TelephoneBook.add("+7999965657", "Крылатов");
        TelephoneBook.add("+9865656565", "Петров");
        TelephoneBook.add("7777777", "Гущин");


        TelephoneBook.get("Петров");
        TelephoneBook.get("Гущин");
        //TelephoneBook.get("Иванов");

    }
}
