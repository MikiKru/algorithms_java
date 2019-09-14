package exercise.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
public class Course {
    private String acronim;
    private CourseCategory category;
    private List<Participant> participants;
    private LocalDate date;
    private String trainer;

    // metoda dodająca jednego uczestnika do kursu
    public void addParticipant(Participant participant){
        participants.add(participant);
    }
    // metoda usuwająca jednego uczestnika z kursu
    public void removeParticipant(Participant participant){
        participants.remove(participant);
    }

//    public static void main(String[] args) {
//        List<Participant> participants = new ArrayList<>(Arrays.asList(
//               new Participant("U1","U1"),
//               new Participant("U2","U2"),
//               new Participant("U3","U3")
//        ));
//        Course course1 = new Course(
//                "javabyd10",
//                CourseCategory.developer,
//                participants,
//                LocalDate.now(),
//                "MK");
//        System.out.println(course1);
//    }
}
