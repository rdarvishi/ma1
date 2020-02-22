package com.example.ma1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.MyViewHolder> {
    String data1[],data2[];
    int images[];
    Context context ;


    public RecyclerAdaptor (Context ct,String s_name[] ,String s_description[], int img []){
data1 = s_name ;
data2 = s_description ;
images = img ;
context = ct ;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mytext1.setText(data1[position]);
        holder.mytext2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,Second_R_Activity.class);
                i.putExtra("data1",data1[position]);
                i.putExtra("data2",data2[position]);
                i.putExtra("myimage",images[position]);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mytext1 , mytext2 ;
        ImageView myImage ;
        ConstraintLayout mainLayout ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mytext1 = itemView.findViewById(R.id.PL_TV_ID);
            mytext2 = itemView.findViewById(R.id.PL_TV_DE_ID);
            myImage = itemView.findViewById(R.id.programing_lan_IV_id);
            mainLayout = itemView.findViewById(R.id.mainRecycleLayout);
        }
    }
}
