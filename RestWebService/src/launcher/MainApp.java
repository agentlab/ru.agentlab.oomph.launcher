/**
 *
 */
package launcher;

import java.util.concurrent.CountDownLatch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp
    extends Application {
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static MainApp instance;
    private Button btn;
    private String buttonName = "";

    public static void main(String[] args) {
        launch(args);
    }

    public static MainApp waitForMainApp() {
        try
        {
            latch.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return instance;
    }

    public static void setMainApp(MainApp mainApp) {
        instance = mainApp;
        latch.countDown();
    }

    public MainApp() {
        setMainApp(this);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event) {
                System.out.println(buttonName);
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

}