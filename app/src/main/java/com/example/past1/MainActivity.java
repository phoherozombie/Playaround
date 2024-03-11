package com.example.past1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvCount;
    private FloatingActionButton btnAdd;
    private ListView lvCount;
    private ArrayList<Integer> arrayList;
    private ArrayAdapter<Integer> arrayAdapter;
    private MyViewModel model;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCount= findViewById(R.id.tv_count);
        btnAdd= findViewById(R.id.btn_Add);
        model=new ViewModelProvider(this).get(MyViewModel.class);
        lvCount=findViewById(R.id.lv_count);
        arrayList=new ArrayList<Integer>();
        arrayAdapter=new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1);
        lvCount.setAdapter(arrayAdapter);
        model.getNumbers().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvCount.setText(""+ integer);

            }
        });





        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                model.increaseNumber();




            }
        });
        lvCount.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

        lvCount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,DetailsActivity2.class);
                intent.putExtra("number",arrayList.get(position).toString());
                startActivity(intent);
            }
        });



    }

    public static void main(String[] args) {
        System.out.println("Hello world!!!");

    }

}