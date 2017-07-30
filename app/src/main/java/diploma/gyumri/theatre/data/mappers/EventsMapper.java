package diploma.gyumri.theatre.data.mappers;

import java.util.ArrayList;
import java.util.List;

import diploma.gyumri.theatre.data.dto.EventDTO;
import diploma.gyumri.theatre.data.dto.EventsDTO;
import diploma.gyumri.theatre.model.Event;

/**
 * Created by root on 7/30/17.
 */

public class EventsMapper {
    public static List<Event> toEvents(EventsDTO eventsDTO) {
        List events = new ArrayList(eventsDTO.getEvents().size());
        if (events.size() != 0) {
            for (EventDTO x : eventsDTO.getEvents()) {
                events.add(EventMapper.toEvent(x));
            }
            return events;
        }
        return null;
    }
}
