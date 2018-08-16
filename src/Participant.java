import java.util.ArrayList;

public class Participant {
    private String firstName;
    private String lastName;
    private String teamName;
    private int participantNumber;
    public Participant(String firstName, String lastName, String teamName, int participantNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamName = teamName;
        this.participantNumber = participantNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getTeamName() {
        return teamName;
    }
    public int getParticipantNumber() {
        return participantNumber;
    }
}
