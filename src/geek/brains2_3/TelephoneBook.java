package geek.brains2_3;

import java.util.HashMap;

public class TelephoneBook {

    public static HashMap<String, String> telephoneBook = new HashMap<>();

    public static void add(String telephoneNumber, String name) {
        telephoneBook.put(telephoneNumber, name);
    }

    public static void get(String name) {
        int countEqualnumbers = 0;
        for (String key : telephoneBook.keySet()) {
            if (telephoneBook.get(key).equals(name)) {
                System.out.println(telephoneBook.get(key) + " => " + key);
                countEqualnumbers++;
            }
        }
        if (countEqualnumbers == 0) {
            System.out.println("Такого абонента нет");
        }
    }
}
