package Lesson_5.Homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {

    private Car winner = null;
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }

    public void setWinner (Car winner) {
        if (this.winner == null) {
            this.winner = winner;
            System.out.println(winner.getName() + " - WIN");
        }
    }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
