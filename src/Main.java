
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Objects;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        newWindow();
    }

    public void newWindow(){
        Stage primaryStage = new Stage();

        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu helpMenu = new Menu("Help");

        Label string1 = new Label("String 1");
        Label string2 = new Label("String 2");
        TextField textField1 = new TextField();
        textField1.setPrefWidth(200);
        TextField textField2 = new TextField();
        textField2.setPrefWidth(200);

        Button bottomBtn = new Button("Check");

        VBox centerBox = new VBox();
        HBox firstStringLine = new HBox();
        HBox secondStringLine = new HBox();
        firstStringLine.getChildren().addAll(string1, textField1);
        firstStringLine.setSpacing(10);
        secondStringLine.getChildren().addAll(string2, textField2);
        secondStringLine.setSpacing(10);
        centerBox.getChildren().addAll(firstStringLine, secondStringLine);



        MenuItem newTab = new MenuItem("New Tab");

        MenuItem quit = new MenuItem("Quit");
        MenuItem about = new MenuItem("About");

        fileMenu.getItems().add(newTab);
        fileMenu.getItems().add(quit);
        helpMenu.getItems().add(about);

        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(helpMenu);

        VBox vBox = new VBox(menuBar);
        vBox.fillWidthProperty();
        BorderPane pane = new BorderPane();

        centerBox.setSpacing(20);


        pane.setTop(vBox);
        pane.setCenter(centerBox);
        pane.setBottom(bottomBtn);

        final String[] s1 = new String[1];
        final String[] s2 = new String[1];



        BorderPane.setAlignment(centerBox, Pos.CENTER);
        BorderPane.setMargin(centerBox, new Insets(50, 0, 0, 50));
        BorderPane.setAlignment(bottomBtn, Pos.BOTTOM_RIGHT);
        BorderPane.setMargin(bottomBtn, new Insets(0, 10, 10, 10));

        EventHandler<ActionEvent> event = e -> {
            String a = ((MenuItem)e.getSource()).getText();
            if(Objects.equals(a, "New Tab")){
                newWindow();
            }
        };

        EventHandler<ActionEvent> eventQuit = e -> {
            String a = ((MenuItem)e.getSource()).getText();
            if(Objects.equals(a, "Quit")){
                quit(primaryStage);
            }
        };

        EventHandler<ActionEvent> eventAbout = e -> {
            String a = ((MenuItem)e.getSource()).getText();
            if(Objects.equals(a, "About")){
                aboutWindow();
            }
        };


        bottomBtn.setOnAction(actionEvent -> {
            s1[0] = String.valueOf(textField1.getText());
            s2[0] = String.valueOf(textField2.getText());
            System.out.println(s1[0] + " " + s2[0]);
            if(equalsString(s1[0], s2[0])){
                if(!Objects.equals(s1[0], "")){
                    System.out.println("true");
                    textField2.setStyle("-fx-background-color:green;");
                }
            }else{
                textField2.setStyle("-fx-background-color:red;");
                System.out.println("false");
            }
        });

        newTab.setOnAction(event);
        quit.setOnAction(eventQuit);
        about.setOnAction(eventAbout);

        primaryStage.setMinWidth(400);
        primaryStage.setMaxWidth(400);
        primaryStage.setMaxHeight(350);
        primaryStage.setMinHeight(350);

        primaryStage.setTitle("Simple String checker");
        primaryStage.setScene(new Scene(pane, 400, 350));
        primaryStage.show();



    }

    public void aboutWindow(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Simple String Checker");
        a.setContentText("Author: Lyreplus\n2022-2022");


        a.setTitle("About Simple String Checker");
        a.show();

    }

    public boolean equalsString(String s1, String s2){
        return s1.equals(s2);
    }

    public void quit(Stage stage){
        stage.close();
    }



}
