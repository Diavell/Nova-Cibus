package com.example.novacibus.ui.okul;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.novacibus.OkulInfo;
import com.example.novacibus.R;
import com.example.novacibus.Sepet;
import com.example.novacibus.ui.home.HomeViewModel;
import com.example.novacibus.ui.urunler2.Urun1;
import com.example.novacibus.ui.urunler2.Urun2;

public class OkulFragment extends Fragment {

    ImageButton info;
    Button gonder;
    EditText okuladi, okuladres, irtibatadsoyad, irtibatmail, irtibattel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_okul, container, false);

        gonder = root.findViewById(R.id.istekgonder);
        info = root.findViewById(R.id.okulinfo);
        okuladi = root.findViewById(R.id.okuladi);
        okuladres = root.findViewById(R.id.okuladres);
        irtibatadsoyad = root.findViewById(R.id.irtibatadsoyad);
        irtibatmail = root.findViewById(R.id.irtibatmail);
        irtibattel = root.findViewById(R.id.irtibattel);

        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (okuladi.getText().toString().equals("")||okuladres.getText().toString().equals("")||irtibatadsoyad.getText().toString().equals("")||irtibatmail.getText().toString().equals("")||irtibattel.getText().toString().equals(""))
                {
                    Toast.makeText(getActivity().getApplication(), "Lütfen tüm bilgileri eksiksiz giriniz", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity().getApplication(), "İsteğiniz bize ulaştı. En kısa sürede sizinle iletişime geçeceğiz.", Toast.LENGTH_LONG).show();
                }
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), OkulInfo.class);
                startActivityForResult(intent, 1);
            }
        });


        return root;
    }
}