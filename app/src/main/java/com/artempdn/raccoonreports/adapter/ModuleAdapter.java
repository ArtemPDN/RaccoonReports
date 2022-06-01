package com.artempdn.raccoonreports.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.artempdn.raccoonreports.R;
import com.artempdn.raccoonreports.module.Module;

import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ModuleViewHolder> {

    Context context;
    List<Module> moduleViewHolderList;

    public ModuleAdapter(Context context, List<Module> moduleViewHolderList) {
        this.context = context;
        this.moduleViewHolderList = moduleViewHolderList;
    }

    @NonNull
    @Override
    public ModuleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View moduleItems = LayoutInflater.from(context).inflate(R.layout.module_item,parent,false);
        return new ModuleAdapter.ModuleViewHolder(moduleItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleViewHolder holder, int position) {
        int color = Color.parseColor(moduleViewHolderList.get(position).getColorBG());
        holder.linearLayout.setBackgroundColor(color);
        holder.textViewDepartment.setText(moduleViewHolderList.get(position).getStrDepartment());
        holder.textViewTitle.setText(moduleViewHolderList.get(position).getStrTitle());
        int imageId = context.getResources().getIdentifier("ic_" + moduleViewHolderList.get(position).getStrNameImage(),"drawable",context.getPackageName());
        holder.imageIcon.setImageResource(imageId);
    }

    @Override
    public int getItemCount() {
        return moduleViewHolderList.size();
    }

    public static final class ModuleViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView textViewTitle,textViewDepartment;
        ImageView imageIcon;
        public ModuleViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.LinearLayout);
            imageIcon = itemView.findViewById(R.id.imageIcon);
            textViewTitle = itemView.findViewById(R.id.textTitle);
            textViewDepartment = itemView.findViewById(R.id.textDepartment);

        }
    }
}
