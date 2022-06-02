package sg.edu.rp.c346.id20028056.simpletodo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class display extends AppCompatActivity {

    ArrayAdapter<String> aaList;
    Button btnClear,btnBack,btnDelete;
    ListView lvList;
    ArrayList<String> todoList=MainActivity.todoList;
    int defaultInt=-1;
    int taskSelected=defaultInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        btnBack=findViewById(R.id.btnBack);
        btnClear=findViewById(R.id.btnClear);
        btnDelete=findViewById(R.id.btnRemove);
        lvList=findViewById(R.id.lvToDo);


        Intent intent=getIntent();
        String task=intent.getStringExtra("task");
        todoList.add(task);
        Log.w("main",task+"");
        aaList=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,todoList );
        lvList.setAdapter(aaList);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todoList.clear();
                lvList.setAdapter(null);
            }
        });
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                taskSelected=i;
                Log.w("main",i+"");

            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w("main",taskSelected+"");
                if(taskSelected==-1)
                {
                    Toast.makeText(display.this,"Please choose one task to delete",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    todoList.remove(taskSelected);
                    aaList.notifyDataSetChanged();
                    taskSelected=defaultInt;
                }
            }
        });
    }


}