package com.example.viviwi.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Vivi Widyawati on 9/30/2017.
 */

public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.ResepHolder> {

    private String mjudul[];
    private String mket[];
    private ResepListener mListener;
    int img[];
    Context ctx;


    public ResepAdapter(Context ct,String judul[],String ket[],int i1[],ResepListener listener){
        ctx = ct;
        mjudul=judul;
        mket=ket;
        img = i1;
        mListener=listener;

    }

    interface ResepListener{
        void onClick(int position);
    }

    @Override
    public ResepHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ctx = parent.getContext();
        View myOwnView = LayoutInflater.from(ctx).inflate(R.layout.item,parent,false);
        return new ResepHolder(myOwnView);
    }

    @Override
    public void onBindViewHolder(ResepHolder holder, int position) {
        RecyclerView.LayoutParams  params = (RecyclerView.LayoutParams) holder.mItemView.getLayoutParams();
        if(position == 0){
            params.topMargin = params.bottomMargin;
        }
        else{
            params.topMargin = 0;
        }
        String judul = mjudul[position];
        String ket = mket[position];
        holder.setResep(judul,ket);
        holder.myImage.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return mjudul.length;
    }

    public String getJudul(int position) {
        return mjudul[position];
    }

    public class ResepHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView t1;
        private TextView t2;
        ImageView myImage;
        private View mItemView;

        public ResepHolder(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.judul);
            t2 = (TextView) itemView.findViewById(R.id.desk);
            myImage = (ImageView)itemView.findViewById(R.id.myImage);
            mItemView = itemView;
            mItemView.setOnClickListener(this);

        }
        public void setResep(String judul,String ket){
            t1.setText(judul);
            t2.setText(ket);
        }
        @Override
        public void onClick(View v) {
            mListener.onClick(getAdapterPosition());
        }
    }
}
