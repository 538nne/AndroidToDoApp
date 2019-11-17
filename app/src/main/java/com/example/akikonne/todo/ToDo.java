package com.example.akikonne.todo;

public class ToDo {

    private long toDoId;
    private String toDo;
    private boolean isChecked;

    public long getToDoId(){
        return toDoId;
    }
    public void setToDoId(long toDoId){
        this.toDoId = toDoId;
    }
    public String getToDo() {
        return toDo;
    }
    public void setToDo(String toDo) {
        this.toDo = toDo;
    }
    public boolean isChecked() {
        return isChecked;
    }
    public void setChecked(boolean isChecked) { this.isChecked = isChecked; }

}
