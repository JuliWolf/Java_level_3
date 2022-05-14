package Lesson_5.Homework;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    CyclicBarrier prepareBarrier;
    CyclicBarrier raceBarrier;
    CyclicBarrier readyBarrier;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(
            Race race,
            int speed,
            CyclicBarrier prepareBarrier,
            CyclicBarrier readyBarrier,
            CyclicBarrier raceBarrier
    ) {
        this.race = race;
        this.speed = speed;
        this.raceBarrier = raceBarrier;
        this.readyBarrier = readyBarrier;
        this.prepareBarrier = prepareBarrier;

        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            prepareBarrier.await();

            System.out.println(this.name + " готов");
            Thread.sleep(100);
            readyBarrier.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            race.setWinner(this);

            raceBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
