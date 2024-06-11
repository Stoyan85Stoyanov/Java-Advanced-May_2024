package Exams._12_JavaAdvancedRegularExam25June2022._03_Workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return exercises.removeIf(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle));
    }

    public Exercise getExercise(String name, String muscle) {
        return this.exercises.stream().filter(exercise -> exercise.getName().equals(name)
                && exercise.getMuscle().equals(muscle)).findFirst().orElse(null);
    }
    public Exercise getMostBurnedCaloriesExercise() {
        Exercise exercise = null;
        int calories = 0;

        if (this.exercises.size() > 0) {
            for (Exercise ex : this.exercises) {
                if (ex.getBurnedCalories() > calories) {
                    calories = ex.getBurnedCalories();
                }
            }
            for (Exercise ex : this.exercises) {
                if (ex.getBurnedCalories() == calories) {
                    exercise = ex;
                    break;
                }
            }
        }
        return exercise;
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }
    public String getStatistics() {
        StringBuilder text = new StringBuilder();
        text.append("Workout type").append(": ").append(this.type).append(System.lineSeparator());
        for (Exercise exercise : exercises) {
            text.append(exercise.toString()).append(System.lineSeparator());
        }

        return text.toString().trim();
    }

}
