package pt.ua.aguiar.sergio.app2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import pt.ua.aguiar.sergio.app2.databinding.FragmentBBinding;

public class FragmentB extends Fragment {

    Singleton singleton;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        singleton = Singleton.getInstance();

        FragmentBBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_b, container, false);
        binding.setCityName(singleton.getCityName());

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
