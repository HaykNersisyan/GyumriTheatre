package diploma.gyumri.theatre.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import diploma.gyumri.theatre.R;
import diploma.gyumri.theatre.model.Event;
import diploma.gyumri.theatre.model.JsonParser;
import diploma.gyumri.theatre.view.adapters.CustomAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private FragmentManager mFragmentManager;

    public MainFragment(FragmentManager fragmentManager) {
        mFragmentManager=fragmentManager;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Event> events = JsonParser.getEventList(getActivity());
        CustomAdapter adapter = new CustomAdapter(events, getActivity(),mFragmentManager);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main, container, false);

    }
    public static MainFragment newInstance(FragmentManager fragmentManager) {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment(fragmentManager);
        fragment.setArguments(args);
        return fragment;
    }

}
