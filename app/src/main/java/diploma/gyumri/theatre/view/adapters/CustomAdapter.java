package diploma.gyumri.theatre.view.adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import diploma.gyumri.theatre.R;
import diploma.gyumri.theatre.model.Event;
import diploma.gyumri.theatre.view.fragments.EventFragment;
import diploma.gyumri.theatre.view.viewholders.MyViewHolder;

public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener {
    private List<Event> events;
    private Context context;
    private LayoutInflater inflater;
    private FragmentManager fragmentManager;

    public CustomAdapter(List<Event> events, Context context, FragmentManager fragmentManager) {
        this.events = events;
        this.context = context;
        this.fragmentManager = fragmentManager;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.event_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Event event = getItem(position);
        holder.initData(event, context);
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        if (events == null) {
            events = new ArrayList<>();
        }
        return events.size();
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        if (position == 2) {
            events.get(position).setVideoUrl(null);
        }
        fragmentManager.beginTransaction().replace(R.id.container, new EventFragment(events.get(position))).addToBackStack(null).commit();

    }

    public Event getItem(int position) {
        if (events != null && position >= 0 && position < events.size()) {
            return events.get(position);
        } else {
            return null;
        }
    }
}
