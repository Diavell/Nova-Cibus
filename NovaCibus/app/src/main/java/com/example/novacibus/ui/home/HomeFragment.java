package com.example.novacibus.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.novacibus.Main2Activity;
import com.example.novacibus.R;
import com.example.novacibus.Sepet;
import com.example.novacibus.ui.hakkinda.HakkindaFragment;
import com.example.novacibus.ui.urunler.UrunlerFragment;
import com.example.novacibus.ui.urunler2.Urun1;
import com.example.novacibus.ui.urunler2.Urun2;
import com.example.novacibus.ui.yk.YkFragment;

public class HomeFragment extends Fragment {

    ImageButton homeimage1, homeimage2, homeimage3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeimage1 = root.findViewById(R.id.homeimage1);
        homeimage2 = root.findViewById(R.id.homeimage2);
        homeimage3 = root.findViewById(R.id.homeimage3);

        homeimage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HakkindaFragment hakkindaFragment = new HakkindaFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.nav_host_fragment,hakkindaFragment, "hakkinda");
                transaction.commit();
            }
        });

        homeimage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UrunlerFragment urunlerFragment = new UrunlerFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.nav_host_fragment,urunlerFragment, "urunler");
                transaction.commit();
            }
        });


        return root;
    }
}