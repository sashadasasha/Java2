package geek.brains2_2;

public class MyArrayDataException extends NumberFormatException {
    private int a;
    private int b;

    public MyArrayDataException(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String getMessage() {
        return String.format("В массиве по адресу [%s][%s] не число", a, b);
    }
}

