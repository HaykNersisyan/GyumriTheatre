package diploma.gyumri.theatre.net;

import diploma.gyumri.theatre.data.dto.EventsDTO;
import diploma.gyumri.theatre.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by root on 7/30/17.
 */

public interface APIService {
    @GET("")
    Call<EventsDTO> getEvents();
    @POST("http://asdasdhasghd")
    Call<User> register(@Body User user);
}
