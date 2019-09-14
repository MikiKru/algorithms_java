package exercise;

import exercise.controller.CourseController;
import exercise.model.CourseCategory;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CourseController courseController = new CourseController();
        // dodawanie kursów
        courseController.addCourse(
                "javabyd10",
                CourseCategory.dev_ops,
                new ArrayList<>(),
                LocalDate.now(),
                "MK");
        courseController.addCourse(
                "javabyd11",
                CourseCategory.developer,
                new ArrayList<>(),
                LocalDate.now(),
                "MK");
        // dodawanie uczestników
        courseController.addParticipantToCourse("javabyd11","Adam","Kowalski");
        courseController.addParticipantToCourse("javabyd11","Anna","Kowalska");
        courseController.addParticipantToCourse("javabyd10","Jan","Kot");
        courseController.addParticipantToCourse("javabyd10","Jan","Nowak");
        courseController.addParticipantToCourse("javabyd10","Iwona","Las");
        // ???
        courseController.addParticipantToCourse("javabyd14","Iwona","Las");
        courseController.getCourtses();
    }
}
