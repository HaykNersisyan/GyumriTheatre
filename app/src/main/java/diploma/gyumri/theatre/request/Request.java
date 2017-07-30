package diploma.gyumri.theatre.request;

import java.util.List;

import diploma.gyumri.theatre.MyApplication;
import diploma.gyumri.theatre.data.dto.EventsDTO;
import diploma.gyumri.theatre.data.mappers.EventsMapper;
import diploma.gyumri.theatre.model.Event;
import diploma.gyumri.theatre.view.activities.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 7/30/17.
 */

public class Request {
    public static void requestPharmacies(final MainActivity activity) {
        ((MyApplication) activity.getApplication()).getApiService().getEvents().enqueue(new Callback<EventsDTO>() {
            @Override
            public void onResponse(Call<EventsDTO> call, Response<EventsDTO> response) {
                EventsDTO pharmaciesDTO = response.body();
                List<Event> model = EventsMapper.toEvents(pharmaciesDTO);

            }

            @Override
            public void onFailure(Call<EventsDTO> call, Throwable t) {

            }
        });
    }
}
