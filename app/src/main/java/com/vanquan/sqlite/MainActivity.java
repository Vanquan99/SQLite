package com.vanquan.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.vanquan.sqlite.Adapter.CustomNhanVienAdapter;
import com.vanquan.sqlite.DAO.NhanVienDAO;
import com.vanquan.sqlite.DTO.NhanVienDTO;
import com.vanquan.sqlite.SQLiteHelper.TaoDatabaseNV;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnThemNV;
    EditText edTenNV;
    NhanVienDAO nhanVienDAO;

    ListView listNV;
    List<NhanVienDTO> dsNhanVien;
    CustomNhanVienAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThemNV=findViewById(R.id.btnThem);
        edTenNV=findViewById(R.id.edName);
        listNV=findViewById(R.id.listDanhSach);

        dsNhanVien=new ArrayList<NhanVienDTO>();

        adapter=new CustomNhanVienAdapter(this,R.layout.layout_customnhanvien,dsNhanVien);
        listNV.setAdapter(adapter);

        nhanVienDAO=new NhanVienDAO(this);
        nhanVienDAO.open();

        btnThemNV.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnThem:
                String tennhanvien=edTenNV.getText().toString();

                NhanVienDTO nhanVienDTO=new NhanVienDTO();
                nhanVienDTO.setTenNV(tennhanvien);

                dsNhanVien.add(nhanVienDTO);

                boolean kiemtra = nhanVienDAO.ThemNhanVien(nhanVienDTO);
                if (kiemtra){
                    Toast.makeText(this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                }

                break;

        }

    }
}