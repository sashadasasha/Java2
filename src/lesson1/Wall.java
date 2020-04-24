package lesson1;

public class Wall {

    private final String title;
    private final double height;

    public Wall(String title, double height) {
        this.title = title;
        this.height = height;
    }

    public void doJump(Jumping jumpObject) {
        double jumpHeight = jumpObject.jump(this.height);
        if (jumpHeight >= this.height) {
            System.out.println("Прыжок!");
        } else {
            System.out.println("Слишком высоко");
        }
    }
}
