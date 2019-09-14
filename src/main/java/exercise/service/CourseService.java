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
    public boolean removeParticipantFromCourse(String acronim, int user_id){
        if(getCourseByAcronim(acronim).isPresent()){
            // wyszukany kurs
            Course findedCourse = getCourseByAcronim(acronim).get();
            // wyszukaj uwczestnika w znależionym kursie po id
            if(findParticipantByIdInCourse(findedCourse,user_id).isPresent()){
                Participant participantToRemove = findParticipantByIdInCourse(findedCourse,user_id).get();
                // usunięcie uczestnika z kursu
                findedCourse.removeParticipant(participantToRemove);
                return true;
            }
            return false;
        }
        return false;
    }
    // metoda wyszukująca uczestnika po id w danym kursie
    public Optional<Participant> findParticipantByIdInCourse(Course findedCourse, int user_id){
         return findedCourse.getParticipants().stream()
                 .filter(participant -> participant.getUser_id() == user_id).findAny();
    }

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
