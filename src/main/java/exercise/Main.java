package exercise;

import exercise.controller.CourseController;
import exercise.model.CourseCategory;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CourseController courseController = new CourseController();
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
        courseController.getCourtses();
    }
}
