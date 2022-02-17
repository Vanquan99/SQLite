package com.vanquan.sqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.vanquan.sqlite.DTO.NhanVienDTO;
import com.vanquan.sqlite.R;

import java.util.List;

public class CustomNhanVienAdapter extends ArrayAdapter<NhanVienDTO> {
    Context context;
    int resource;
    List<NhanVienDTO> objects;


    public CustomNhanVienAdapter(@NonNull Context context, int resource, @NonNull List<NhanVienDTO> objects) {
        super(context, resource, objects);

        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(resource,parent,false);


        TextView textView=view.findViewById(R.id.tvNhanVien);
        textView.setText(objects.get(position).getTenNV().toString());
        return view;

    }
}
