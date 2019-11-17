package com.example.akikonne.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;


public class MyAdapter extends ArrayAdapter {
    LayoutInflater layoutInflater;
    int resourceToDo;
    ArrayList<ToDo> toDoList;
    ArrayList<Boolean> checked;

    public MyAdapter(Context context, int resource, ArrayList<ToDo> toDoArrayList){
        super(context, resource, toDoArrayList);
        this.resourceToDo = resource;
        this.toDoList = toDoArrayList;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.checked = new ArrayList<>();
    }

    public void setToDoList(ArrayList<ToDo> toDoList){
        this.toDoList = toDoList;
    }
    public void setChecked(boolean checked){
        this.checked.add(new Boolean(checked));
    }
    private void removeAddedToDo(int position) {
        toDoList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount(){
        if(toDoList != null){
            return toDoList.size();
        }
        else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position){
        return toDoList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){

        View returnedView;

        if(convertView != null) {
            returnedView = convertView;
        }
        else{
            returnedView = layoutInflater.inflate(resourceToDo, null);
        }

        CheckBox chkBox = returnedView.findViewById(R.id.idCheckBox);
        ((TextView)returnedView.findViewById(R.id.idToDo)).setText(toDoList.get(position).getToDo());
        Button removeToDo = returnedView.findViewById(R.id.idRemoveToDo);

        chkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checked.set(position, isChecked);
            }
        });

        if(checked.get(position) != null) {
            chkBox.setChecked(checked.get(position));
        }

        removeToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeAddedToDo(position);
                checked.remove(position);
            }
        });

        return returnedView;
    }
}
