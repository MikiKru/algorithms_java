package exercise.service;

import exercise.controller.CourseController;
import exercise.model.Course;
import exercise.model.CourseCategory;
import exercise.model.Participant;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// klasa logiki biznesowej - implementacja i walidacja
public class CourseService {
    public boolean addParticipantToCourse(
            String acronim,
            String name,
            String lastname) {
        // wyszukaj kurs po akronimie
        if(getCourseByAcronim(acronim).isPresent()){
            Course findedCourse = getCourseByAcronim(acronim).get();
            findedCourse.addParticipant(new Participant(name, lastname));
            return true;
        }
        return false;
    }
    public Optional<Course> getCourseByAcronim(String acronim){
        return CourseController.courses.stream()
                .filter(course -> course.getAcronim().equals(acronim))
                .findAny();
    }

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
