package com.example.novacibus.ui.urunler;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.novacibus.R;
import com.example.novacibus.ui.urunler2.Urun1;
import com.example.novacibus.ui.urunler2.Urun10;
import com.example.novacibus.ui.urunler2.Urun2;
import com.example.novacibus.ui.urunler2.Urun3;
import com.example.novacibus.ui.urunler2.Urun4;
import com.example.novacibus.ui.urunler2.Urun5;
import com.example.novacibus.ui.urunler2.Urun6;
import com.example.novacibus.ui.urunler2.Urun7;
import com.example.novacibus.ui.urunler2.Urun8;
import com.example.novacibus.ui.hakkinda.HakkindaFragment;
import com.example.novacibus.ui.urunler2.Urun9;
import com.example.novacibus.ui.yk.YkFragment;

public class UrunlerFragment extends Fragment {

    private com.example.novacibus.ui.urunler.UrunlerViewModel UrunlerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UrunlerViewModel =
                new ViewModelProvider(this).get(com.example.novacibus.ui.urunler.UrunlerViewModel.class);
        View v = inflater.inflate(R.layout.fragment_urunler, container, false);

        Button button1 = v.findViewById(R.id.biberiye);
        Button button2 = v.findViewById(R.id.elma);
        Button button3 = v.findViewById(R.id.kuskonmaz);
        Button button4 = v.findViewById(R.id.lahana);
        Button button5 = v.findViewById(R.id.bogurtlen);
        Button button6 = v.findViewById(R.id.recel);
        Button button7 = v.findViewById(R.id.havuc);
        Button button8 = v.findViewById(R.id.gunkurusu);
        Button button9 = v.findViewById(R.id.domates);
        Button button10 = v.findViewById(R.id.noni);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(getActivity().getApplication(), Urun1.class);
             startActivityForResult(intent, 1);}
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Urun2.class);
                startActivityForResult(intent, 2);}
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Urun3.class);
                startActivityForResult(intent, 3);}
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Urun4.class);
                startActivityForResult(intent, 4);}
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Urun5.class);
                startActivityForResult(intent, 5);}
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Urun6.class);
                startActivityForResult(intent, 6);}
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Urun7.class);
                startActivityForResult(intent, 7);}
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Urun8.class);
                startActivityForResult(intent, 8);}
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Urun9.class);
                startActivityForResult(intent, 9);}
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Urun10.class);
                startActivityForResult(intent, 10);}
        });

        return v;
    }

    public void urun1(View view){

        /*Urun1Fragment urun1Fragment = new Urun1Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //transaction.add(R.id.nav_host_fragment,urun1Fragment, "urun1");
        transaction.commit();*/
    }

    public void urun2(View view){

        HakkindaFragment hakkindaFragment = new HakkindaFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.nav_host_fragment,hakkindaFragment, "hakkinda");
        transaction.commit();
    }

    public void urun3(View view){

        YkFragment ykFragment = new YkFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.nav_host_fragment,ykFragment, "yk");
        transaction.commit();
    }

    public void urun4(View view){

        YkFragment ykFragment = new YkFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.nav_host_fragment,ykFragment, "yk");
        transaction.commit();
    }

    public void urun5(View view){

        YkFragment ykFragment = new YkFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.nav_host_fragment,ykFragment, "yk");
        transaction.commit();
    }

    public void urun6(View view){

        YkFragment ykFragment = new YkFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.nav_host_fragment,ykFragment, "yk");
        transaction.commit();
    }

    public void urun7(View view){

        YkFragment ykFragment = new YkFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.nav_host_fragment,ykFragment, "yk");
        transaction.commit();
    }

    public void urun8(View view){

        YkFragment ykFragment = new YkFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.nav_host_fragment,ykFragment, "yk");
        transaction.commit();
    }
}
