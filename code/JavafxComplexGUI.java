package code;

import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavafxComplexGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        Button button = new Button("Show Date");
        root.add(button, 0, 0);

        Text text = new Text("Click the button to show the date.");
        root.add(text, 0, 1);

        // clicking button
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setText(LocalDateTime.now().toString());
            }
        });

        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }
}
