package geek.brains2_3;

import java.util.Arrays;
import java.util.HashSet;

public class Words {

    public static void printUnicWords(String[] words) {
        HashSet<String> unicWordsList = new HashSet<>(Arrays.asList(words));

        for (String unicWord : unicWordsList) {
            System.out.println(unicWord);
        }

    }

    public static void countOfWords(String[] words) {
        HashSet<String> unicWordsList = new HashSet<>(Arrays.asList(words));
        for (String unicWord : unicWordsList) {
            int count = 0;
            for (String word : words) {
                if (unicWord.equals(word)) {
                    count++;
                }
            }

            System.out.printf("Слово \"%s\" встречается в массиве %d раз%n", unicWord, count);
        }

    }
}
