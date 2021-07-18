package com.example.recyclerviewkullanimi;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<MyModel> myModelList;
    private MyClickListener myClickListener;
    Context myContext;
    int levelsayisi;
    Handler handler = new Handler();

    public MyAdapter(Context context, List<MyModel> myModelList,int levelsayisi, MyClickListener myClickListener) {
        this.myModelList = myModelList;
        this.myContext = context;
        this.myClickListener = myClickListener;
        this.levelsayisi = levelsayisi;

    }

    public interface MyClickListener {
        void onclick(MyModel myModel);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(myContext).inflate(R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Mümkün olduğu kadar kodu azalt, ağır işlemler yapılmaz.
        MyModel currentModel = myModelList.get(position);
        holder.bind(currentModel, levelsayisi);

        holder.itemView.setOnClickListener((v) -> { // Tıklama Animasyonu
            float reducedvalue = (float) 0.85;
            v.setScaleX(reducedvalue);
            v.setScaleY(reducedvalue);

            handler.postDelayed(() -> {
                v.setScaleX(1);
                v.setScaleY(1);
            }, 80);

            myClickListener.onclick(myModelList.get(position));// Interface Click Listener en iyi performansı veriyor.
        });
    }

    @Override
    public int getItemCount() {
        return myModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView resim_1, imgtime, imgtouch, kilitimg, yildiz1, yildiz2, yildiz3;
        TextView leveltext, zamansiniritext, hamlesiniritext;
        int kacyildiz;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            resim_1 = itemView.findViewById(R.id.resim_1);
            leveltext = itemView.findViewById(R.id.leveltext);
            zamansiniritext = itemView.findViewById(R.id.zamansiniritext);
            hamlesiniritext = itemView.findViewById(R.id.hamlesiniritext);
            imgtime = itemView.findViewById(R.id.imgtime);
            imgtouch = itemView.findViewById(R.id.imgtouch);
            kilitimg = itemView.findViewById(R.id.kilitimg);
            yildiz1 = itemView.findViewById(R.id.yildiz1);
            yildiz2 = itemView.findViewById(R.id.yildiz2);
            yildiz3 = itemView.findViewById(R.id.yildiz3);
        }

        public void bind(MyModel currentModel, int levelsayisi) {

            this.leveltext.setText(currentModel.leveltext);


            this.resim_1.setImageResource(currentModel.resID);
            /* Bu şekilde resimleri yüklemek kasıyor. Alternatifler;
             * 1) Resimler cacheden bitmap olarak alınabilir, lag azaltmada etkisi büyük.
             * 2) Glide ile yüklemek de fayda sağlıyor.Ozellikle internetten geliyorsa, işleri kolaylaştırıyor.
             */


            if (Integer.parseInt(currentModel.level) <= levelsayisi) {
                // Kilitli olmayan bölümler için..

                this.kacyildiz = currentModel.kacyildiz;
                if (kacyildiz == 0) {
                    yildiz1.setImageResource(R.drawable.stardark);
                    yildiz2.setImageResource(R.drawable.stardark);
                    yildiz3.setImageResource(R.drawable.stardark);
                } else if (kacyildiz == 1) {
                    yildiz1.setImageResource(R.drawable.star);
                    yildiz2.setImageResource(R.drawable.stardark);
                    yildiz3.setImageResource(R.drawable.stardark);
                } else if (kacyildiz == 2) {
                    yildiz1.setImageResource(R.drawable.star);
                    yildiz2.setImageResource(R.drawable.star);
                    yildiz3.setImageResource(R.drawable.stardark);
                } else if (kacyildiz == 3) {
                    yildiz1.setImageResource(R.drawable.star);
                    yildiz2.setImageResource(R.drawable.star);
                    yildiz3.setImageResource(R.drawable.star);
                }


                zamansiniritext.setVisibility(View.VISIBLE);
                imgtime.setVisibility(View.VISIBLE);
                hamlesiniritext.setVisibility(View.VISIBLE);
                imgtouch.setVisibility(View.VISIBLE);
                kilitimg.setVisibility(View.INVISIBLE);

            } else {
                // Kilitli bölümler için

                yildiz1.setImageResource(R.drawable.stardark);
                yildiz2.setImageResource(R.drawable.stardark);
                yildiz3.setImageResource(R.drawable.stardark);

                zamansiniritext.setVisibility(View.INVISIBLE);
                imgtime.setVisibility(View.INVISIBLE);
                hamlesiniritext.setVisibility(View.INVISIBLE);
                imgtouch.setVisibility(View.INVISIBLE);
                kilitimg.setVisibility(View.VISIBLE);

            }

            // Bölüm özellikleri hakkındaki yazı ve icon görünüm ayarları
            if (currentModel.zamansiniritext.equals("0")) {
                zamansiniritext.setVisibility(View.INVISIBLE);
                imgtime.setVisibility(View.INVISIBLE);
            } else {
                this.zamansiniritext.setText(currentModel.zamansiniritext);
                zamansiniritext.setVisibility(View.VISIBLE);
                imgtime.setVisibility(View.VISIBLE);
            }

            if (currentModel.hamlesiniritext.equals("0")) {
                hamlesiniritext.setVisibility(View.INVISIBLE);
                imgtouch.setVisibility(View.INVISIBLE);
            } else {
                this.hamlesiniritext.setText(currentModel.hamlesiniritext);
                hamlesiniritext.setVisibility(View.VISIBLE);
                imgtouch.setVisibility(View.VISIBLE);
            }


        }
    }


}
