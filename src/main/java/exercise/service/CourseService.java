package exercise.service;

import exercise.controller.CourseController;
import exercise.model.Course;
import exercise.model.CourseCategory;
import exercise.model.Participant;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// klasa logiki biznesowej - implementacja i walidacja
public class CourseService {

    public List<Course> findCourseByDateOrCategory(LocalDate date, CourseCategory category){
        if(date == null && category == null){
            return CourseController.courses;
        } else if(date != null && category == null){
            return CourseController.courses.stream()
                    .filter(course -> course.getDate().equals(date))
                    .collect(Collectors.toList());
        } else if(date == null){
            return CourseController.courses.stream()
                    .filter(course -> course.getCategory() == category)
                    .collect(Collectors.toList());
        } else {
            return CourseController.courses.stream()
                    .filter(course -> (course.getCategory()==category && course.getDate().equals(date)))
                    .collect(Collectors.toList());
        }
    }


    public boolean updateTrainerInCourse(String acronim, String trainer){
        if(getCourseByAcronim(acronim).isPresent()){
            Course findedCourse = getCourseByAcronim(acronim).get();
            findedCourse.setTrainer(trainer);
            return true;
        }
        return false;
    }
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
