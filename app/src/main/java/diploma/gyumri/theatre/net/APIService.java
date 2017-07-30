package diploma.gyumri.theatre.net;

import diploma.gyumri.theatre.data.dto.EventsDTO;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by root on 7/30/17.
 */

public interface APIService {
    @GET("rest/pharmacyservice/get")
    Call<EventsDTO> getEvents();
}
