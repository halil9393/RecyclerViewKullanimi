package com.example.recyclerviewkullanimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // CONSTANTS
    int[] resIdList = {R.drawable.r01, R.drawable.r02, R.drawable.r03, R.drawable.r04, R.drawable.r05, R.drawable.r06, R.drawable.r06e,
            R.drawable.r07, R.drawable.r08, R.drawable.r09, R.drawable.r10, R.drawable.r11, R.drawable.r12, R.drawable.r12e,
            R.drawable.r13, R.drawable.r14, R.drawable.r15, R.drawable.r16, R.drawable.r17, R.drawable.r18, R.drawable.r18e,
            R.drawable.r19, R.drawable.r20, R.drawable.r21, R.drawable.r22, R.drawable.r23, R.drawable.r24, R.drawable.r24e,
            R.drawable.r25, R.drawable.r26, R.drawable.r27, R.drawable.r28, R.drawable.r29, R.drawable.r30, R.drawable.r30e,
            R.drawable.r31, R.drawable.r32, R.drawable.r33, R.drawable.r34, R.drawable.r35, R.drawable.r36, R.drawable.r36e,
            R.drawable.r37, R.drawable.r38, R.drawable.r39, R.drawable.r40, R.drawable.r41, R.drawable.r42, R.drawable.r42e,
            R.drawable.r43, R.drawable.r44, R.drawable.r45, R.drawable.r46, R.drawable.r47, R.drawable.r48, R.drawable.r48e,
            R.drawable.r49, R.drawable.r50, R.drawable.r51, R.drawable.r52, R.drawable.r53, R.drawable.r54, R.drawable.r54e,
            R.drawable.r55, R.drawable.r56, R.drawable.r57, R.drawable.r58, R.drawable.r59, R.drawable.r60, R.drawable.r60e};

    String[] textlevels = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5", "Level 6", "Level 7", "Level 8", "Level 9", "Level 10",
            "Level 11", "Level 12", "Level 13", "Level 14", "Level 15", "Level 16", "Level 17", "Level 18", "Level 19", "Level 20",
            "Level 21", "Level 22", "Level 23", "Level 24", "Level 25", "Level 26", "Level 27", "Level 28", "Level 29", "Level 30",
            "Level 31", "Level 32", "Level 33", "Level 34", "Level 35", "Level 36", "Level 37", "Level 38", "Level 39", "Level 40",
            "Level 41", "Level 42", "Level 43", "Level 44", "Level 45", "Level 46", "Level 47", "Level 48", "Level 49", "Level 50",
            "Level 51", "Level 52", "Level 53", "Level 54", "Level 55", "Level 56", "Level 57", "Level 58", "Level 59", "Level 60",
            "Level 61", "Level 62", "Level 63", "Level 64", "Level 65", "Level 66", "Level 67", "Level 68", "Level 69", "Level 70"};

    String[] textzamansinirlari = {"0", "0", "0", "0", "45", "0", "60",
            "0", "0", "0", "0", "60", "0", "75",
            "0", "0", "90", "90", "0", "90", "90",
            "0", "0", "0", "0", "125", "125", "125",
            "0", "0", "0", "0", "150", "150", "150",
            "0", "0", "0", "0", "60", "60", "90",
            "0", "0", "0", "90", "0", "90", "90",
            "0", "0", "0", "0", "120", "120", "120",
            "0", "0", "0", "120", "0", "120", "120",
            "0", "0", "0", "0", "150", "150", "150"};

    String[] texthamlesinirlari = {"0", "0", "0", "0", "0", "20", "25",
            "0", "0", "0", "30", "0", "30", "30",
            "0", "0", "0", "0", "40", "40", "36",
            "0", "0", "0", "55", "0", "55", "60",
            "0", "0", "0", "70", "0", "70", "70",
            "0", "0", "0", "20", "0", "20", "20",
            "0", "0", "0", "0", "30", "30", "30",
            "0", "0", "0", "40", "0", "40", "40",
            "0", "0", "55", "0", "0", "55", "55",
            "0", "0", "0", "70", "0", "70", "70"};

    String[] levelsid = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48",
            "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "64", "65", "66", "67", "68", "69", "70"

    };

    int[] kacyildizlist = {0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,
            0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0,1};// varsayalım



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ArrayList<MyModel> myModels = new ArrayList<>();


        int levelsayisi = 25; // varsayalım
        MyAdapter myAdapter = new MyAdapter(this, myModels, levelsayisi, myModel -> {

            if (Integer.parseInt(myModel.getLevel()) <= levelsayisi) {
                Toast.makeText(MainActivity.this,"Tıklandı:"+myModel.getLevel(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,"KİLİTLİ !", Toast.LENGTH_SHORT).show();
            }

        });

        for (int i = 0; i < resIdList.length; i++) {
            MyModel model = new MyModel(resIdList[i], textlevels[i], textzamansinirlari[i], texthamlesinirlari[i], levelsid[i], kacyildizlist[i]);
            myModels.add(model);
        }
        myAdapter.notifyDataSetChanged();

        recyclerView.setHasFixedSize(true);
//        recyclerView.setItemViewCacheSize(10); // bunlar performansa katkısı incelenerek uygulanır.Cache den bitmap alınarak performans düzeltiliyor, bunlara gerek kalmadı
//        recyclerView.setDrawingCacheEnabled(true);
//        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));



        Handler handler = new Handler();
        handler.postDelayed(() -> {
            recyclerView.smoothScrollToPosition(levelsayisi - 1);// bir mühlet geçmezse nesne yanlış oluyor
        }, 700);


        // scroll hızı sınırlandırıldı ki; zor item ler çizilirken lag olmaması için
        int maxFling = 10000;
        recyclerView.setOnFlingListener(new RecyclerView.OnFlingListener() {
            @Override
            public boolean onFling(int velocityX, int velocityY) {
                if (velocityY > maxFling) {
                    recyclerView.fling(velocityX, maxFling);
                    Log.i("tag_velocityY", "VelocityY : " + velocityY + " Max Filing : " + maxFling + " müdahale edildi");
                    return true;
                } else if (velocityY < -maxFling) {
                    recyclerView.fling(velocityX, -maxFling);
                    Log.i("tag_velocityY", "VelocityY : " + velocityY + " Max Filing : " + maxFling + " müdahale edildi");
                    return true;
                } else {
                    Log.i("tag_velocityY", "VelocityY : " + velocityY + " Max Filing : " + maxFling);
                    Log.i("tag_velocityY", "VelocityY : " + velocityY + " müdahale edilmedi");
                    return false;
                }
            }
        });




    }
}