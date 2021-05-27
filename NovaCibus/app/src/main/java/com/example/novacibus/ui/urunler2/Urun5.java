package com.example.novacibus.ui.urunler2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

import com.example.novacibus.R;
import com.example.novacibus.Veritabani;
import com.example.novacibus.ui.urunler.UrunlerFragment;

public class Urun5 extends AppCompatActivity {
    ImageSwitcher imageSwitcher;
    ImageButton btPrevious,btNext;
    ImageButton buttonback;
    Button sepet;

    int imageList[] = {R.drawable.bogurtlen2 , R.drawable.bogurtlen3 , R.drawable.bogurtlen4 , R.drawable.bogurtlen};

    int count = imageList.length;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun5);

        btPrevious = findViewById(R.id.bt_previous);
        btNext = findViewById(R.id.bt_next);
        imageSwitcher = findViewById(R.id.urun1Image);
        buttonback = findViewById(R.id.buttonback);
        sepet = findViewById(R.id.urun5sepet);


        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        LinearLayout.LayoutParams.FILL_PARENT,
                        LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });
        imageSwitcher.setImageResource(imageList[0]);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageSwitcher.setInAnimation(Urun5.this,
                        R.anim.from_right);
                imageSwitcher.setOutAnimation(Urun5.this,
                        R.anim.to_left);
                --currentIndex;
                if (currentIndex < 0)
                    currentIndex = imageList.length-1;
                imageSwitcher.setImageResource(imageList[currentIndex]);
            }
        });

        btPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageSwitcher.setInAnimation(Urun5.this,
                        R.anim.from_left);
                imageSwitcher.setOutAnimation(Urun5.this,
                        R.anim.to_right);
                currentIndex++;
                if (currentIndex == count)
                    currentIndex = 0;
                imageSwitcher.setImageResource(imageList[currentIndex]);
            }
        });

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sepet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urunadi = "Böğürtlen";
                String urunfiyati = "20.99 TL";

                Veritabani vt = new Veritabani(Urun5.this);
                vt.VeriEkle(urunadi,urunfiyati);

                Toast.makeText(Urun5.this, "Ürün sepetinize eklendi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
