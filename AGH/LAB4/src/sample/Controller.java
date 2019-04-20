package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public ListView <Task>inProgress;
    public ListView<Task> done;
    public ListView<Task> toDo;
    public Button moveRightToDo;
    public Button moveLefttInProgr;
    public Button moveRightInProgr;
    public Button moveLeftDone;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        //MENU:
        ContextMenu contextMenu1=new ContextMenu();
        MenuItem delete1 = new MenuItem("Delete task");
        MenuItem edit1=new MenuItem("Edit task");
        contextMenu1.getItems().add(delete1);
        contextMenu1.getItems().add(edit1);


        ContextMenu contextMenu2=new ContextMenu();
        MenuItem delete2 = new MenuItem("Delete task");
        MenuItem edit2=new MenuItem("Edit task");
        contextMenu2.getItems().add(delete2);
        contextMenu2.getItems().add(edit2);

        ContextMenu contextMenu3=new ContextMenu();
        MenuItem delete3 = new MenuItem("Delete task");
        MenuItem edit3=new MenuItem("Edit task");
        contextMenu3.getItems().add(delete3);
        contextMenu3.getItems().add(edit3);



        delete1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                final int selected=toDo.getSelectionModel().getSelectedIndex();
                toDo.getItems().remove(selected);
            }
        });
        edit1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Task editTask=toDo.getSelectionModel().getSelectedItem();
                    Stage stage = new Stage();
                    VBox box = new VBox();
                    box.setPadding(new Insets(10));

                    Label titleLabel = new Label("\n Name:");
                    TextField title = new TextField();
                    title.setAlignment(Pos.CENTER_RIGHT);
                    title.setText(editTask.getName());

                    Label description = new Label("Description:");
                    TextField text = new TextField();
                    text.setAlignment(Pos.CENTER_RIGHT);
                    text.setText(editTask.getDescription());

                    Label dateLabel = new Label("Exp date:");
                    DatePicker expDate = new DatePicker();
                    expDate.setValue(editTask.getDate());

                    Label priorityLabel = new Label("Priority");
                    ComboBox<Priority> priorityCombobox = new ComboBox<>();
                    priorityCombobox.getItems().add(Priority.HIGH);
                    priorityCombobox.getItems().add(Priority.MEDIUM);
                    priorityCombobox.getItems().add(Priority.LOW);
                    priorityCombobox.getSelectionModel().select(editTask.getPriority());

                    Button addButton = new Button();
                    addButton.setText("Add");
                    addButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            Task temp=new Task(title.getText(),text.getText(),expDate.getValue(),priorityCombobox.getValue());
                            toDo.getItems().remove(editTask);
                            toDo.getItems().add(temp);
                            stage.close();
                        }
                    });
                    Scene scene = new Scene(box,450,250);

                    box.getChildren().add(titleLabel);
                    box.getChildren().add(title);
                    box.getChildren().add(description);
                    box.getChildren().add(text);
                    box.getChildren().add(dateLabel);
                    box.getChildren().add(expDate);
                    box.getChildren().add(priorityLabel);
                    box.getChildren().add(priorityCombobox);
                    box.getChildren().add(addButton);
                    stage.setScene(scene);
                    stage.show();
                }
                catch(Exception e){
                    System.out.println("ERROR");
                }
            }
        });

        delete2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                final int selected=inProgress.getSelectionModel().getSelectedIndex();
                inProgress.getItems().remove(selected);
            }
        });
        edit2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Task editTask=inProgress.getSelectionModel().getSelectedItem();
                try {
                    Stage stage = new Stage();
                    VBox box = new VBox();
                    box.setPadding(new Insets(10));

                    Label titleLabel = new Label("\n Name:");
                    TextField title = new TextField();
                    title.setAlignment(Pos.CENTER_RIGHT);
                    title.setText(editTask.getName());

                    Label description = new Label("Description:");
                    TextField text = new TextField();
                    text.setAlignment(Pos.CENTER_RIGHT);
                    text.setText(editTask.getDescription());

                    Label dateLabel = new Label("Exp date:");
                    DatePicker expDate = new DatePicker();
                    expDate.setValue(editTask.getDate());

                    Label priorityLabel = new Label("Priority");
                    ComboBox<Priority> priorityCombobox = new ComboBox<>();
                    priorityCombobox.getItems().add(Priority.HIGH);
                    priorityCombobox.getItems().add(Priority.MEDIUM);
                    priorityCombobox.getItems().add(Priority.LOW);
                    priorityCombobox.getSelectionModel().select(editTask.getPriority());

                    Button addButton = new Button();
                    addButton.setText("Add");
                    addButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            Task temp=new Task(title.getText(),text.getText(),expDate.getValue(),priorityCombobox.getValue());
                            inProgress.getItems().remove(editTask);
                            inProgress.getItems().add(temp);
                            stage.close();
                        }
                    });
                    Scene scene = new Scene(box,450,250);

                    box.getChildren().add(titleLabel);
                    box.getChildren().add(title);
                    box.getChildren().add(description);
                    box.getChildren().add(text);
                    box.getChildren().add(dateLabel);
                    box.getChildren().add(expDate);
                    box.getChildren().add(priorityLabel);
                    box.getChildren().add(priorityCombobox);
                    box.getChildren().add(addButton);
                    stage.setScene(scene);
                    stage.show();

                }
                catch(Exception e){
                    System.out.println("ERROR");
                }
            }

        });
        delete3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                final int selected=done.getSelectionModel().getSelectedIndex();
                done.getItems().remove(selected);
            }
        });
        edit3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Task editTask=done.getSelectionModel().getSelectedItem();
                try {
                    Stage stage = new Stage();
                    VBox box = new VBox();
                    box.setPadding(new Insets(10));

                    Label titleLabel = new Label("\n Name:");
                    TextField title = new TextField();
                    title.setAlignment(Pos.CENTER_RIGHT);
                    title.setText(editTask.getName());

                    Label description = new Label("Description:");
                    TextField text = new TextField();
                    text.setAlignment(Pos.CENTER_RIGHT);
                    text.setText(editTask.getDescription());

                    Label dateLabel = new Label("Exp date:");
                    DatePicker expDate = new DatePicker();
                    expDate.setValue(editTask.getDate());

                    Label priorityLabel = new Label("Priority");
                    ComboBox<Priority> priorityCombobox = new ComboBox<>();
                    priorityCombobox.getItems().add(Priority.HIGH);
                    priorityCombobox.getItems().add(Priority.MEDIUM);
                    priorityCombobox.getItems().add(Priority.LOW);
                    priorityCombobox.getSelectionModel().select(editTask.getPriority());

                    Button addButton = new Button();
                    addButton.setText("Add");
                    addButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            Task temp=new Task(title.getText(),text.getText(),expDate.getValue(),priorityCombobox.getValue());
                            done.getItems().remove(editTask);
                            done.getItems().add(temp);
                            stage.close();
                        }
                    });
                    Scene scene = new Scene(box,450,250);

                    box.getChildren().add(titleLabel);
                    box.getChildren().add(title);
                    box.getChildren().add(description);
                    box.getChildren().add(text);
                    box.getChildren().add(dateLabel);
                    box.getChildren().add(expDate);
                    box.getChildren().add(priorityLabel);
                    box.getChildren().add(priorityCombobox);
                    box.getChildren().add(addButton);
                    stage.setScene(scene);
                    stage.show();

                }
                catch(Exception e){
                    System.out.println("ERROR");
                }
            }
        });

        toDo.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu1.show(toDo,event.getScreenX(),event.getScreenY());
            }
        });

        inProgress.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu2.show(inProgress,event.getScreenX(),event.getScreenY());
            }
        });
        done.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu3.show(done,event.getScreenX(),event.getScreenY());
            }
        });

        moveRightToDo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Task potential = toDo.getSelectionModel().getSelectedItem();
                if (potential != null) {
                    toDo.getSelectionModel().clearSelection();
                    toDo.getItems().remove(potential);
                    inProgress.getItems().add(potential);
                    setColor(inProgress);
                }

            }
        });
        moveLeftDone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Task potential = done.getSelectionModel().getSelectedItem();
                if (potential != null) {
                    done.getSelectionModel().clearSelection();
                    done.getItems().remove(potential);
                    inProgress.getItems().add(potential);
                    setColor(inProgress);
                }

            }
        });

        moveLefttInProgr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Task potential = inProgress.getSelectionModel().getSelectedItem();
                if (potential != null) {
                    inProgress.getSelectionModel().clearSelection();
                    inProgress.getItems().remove(potential);
                    toDo.getItems().add(potential);
                    setColor(toDo);
                }

            }
        });
        moveRightInProgr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Task potential = inProgress.getSelectionModel().getSelectedItem();
                if (potential != null) {
                    inProgress.getSelectionModel().clearSelection();
                    inProgress.getItems().remove(potential);
                    done.getItems().add(potential);
                    setColor(done);
                }

            }
        });

    }


    //EXIT:
    public void close(ActionEvent actionEvent) {
        System.exit(0);
    }

    //ABOUT:
    public void about(ActionEvent actionEvent) {
        Stage aboutWindow=new Stage();
        aboutWindow.initModality(Modality.APPLICATION_MODAL);
        aboutWindow.setTitle("About");
        aboutWindow.setMinHeight(200);
        aboutWindow.setMinWidth(200);
        Label infoLabel=new Label();
        infoLabel.setText("Created by Karolina Widz");
        Button closeButton=new Button("Close");
        closeButton.setOnAction(e->aboutWindow.close());

        VBox layout=new VBox(10);
        layout.getChildren().addAll(infoLabel,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene =new Scene(layout);
        aboutWindow.setScene(scene);
        aboutWindow.showAndWait();
    }

    //ADD NEW TASK BUTTON:
    public void addNewTaskWindow(ActionEvent actionEvent)  {
        try {

            Stage stage = new Stage();
            stage.setTitle("EDIT TASK");
            VBox box = new VBox();
            box.setPadding(new Insets(10));

            Label titleLabel = new Label("\n Name:");
            TextField title = new TextField();
            title.setAlignment(Pos.CENTER_RIGHT);

            Label description = new Label("Description:");
            TextField text = new TextField();
            text.setAlignment(Pos.CENTER_RIGHT);

            Label dateLabel = new Label("Exp date:");
            DatePicker expDate = new DatePicker();

            Label priorityLabel = new Label("Priority");
            ComboBox<Priority> priorityCombobox = new ComboBox<>();
            priorityCombobox.getItems().add(Priority.HIGH);
            priorityCombobox.getItems().add(Priority.MEDIUM);
            priorityCombobox.getItems().add(Priority.LOW);

            Button addButton = new Button();
            addButton.setText("Add");
            addButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(title.getText().length()==0){
                        Task temp=new Task();
                        toDo.getItems().add(temp);
                    }
                    else{
                        Task temp=new Task(title.getText(),text.getText(),expDate.getValue(),priorityCombobox.getValue());
                        toDo.getItems().add(temp);
                    }
                    stage.close();
                }
            });

            Scene scene = new Scene(box,450,250);

            box.getChildren().add(titleLabel);
            box.getChildren().add(title);
            box.getChildren().add(description);
            box.getChildren().add(text);
            box.getChildren().add(dateLabel);
            box.getChildren().add(expDate);
            box.getChildren().add(priorityLabel);
            box.getChildren().add(priorityCombobox);
            box.getChildren().add(addButton);
            stage.setScene(scene);
            stage.show();
            setColor(toDo);
        }
        catch (Exception e){
            System.out.println("ERROR");
        }
    }

    public void setColor(ListView<Task> list){
        list.setCellFactory(p -> new ListCell<>() {

            Tooltip tooltip = new Tooltip();

            protected void updateItem(Task t, boolean b) {
                super.updateItem(t, b);
                if (b || t == null) {
                    setText(null);
                    setTooltip(null);
                } else {
                    setText(t.getName());
                    Color color = t.getColor();
                    setTextFill(color);
                    tooltip.setText(t.getDescription());
                    setTooltip(tooltip);
                }
            }
        });
    }

}
