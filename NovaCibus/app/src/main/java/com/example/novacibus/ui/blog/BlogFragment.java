package com.example.novacibus.ui.blog;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.novacibus.Blog1;
import com.example.novacibus.Main2Activity;
import com.example.novacibus.R;
import com.example.novacibus.ui.hakkinda.HakkindaFragment;
import com.example.novacibus.ui.urunler2.Urun1;
import com.example.novacibus.ui.yk.YkFragment;
import com.example.novacibus.ui.yk.YkViewModel;

public class BlogFragment extends Fragment {

    private com.example.novacibus.ui.blog.BlogViewModel BlogViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*BlogViewModel =
                new ViewModelProvider(this).get(com.example.novacibus.ui.blog.BlogViewModel.class);*/

        View root = inflater.inflate(R.layout.fragment_blog, container, false);

        Button button = root.findViewById(R.id.btn_blog);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Blog1.class);
                startActivityForResult(intent,1);
            }
        });
        return root;
    }
}
