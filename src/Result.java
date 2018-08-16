import java.util.ArrayList;

public class Result {
    private String eventName;
    private int participantNumber;
    private double resultDouble;

    public Result(int participantNumber, String eventName, double result) {
        this.resultDouble = result;
        this.eventName = eventName;
        this.participantNumber = participantNumber;
    }

    public int getParticipantNumber() {
        return participantNumber;
    }
    public double getResult() {
        return resultDouble;
    }
    public String getEventName() {
        return eventName;
    }
}
