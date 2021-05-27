package com.example.novacibus.ui.yk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.novacibus.R;

public class YkFragment extends Fragment {

    private com.example.novacibus.ui.yk.YkViewModel YkViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        YkViewModel =
                new ViewModelProvider(this).get(YkViewModel.class);
        View root = inflater.inflate(R.layout.fragment_yk, container, false);
        // final TextView textView = root.findViewById(R.id.text_hakkinda);
        //hakkindaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
        //@Override
        //public void onChanged(@Nullable String s) { textView.setText(s); }
        //});
        return root;
    }
}
