package sg.edu.rp.c346.id20028056.simpletodo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTask;
    Button btnAdd;
    public static ArrayList<String> todoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask=findViewById(R.id.etTask);
        btnAdd=findViewById(R.id.btnAdd);
        todoList=new ArrayList<>();


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task=etTask.getText().toString();
                Intent intent=new Intent(MainActivity.this,display.class);
                intent.putExtra("todoList",todoList);
                intent.putExtra("task",task);
                startActivity(intent);
                etTask.setText("");
            }
        });

    }


}