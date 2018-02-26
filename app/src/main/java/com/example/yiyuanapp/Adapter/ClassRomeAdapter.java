package com.example.yiyuanapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yiyuanapp.BaseClass.ClassRome;
import com.example.yiyuanapp.R;

import java.util.List;

/**
 * author: DemoVei
 * Time:  2018/2/26 17:25
 * Description:
 */

public class ClassRomeAdapter extends RecyclerView.Adapter<ClassRomeAdapter.ViewHolder>{

    private List<ClassRome> classrome;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView classromename;

        public ViewHolder(View view){
            super(view);
            classromename = view.findViewById(R.id.classrome_name);
        }
    }

    public ClassRomeAdapter(List<ClassRome> classromelist){
        classrome = classromelist;
    }

    @Override
    public ClassRomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.classplace,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ClassRomeAdapter.ViewHolder holder, int position) {
        ClassRome mclassrome = classrome.get(position);
        holder.classromename.setText(mclassrome.getName());
    }

    @Override
    public int getItemCount() {
        return classrome.size();
    }
}
