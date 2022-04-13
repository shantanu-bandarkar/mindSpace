package com.example.mindspace.Contacts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindspace.DB_handler;
import com.example.mindspace.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<DemoVH> {
    public Context context;
    public RecyclerViewAdapter adapter;
    public ArrayList<Registration> regList;

    public RecyclerViewAdapter(Context context, ArrayList<Registration> regList) {
        this.context = context;
        this.regList = regList;
    }

    // set layout
    @NonNull
    @Override
    public DemoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new DemoVH(view).linkAdapter(this);
    }

    // set text
    @Override
    public void onBindViewHolder(@NonNull DemoVH holder, int position) {
        Registration registration = regList.get(position);
        holder.reg_Id.setText(Integer.toString(registration.getId()));
        holder.reg_name.setText(registration.getName());
        holder.reg_mob.setText(registration.getMob());
    }

    // set size
    @Override
    public int getItemCount() {
        return regList.size();
    }

}


    //attach with layout elements

class DemoVH extends RecyclerView.ViewHolder{
        private RecyclerViewAdapter adapter;
        Intent i = null;
        public TextView reg_Id;
        public TextView reg_name;
        public TextView reg_mob;
        public Button btn_Delete;

        public DemoVH(@NonNull View itemView) {
            super(itemView);
            reg_Id = itemView.findViewById(R.id.regId);
            reg_name = itemView.findViewById(R.id.name);
            reg_mob = itemView.findViewById(R.id.mob);
            btn_Delete = itemView.findViewById((R.id.btn_Delete));


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text= reg_mob.getText().toString();
                    i = new Intent();
                    i.setAction(Intent.ACTION_DIAL);
                    i.setData(Uri.parse(("tel:"+text)));
                    view.getContext().startActivity(i);
                }
            });

            btn_Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = Integer.parseInt(String.valueOf(reg_Id.getText()));
                    DB_handler dbh = new DB_handler(view.getContext());
                    Boolean result = dbh.deleteRecord(id);
                    if( result == true) {

                        Toast.makeText(view.getContext(), "The Record Was Deleted Successfully!!!", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(view.getContext(), "No Such Record Exists!!!", Toast.LENGTH_SHORT).show();

                    adapter.regList.remove(getAdapterPosition());
                    adapter.notifyItemRemoved(getAdapterPosition());
                }
            });
        }

        public DemoVH linkAdapter(RecyclerViewAdapter adapter){
            this.adapter = adapter;
            return this;
        }
}
