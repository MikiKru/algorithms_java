package exercise.service;

import exercise.controller.CourseController;
import exercise.model.Course;
import exercise.model.CourseCategory;
import exercise.model.Participant;

import java.time.LocalDate;
import java.util.List;

// klasa logiki biznesowej - implementacja i walidacja
public class CourseService {
    public boolean addCourse(String acronim,
                             CourseCategory category,
                             List<Participant> participants,
                             LocalDate date,
                             String trainer){
        try {
            Course course = new Course(
                    acronim,
                    category,
                    participants,
                    date,
                    trainer);
            // dodaj kurs do listy kursów
            CourseController.courses.add(course);
            // zwróć wartość true
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
