package diploma.gyumri.theatre.view.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import diploma.gyumri.theatre.R;
import diploma.gyumri.theatre.model.Event;

/**
 * Created by sofi on 7/27/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;

    public MyViewHolder(View itemView) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.imgEvent);
    }

    public void initData(Event event, Context context){

        Picasso.with(context).load(event.getImgUrl()).into(image);
    }

}
