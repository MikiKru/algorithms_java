package exercise.controller;
import exercise.model.Course;
import exercise.model.CourseCategory;
import exercise.model.Participant;
import exercise.service.CourseService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// klasa obsługi żądań użytkownika
public class CourseController {
    // globalna lista statyczna przechowująca kursy - obiekty klasy Course
    public static List<Course> courses = new ArrayList<>();
    CourseService courseService;
    // wstrzyknięcie obiektu klasy CourseService do klasy Course Controller
    public CourseController() {
        this.courseService = new CourseService();
    }

    public void addCourse(String acronim,
                          CourseCategory category,
                          List<Participant> participants,
                          LocalDate date,
                          String trainer){
        // wywołaj metodę implementującą utworzenie kursu w logice biznesowej
        courseService.addCourse(acronim,category,participants,date,trainer);
    }
}
