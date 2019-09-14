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
        courseController.addCourse(
                "javabyd12",
                CourseCategory.developer,
                new ArrayList<>(),
                LocalDate.of(2019,10,10),
                "KK");
        courseController.addCourse(
                "javator1",
                CourseCategory.analyst,
                new ArrayList<>(),
                LocalDate.of(2019,05,01),
                "EE");
        // dodawanie uczestników
        courseController.addParticipantToCourse("javabyd11","Adam","Kowalski");
        courseController.addParticipantToCourse("javabyd11","Jan","Kot");
        courseController.addParticipantToCourse("javabyd10","Jan","Kot");
        courseController.addParticipantToCourse("javabyd10","Jan","Nowak");
        courseController.addParticipantToCourse("javabyd10","Iwona","Las");
        // ???
        courseController.addParticipantToCourse("javabyd14","Iwona","Las");
        System.out.println("Przed usuwaniem");
        courseController.getCourtses();
        System.out.println("Po usuwaniu");
        courseController.removeParticipantFromCourse("javabyd10", 3);
        courseController.removeParticipantFromCourse("javabyd11", 3);
        courseController.removeParticipantFromCourse("javabyd15", 1);
        courseController.getCourtses();
        // zmiana trenera
        System.out.println("Po zmianie trenera");
        courseController.updateTrainerInCourse("javabyd10", "XX");
        courseController.updateTrainerInCourse("javabyd9", "YY");
        courseController.getCourtses();

        System.out.println("Filtrowanie");
        courseController.findCourseByDateOrCategory(null, null);
    }
}
