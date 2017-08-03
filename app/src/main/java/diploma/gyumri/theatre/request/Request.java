package diploma.gyumri.theatre.request;

import android.widget.Toast;

import java.util.List;

import diploma.gyumri.theatre.MyApplication;
import diploma.gyumri.theatre.data.dto.EventsDTO;
import diploma.gyumri.theatre.data.mappers.EventsMapper;
import diploma.gyumri.theatre.model.Event;
import diploma.gyumri.theatre.model.User;
import diploma.gyumri.theatre.view.activities.MainActivity;
import diploma.gyumri.theatre.view.activities.RegistrationActivity;
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


    public static void register(final RegistrationActivity activity, User user) {
        ((MyApplication) activity.getApplication()).getApiService().register(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(activity, "Stugenq internet@", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
