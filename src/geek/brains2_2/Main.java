package geek.brains2_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String[][] goodArray = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] badArray = new String[][]{{"1", "notNumber", "3", "4"}, {"5", "6", "NotNumber!!!", "8"},
                {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] tooLongArray = new String[5][7];

        try {
            System.out.printf("Сумма элементов массива = %d", arrayReduction(goodArray));
            //System.out.printf("Сумма элементов массива = %d", arrayReduction(badArray));
            //System.out.printf("Сумма элементов массива = %d", arrayReduction(tooLongArray));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int arrayReduction(String[][] arr) {
        if (arr.length > 4) {
            throw new MyArraySizeException();
        }
        for (String[] strings : arr) {
            if (strings.length > 4) throw new MyArraySizeException();
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(isInteger(arr[i][j])) {
                    sum += Integer.parseInt(arr[i][j]);
                } else {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

    public static boolean isInteger(String arrayElement) {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(arrayElement);
        return m.matches();
    }
}
