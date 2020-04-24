package lesson1;

public class Robot  implements Jumping, Running {
    double height = DEFAULT_HEIGHT*50;
    double distance = DEFAULT_DISTANCE*10;
    public String name;

    public Robot(String name) {
        this.name = name;
    }

    public Robot(String name, double height) {
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
