package diploma.gyumri.theatre.data.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.Data;

/**
 * Created by root on 7/30/17.
 */
@Data
public class EventsDTO {
    @SerializedName("events")
    private ArrayList<EventDTO> events;
}
