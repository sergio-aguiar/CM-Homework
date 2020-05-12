package pt.ua.aguiar.sergio.app2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.navigation.fragment.NavHostFragment;

import static android.content.Context.WINDOW_SERVICE;

public class FragmentA extends Fragment {

    ListView listView;
    String[] listArray;

    Singleton singleton;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        singleton = Singleton.getInstance();
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.fragment_a_list_view);
        listArray = getResources().getStringArray(R.array.array_list);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(view.getContext(), R.layout.text_list_layout, listArray);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                singleton.setCityName(parent.getItemAtPosition(position).toString());
                if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE)
                    NavHostFragment.findNavController(FragmentA.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);
                else {

                }
            }
        });
    }
}
