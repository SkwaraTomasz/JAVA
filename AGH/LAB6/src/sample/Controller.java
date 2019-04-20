package sample;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Canvas canvas;
    public ProgressBar progressBar;
    public TextField points;
    public TextField result;
    public Button stopBtnAction;
    public Button runBtnAction;
    private AsyncTask task;
    private double var;

    @Override
    public void initialize (URL location, ResourceBundle resources){

    }
    private void drawShapes(GraphicsContext gc){
        gc.setFill(Color.BLUEVIOLET);
        gc.fillRect(gc.getCanvas().getLayoutX(),gc.getCanvas().getLayoutY(),gc.getCanvas().getWidth(),gc.getCanvas().getHeight());

    }
    @FXML
    public void handleRunBtnAction(ActionEvent actionEvent) {
        GraphicsContext gc= canvas.getGraphicsContext2D();
        int counter=Integer.parseInt(points.getText());
        drawShapes(gc);
        task= new AsyncTask(counter,gc);
        result.clear();
        progressBar.progressProperty().bind(task.progressProperty());
        try {
            task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent e){
                    try{
                        System.out.println("COMPLETED");
                        double var=(double) task.getValue();
                        String varString=Double.toString(var);
                        result.setText(varString);

                    }
                    catch(Exception f){
                        System.out.println("ERROR");
                    }
                }
            });

            task.setOnCancelled(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent e) {
                    try{
                        System.out.println("CANCELLED");
                        result.setText(Double.toString(var));

                    }
                    catch(Exception f){
                        System.out.println("ERROR");
                    }

                }

            });
            new Thread(task).start();
            task.setOnFailed(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent e){
                    System.out.println("UNCOMPLETED");

                }

            });

        }
        catch(Exception e){
            System.out.println("ERROR");
        }

    }
    @FXML
    public void handleStopBtnAction(ActionEvent actionEvent) {
        var=(double) task.returnResult();
        task.cancel();


    }

}
