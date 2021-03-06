package com.example.viviwi.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ResepAdapter.ResepListener{

    RecyclerView r1;
    ResepAdapter ad;
    public static final String POSITION = "position";

    int imageResource[] = {R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,R.drawable.photo4,R.drawable.photo5,R.drawable.photo6,R.drawable.photo7,R.drawable.photo8};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = (RecyclerView)findViewById(R.id.myRecycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        r1.setLayoutManager(layoutManager);
        r1.setHasFixedSize(true);
        String judul[] = getResources().getStringArray(R.array.judul_resep);
        Log.v("Main",judul[0]);
        String ket[] = getResources().getStringArray(R.array.keterangan_resep);
        ad = new ResepAdapter(this, judul, ket, imageResource, this);
        r1.setAdapter(ad);
        r1.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this,DetailResep.class);
        intent.putExtra(Intent.EXTRA_TEXT,ad.getJudul(position));
        intent.putExtra(POSITION,position);
        startActivity(intent);
    }
}
