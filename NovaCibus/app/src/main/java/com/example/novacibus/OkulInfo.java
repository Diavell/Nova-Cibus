package com.example.novacibus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import com.example.novacibus.ui.urunler2.Urun1;

public class OkulInfo extends AppCompatActivity {

    ImageButton geri,resimileri,resimgeri;
    ImageSwitcher resim;

    int imageList[] = {R.drawable.okulinfo1 , R.drawable.okulinfo2 , R.drawable.okulinfo3 , R.drawable.okulinfo4};

    int count = imageList.length;
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okul_info);

        geri = findViewById(R.id.infogeri);
        resim = findViewById(R.id.infoimage);
        resimgeri = findViewById(R.id.imageback);
        resimileri = findViewById(R.id.imagefurther);

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        resim.setFactory(new ViewSwitcher.ViewFactory() {
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
        resim.setImageResource(imageList[0]);

        resimileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resim.setInAnimation(OkulInfo.this,
                        R.anim.from_right);
                resim.setOutAnimation(OkulInfo.this,
                        R.anim.to_left);
                --currentIndex;
                if (currentIndex < 0)
                    currentIndex = imageList.length-1;
                resim.setImageResource(imageList[currentIndex]);
            }
        });

        resimgeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resim.setInAnimation(OkulInfo.this,
                        R.anim.from_left);
                resim.setOutAnimation(OkulInfo.this,
                        R.anim.to_right);
                currentIndex++;
                if (currentIndex == count)
                    currentIndex = 0;
                resim.setImageResource(imageList[currentIndex]);
            }
        });



    }
}