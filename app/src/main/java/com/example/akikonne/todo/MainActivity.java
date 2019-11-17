package com.example.akikonne.todo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<ToDo> toDoList = new ArrayList<>();
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.idTodoList);
        Button addNewToDobutton = findViewById(R.id.idAddNewTodo);

        myAdapter = new MyAdapter(MainActivity.this, R.layout.rowdata,toDoList);
        myAdapter.setToDoList(toDoList);
        listView.setAdapter(myAdapter);

        addNewToDobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewToDo();
            }
        });
    }

    private void addNewToDo() {

        String newToDo = ((EditText)findViewById(R.id.idNewToDo)) .getText().toString();

        ToDo toDo = new ToDo();
        toDo.setToDo(newToDo);

        toDoList.add(toDo);
        myAdapter.setChecked(false);
        myAdapter.notifyDataSetChanged();
    }

}
