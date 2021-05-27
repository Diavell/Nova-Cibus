package com.example.novacibus.ui.iletisim;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.novacibus.R;

public class IletisimFragment extends Fragment {

    EditText ad;
    EditText soyad;
    EditText tel;
    EditText messagee;
    String mail="novacibus@hotmail.com";

    private com.example.novacibus.ui.iletisim.IletisimViewModel IletisimViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        IletisimViewModel =
                new ViewModelProvider(this).get(com.example.novacibus.ui.iletisim.IletisimViewModel.class);
        View root = inflater.inflate(R.layout.activity_iletisim, container, false);

        ad = root.findViewById(R.id.ad);
        soyad = root.findViewById(R.id.soyad);
        tel = root.findViewById(R.id.tel);
        messagee = root.findViewById(R.id.textmes);

        Button button = root.findViewById(R.id.gonder);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ad.getText().toString().equals("")||soyad.getText().toString().equals("")||tel.getText().toString().equals("")||messagee.getText().toString().equals(""))
                {
                    Toast.makeText(getActivity().getApplication(), "Lütfen tüm bilgileri eksiksiz giriniz", Toast.LENGTH_SHORT).show();
                }
                else {
                    email(root);
                }
            }
        });

        return root;
    }
    public void email(View view){

        String to=mail;
        String subject=ad.getText().toString() + " " + soyad.getText().toString() + " " + tel.getText().toString();
        String message= messagee.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));

        //startActivity(email);//Direkt gmail ile göndermesi için
    }
}
