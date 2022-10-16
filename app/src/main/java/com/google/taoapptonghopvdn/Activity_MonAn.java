package com.google.taoapptonghopvdn;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class Activity_MonAn extends AppCompatActivity {
    ListView listView;
    AdapterMonAn adapter;
    ArrayList<MonAn> arrayList;
    Boolean kt=false;
    int j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisviewmonan);

        LinearLayout backlistview = (LinearLayout) findViewById(R.id.backlistview);
        listView = findViewById(R.id.listviewmonan);
        arrayList = new ArrayList<>();
        arrayList.add(new MonAn("Bánh Mì SanWich","Đơn Gíá: 20.000 VNĐ", R.drawable.banminhsanwich));
        arrayList.add(new MonAn("Bún Đậu Mắm Tôm","Đơn Gíá: 60.000 VNĐ", R.drawable.bundaumamtom));
        arrayList.add(new MonAn("Bánh Mì Que","Đơn Gíá: 10.000 VNĐ", R.drawable.banhmique));
        arrayList.add(new MonAn("Lẩu Bò","Đơn Gíá: 110.000 VNĐ", R.drawable.laubo));
        arrayList.add(new MonAn("Phô Mai Que","Đơn Gíá: 60.000 VNĐ", R.drawable.phomaique));
        arrayList.add(new MonAn("Ram Cuốn Cải","Đơn Gíá: 50.000 VNĐ", R.drawable.ramcuonrai));
        arrayList.add(new MonAn("Bánh Kẹp","Đơn Gíá: 5.000 VNĐ", R.drawable.banhkep));

        adapter = new AdapterMonAn(Activity_MonAn.this,R.layout.activity_viewmonan,arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Activity_MonAn.this, Detail.class);
                intent.putExtra("dulieu",arrayList.get(i).getTenmon());
                if (kt!=true)
                    startActivity(intent);
                kt=false;;

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                kt=true;
                Xacnhanxoa(i);
                return false;
            }
        });
        backlistview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(Activity_MonAn.this,Activity_Home.class);
                startActivity(intent);
            }
        });
    }
    public void Xacnhanxoa(final int pos){
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(Activity_MonAn.this);
        alertDiaLog.setTitle("Thong bao");
        alertDiaLog.setIcon(R.mipmap.ic_launcher);
        alertDiaLog.setMessage("Ban co muon xoa");
        alertDiaLog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayList.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        alertDiaLog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDiaLog.show();

    }
}

