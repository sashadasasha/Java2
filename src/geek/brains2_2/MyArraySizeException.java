package geek.brains2_2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public MyArraySizeException() {
        super("Массив больше допустимого размера!");
    }
}
