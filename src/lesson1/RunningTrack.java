package lesson1;

public class RunningTrack {
    private final String title;
    private final int length;

    public RunningTrack(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public void doRun(Running runningObject) {
        double runDistance = runningObject.run(this.length);
        if (runDistance >= this.length) {
            System.out.println("Пробежал!");
        } else {
            System.out.println("Слишком большая дистанция");
        }
    }

}

