package ru.geekbrains.java3.homeworks.homework5;

public class Car implements Runnable {
    private static int winnerCount = 0;
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            Multithreading.BARRIER.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            synchronized (race.getMon()) {
                if (winnerCount++ == 0) {
                    System.out.println("ВОТ ОН НАШ ПОБЕДИТЕЛЬ! ВОТ!:  " + this.name);
                } else {
                    System.out.println(this.name + " пришел " + winnerCount + "м!");
                }
            }
            Multithreading.BARRIER.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}