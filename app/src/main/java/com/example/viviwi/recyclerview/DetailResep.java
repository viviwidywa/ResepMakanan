package com.example.viviwi.recyclerview;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailResep extends AppCompatActivity {
    private ArrayList<Integer> mImageID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_resep);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);
        addImageID();
        bindData();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void bindData(){
        int position;
        String judul;
        String bahan [] = getResources().getStringArray(R.array.detail_resep);
        String cara [] = getResources().getStringArray(R.array.cara_resep);
        Intent intent = getIntent();
        judul = intent.getStringExtra(Intent.EXTRA_TEXT);
        position = intent.getIntExtra(MainActivity.POSITION, 0);
        TextView tv_judul = (TextView) findViewById(R.id.judul);
        TextView tv_bahan = (TextView) findViewById(R.id.bahan);
        TextView tv_keterangan = (TextView) findViewById(R.id.desk);
        ImageView image = (ImageView) findViewById(R.id.gmbr);
        tv_judul.setText(judul);
        tv_bahan.setText(bahan[position]);
        tv_keterangan.setText(cara[position]);
        image.setImageResource(mImageID.get(position));
    }
    private void addImageID(){
        mImageID = new ArrayList<>();
        mImageID.add(R.drawable.photo1);
        mImageID.add(R.drawable.photo2);
        mImageID.add(R.drawable.photo3);
        mImageID.add(R.drawable.photo4);
        mImageID.add(R.drawable.photo5);
        mImageID.add(R.drawable.photo6);
        mImageID.add(R.drawable.photo7);
        mImageID.add(R.drawable.photo8);
    }
}
