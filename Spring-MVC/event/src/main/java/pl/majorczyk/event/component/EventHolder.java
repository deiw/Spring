package pl.majorczyk.event.component;

import org.springframework.stereotype.Component;
import pl.majorczyk.event.model.Participant;

import java.util.LinkedList;
import java.util.List;

@Component
public class EventHolder {
    private List<Participant> participants;
    public EventHolder(){
        participants=new LinkedList<>();
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void addParticipant(Participant participant){
        participants.add(participant);
    }
    public boolean checkRegistration(Participant participant){
        return participants.contains(participant);
    }
}
