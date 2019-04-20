package sample;

import javafx.scene.paint.Color;

import java.time.LocalDate;

public class Task {
    private String name;
    private String description;
    private LocalDate date;
    private Priority priority;
    private Color color;

    Task(String name,String description,LocalDate date, Priority pr){
        this.name=name;
        this.description=description;
        this.date=date;
        this.priority=pr;
        if(pr==Priority.HIGH) this.color=Color.RED;
        if(pr==Priority.MEDIUM) this.color=Color.ORANGE;
        if(pr==Priority.LOW) this.color=Color.GREEN;
    }
    Task(){
        this.name="Empty Task";
        this.description="NULL";
        this.date=null;
        this.priority=null;
    }
    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public Color getColor(){return this.color;}
    public Priority getPriority(){return this.priority;}
    public LocalDate getDate(){return this.date;}
}


