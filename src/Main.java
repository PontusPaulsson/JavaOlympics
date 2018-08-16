import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    private static ArrayList<Event> eventList = new ArrayList<Event>();
    private static ArrayList<Participant> participantList = new ArrayList<Participant>();
    private static ArrayList<Result> resultList = new ArrayList<Result>();
    public static void main(String[] args)
    {
        boolean run = true;
        String cmd;
        System.out.println("Welcome to the JavaOlympics!");
        System.out.println("What do you want to do?");
        System.out.println("add event / add participant / remove participant / add result / list participant");
        while(run)
        {

            System.out.print("Cmd: ");
            cmd = sc.nextLine();
            execCmd(cmd);
        }
    }
    public static void execCmd(String Cmd)
    {
        if(Cmd.equals("ae"))
        {
            addEvent();
        }
        if(Cmd.equals("ap"))
        {
            addParticipant();
        }
        if(Cmd.equals("rp"))
        {
            removeParticipant();
        }
        if(Cmd.equals("ar"))
        {
            addResult();
        }
        if(Cmd.equals("le"))
        {
           for(Event event : eventList)
           {
               System.out.println(event.getName());
           }
        }

        if(Cmd.equals("lp"))
        {
            for(Participant participant : participantList)
            {
                System.out.println(participant.getFirstName() + " " + participant.getLastName());
            }
        }
    }
    public static void addParticipant()
    {
        String firstName = "";
        String lastName = "";
        String teamName = "";
        int participantNumber;
        int participantCounter = 100;
        participantNumber = participantCounter;
        System.out.print("Firstname: ");
        firstName = sc.nextLine();
        System.out.print("Lastname: ");
        lastName = sc.nextLine();
        System.out.print("Teamname: ");
        teamName = sc.nextLine();
        while(firstName.equals("") || lastName.equals("") || teamName.equals(""))
        {
            System.out.println("Error names cannot be empty!");
            if(firstName.equals(""))
            {
                System.out.println("Enter firstname again: ");
                firstName = sc.nextLine();
            }
            if(lastName.equals(""))
            {
                System.out.println("Enter lastname again: ");
                lastName = sc.nextLine();
            }
            if(teamName.equals(""))
            {
                System.out.println("Enter teamname again: ");
                teamName = sc.nextLine();
            }
        }
        participantList.add(new Participant(normalizeText(firstName), normalizeText(lastName), normalizeText(teamName), participantNumber));
        System.out.println("Participant " + normalizeText(firstName) + " " + normalizeText(lastName) + " of " + normalizeText(teamName) + " with number " + participantNumber + " added.");
        participantCounter++;
    }
    public static void addEvent()
    {
        int attempts;
        String eventName = "";
        System.out.print("Name of event: ");
        eventName = sc.nextLine();
        while(eventName.equals(""))
        {
            System.out.println("Error: Event name cannot be empty!");
            System.out.print("Name of event: ");
            eventName = sc.nextLine();
            sc.nextLine();
        }
        System.out.print("Attemps: ");
        attempts = sc.nextInt();
        while(attempts < 1)
        {
            System.out.print("Error: attempts must be greater than 1, enter new attempts: ");
            attempts = sc.nextInt();
            sc.nextLine();
        }
        if(!doesEventExist(normalizeText(eventName)))
        {
            eventList.add(new Event(normalizeText(eventName), attempts));
            System.out.println("Event " + normalizeText(eventName) + " added.");
        }
        else
        {
            System.out.println("Error: Event " + normalizeText(eventName) + " already exists.");
        }
        sc.nextLine();
    }
    public static void removeParticipant()
    {
        int participantNumberToRemove;
        System.out.print("Participantnumber to remove: ");
        participantNumberToRemove = sc.nextInt();
        int i = -1;
        for(Participant participant : participantList)
        {
            if(participant.getParticipantNumber() == participantNumberToRemove){
                i = participantList.indexOf(participant);
            }
        }
        if(i > -1)
        {
            participantList.remove(i);
            System.out.println("Participant with number " + participantNumberToRemove + " is removed.");
        }
        else
        {
            System.out.println("Could not find any participant with number " + participantNumberToRemove + ".");
        }
        sc.nextLine();
    }
    public static void addResult()
    {
        Event event1;
        String eventName;
        double resultDouble;
        Participant participant1 = null;
        int attempts;
        System.out.print("Participantnumber: ");
        int participantNumber = sc.nextInt();
        System.out.print("Eventname: ");
        eventName = sc.next();
        System.out.print("Result: ");
        resultDouble = sc.nextDouble();
        while(resultDouble < 0)
        {
            System.out.print("Error result must be greater than or equal to zero!");
            System.out.print("Result: ");
        }
        if (!doesParticipantExist(participantNumber)) {
            System.out.println("Error: Participant " + participantNumber + " does not exist.");
        }
        if(!doesEventExist(normalizeText(eventName))) {
            System.out.println("Error: Event " + normalizeText(eventName) + " does not exist.");
        }
        if(doesEventExist(normalizeText(eventName)) && doesParticipantExist(participantNumber)) /*&& numberOfEventResults(eventName, participantNumber)*/{

            for(Event event : eventList) {
                if (event.getName() == normalizeText(eventName)) {
                    event1 = new Event(event.getName(), event.getAttempts());
                }
            }
            for(Participant participant : participantList ) {
                if (participant.getParticipantNumber() == participantNumber) {
                    participant1 = new Participant(participant.getFirstName(), participant.getLastName(), participant.getTeamName(), participant.getParticipantNumber());
                }
            }
            System.out.print("Result for " + participant1.getFirstName() + " " + participant1.getLastName() + " from " + participant1.getTeamName() + " in " + normalizeText(eventName)+ " result " + resultDouble + " added.");
            sc.nextLine();
        }
        resultList.add(new Result(participantNumber, normalizeText(eventName), resultDouble));
    }
    public static String normalizeText(String text)
    {
        return text.substring(0, 1 ).toUpperCase() + text.substring(1).toLowerCase().replace(" ", "");

    }
    public static boolean doesEventExist(String eventName)
    {
        boolean exists = false;
        for(Event event : eventList)
        {
            if(event.getName().equals(eventName)) {
                exists = true;
            }
            else {
                exists = false;
            }

        }
        return exists;
    }
    public static boolean doesParticipantExist(int participantNumber)
    {
        boolean exists = false;
        for(Participant participant : participantList)
        {
            {
                if(participant.getParticipantNumber() == participantNumber)
                    exists =  true;
                else
                    exists = false;
            }

        }
        return exists;
    }
    public static boolean numberOfEventResults(String eventName, int participantNumber)
    {
        int i = 0;
        int allowedAttempts = 0;

        for(Result result : resultList)
        {
            if(result.getEventName().equals(eventName) && result.getParticipantNumber()==participantNumber)
            {
                i++;
            }
        }
        for(Event event : eventList)
        {
            if(event.getName().equals(eventName))
            {
                allowedAttempts = event.getAttempts();
            }
        }
        if(i >= allowedAttempts)
        {
            return false;
        }
        else
        {
            return true;
        }


    }
}
