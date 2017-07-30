package diploma.gyumri.theatre.data.mappers;

import diploma.gyumri.theatre.data.dto.EventDTO;
import diploma.gyumri.theatre.model.Event;

/**
 * Created by root on 7/30/17.
 */

public class EventMapper {
    public static Event toEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setName(eventDTO.getName());
        event.setDesc(eventDTO.getName());
        event.setPrice(eventDTO.getPrice());
        event.setStage(eventDTO.getStage());
        event.setDate(eventDTO.getDate());
        event.setImgUrl(eventDTO.getImgUrl());
        event.setVideoUrl(eventDTO.getVideoUrl());
        return event;
    }
}
