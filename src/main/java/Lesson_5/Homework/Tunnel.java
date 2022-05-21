package Lesson_5.Homework;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private static Semaphore tunnelSemaphore;
    public Tunnel(int maxCarInTunnel) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.tunnelSemaphore = new Semaphore(maxCarInTunnel);
    }
    @Override
    public void go(Car c) {
        try {
            tunnelSemaphore.acquire();

            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            System.out.println(c.getName() + " закончил этап: " + description);
            tunnelSemaphore.release();
        }
    }
}
