package com.example.novacibus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Sepet extends AppCompatActivity {

    ListView VeriListele;
    int idBul = 0;
    TextView sepettoplam;
    Button bosalt;
    ImageButton buttonback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepet);

        VeriListele = (ListView) findViewById(R.id.VeriListele);
        sepettoplam = findViewById(R.id.sepettoplam);
        //sil = findViewById(R.id.sil);
        bosalt = findViewById(R.id.bosalt);
        buttonback = findViewById(R.id.buttonback);

        Veritabani vt = new Veritabani(Sepet.this);
        List<String> list = vt.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Sepet.this, android.R.layout.simple_list_item_1,android.R.id.text1,list);
        VeriListele.setAdapter(adapter);

        VeriListele.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    // Tıklanan verimizi alıyoruz
                    String item = VeriListele.getItemAtPosition(position).toString();
                    // - Göre bölüyoruz
                    String[] itemBol = item.split(" - ");
                    // id'mizi alıyoruz
                    idBul = Integer.valueOf(itemBol[0].toString());
                    // Diğer verilerimizi set ediyoruz.
                    //etAd.setText(itemBol[1].toString());
                    //etSoyad.setText(itemBol[2].toString());
                }catch (Exception exception){
                }
            }
        });

        /*sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Veritabani vt = new Veritabani(Sepet.this);
                vt.VeriSil(idBul);
                Listele();

                Veritabani veritabani = new Veritabani(Sepet.this);
                Double toplam = veritabani.Hesapla();

                String toplamm = new Double(toplam).toString();

                sepettoplam.setText(toplamm+" TL");
            }
        });*/

        bosalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.isEmpty())
                {
                    Toast.makeText(Sepet.this, "Sepetinizde ürün bulunmuyor", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Sepet.this);

                    builder.setTitle("Sepeti temizle");

                    builder.setMessage("Sepetinizdeki ürünler silinecektir. Devam etmek istiyor musunuz?");

                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Veritabani veritabani = new Veritabani(Sepet.this);
                            veritabani.Reset();
                            Listele();

                            Double toplam = veritabani.Hesapla();
                            String toplamm = new Double(toplam).toString();
                            sepettoplam.setText(toplamm+" TL");
                        }
                    });
                    builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Sepet.this, "Sepet Temizlenmedi", Toast.LENGTH_SHORT).show();
                        }
                    });

                    AlertDialog dialog = builder.create();

                    dialog.show();
                }



            }
        });

        /*bosalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Veritabani veritabani = new Veritabani(Sepet.this);
                veritabani.Reset();
                Listele();

                Double toplam = veritabani.Hesapla();
                String toplamm = new Double(toplam).toString();
                sepettoplam.setText(toplamm+" TL");
            }
        });*/

        Veritabani veritabani = new Veritabani(Sepet.this);
        Double toplam = veritabani.Hesapla();

        String toplamm = new Double(toplam).toString();

        sepettoplam.setText(toplamm+" TL");

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (list.equals(""))
        {
            Toast.makeText(Sepet.this, "Sepetiz boş.  Henüz :)", Toast.LENGTH_SHORT).show();
        }
    }

    public void Listele(){
        Veritabani vt = new Veritabani(Sepet.this);
        List<String> list = vt.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Sepet.this, android.R.layout.simple_list_item_1,android.R.id.text1,list);
        VeriListele.setAdapter(adapter);
    }
}