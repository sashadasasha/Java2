package lesson1;

public class Human implements Jumping, Running {
    double height = DEFAULT_HEIGHT;
    double distance = DEFAULT_DISTANCE;
    public String name;

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, double height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public double jump(double height) {
        if (height <= this.height) {
            System.out.println(this.name + "прыгнул на " + height + " метров");
        } else {
            System.out.println("Слишком высоко");
        }
        return this.height;
    }

    @Override
    public double run(double distance) {
        if (distance <= this.distance) {
            System.out.println(this.name + "пробежал " + distance + " метров");
        } else {
            System.out.println("Слишком высоко");
        }
        return this.distance;
    }
}
