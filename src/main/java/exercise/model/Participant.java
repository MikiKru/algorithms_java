package exercise.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Participant {
    // licznik uczestników - statyczny
    private static int id = 1;
    private int user_id;
    private String name;
    private String lastname;

    public Participant(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.user_id = id;
        id++;
    }
}
