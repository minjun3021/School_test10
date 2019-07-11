package com.example.test10;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Data> data;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Request();
        data = new ArrayList<>();
        listView = findViewById(R.id.listview);
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "select * from tb_calllog";
        Cursor cursor = db.rawQuery(sql, null);
        String asdf = "";

        while (cursor.moveToNext()) {
            data.add(new Data(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));

        }
        MyAdapter myAdapter = new MyAdapter(this, data, R.layout.list_item);
        listView.setAdapter(myAdapter);

    }

    void Request() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 200);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 허용 되었습니다.", Toast.LENGTH_SHORT).show();
        } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
            Request();
        }
    }
}
