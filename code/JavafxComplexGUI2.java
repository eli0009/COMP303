package code;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavafxComplexGUI2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        Button button = new Button("Swap Text");
        root.add(button, 0, 0);

        TextField text1 = new TextField();
        TextField text2 = new TextField();
        root.add(text1, 0, 1);
        root.add(text2, 0, 2);

        // clicking button
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String temp = text1.getText();
                text1.setText(text2.getText());
                text2.setText(temp);
            }
        });

        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }
}
