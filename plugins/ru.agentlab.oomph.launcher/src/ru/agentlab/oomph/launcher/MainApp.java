package ru.agentlab.oomph.launcher;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

	private Stage primaryStage;
    private AnchorPane rootLayout;
    private Stage newStage;
    private AnchorPane page;
    private boolean isOpen = false;

    private static double xOffset = 0;
    private static double yOffset = 0;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
       // this.primaryStage.setTitle("App");
		this.primaryStage.initStyle(StageStyle.UNDECORATED);

		initRootLayout();

		rootLayout.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        rootLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);

                if (isOpen())
                {
                    // newStage.setX(primaryStage.getX() + primaryStage.getWidth());
                    // newStage.setY(primaryStage.getY() + 60.0);
                    hideMenu();
                    setOpen(false);
                }

            }
        });


        // Отображаем сцену, содержащую корневой макет.
        Scene scene = new Scene(rootLayout);
        scene.getStylesheets().add(getClass().getResource("test.css").toExternalForm()); //$NON-NLS-1$
        primaryStage.setScene(scene);
        primaryStage.show();



	}

	public void initRootLayout() {
        try {
            // Загружаем из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("MainView.fxml"));
            rootLayout = (AnchorPane) loader.load();

            Controller controller = loader.getController();
            controller.setMainApp(this);
            controller.createNode(controller.list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void showMenu() {
            try {
            	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("secView.fxml")); //$NON-NLS-1$
            page = (AnchorPane)loader.load();

            	newStage = new Stage();
            	newStage.setX(primaryStage.getX() + primaryStage.getWidth() );
            	newStage.setY(primaryStage.getY() + 60.0);
            	newStage.initStyle(StageStyle.UNDECORATED);
            	newStage.initOwner(primaryStage);
                Scene scene = new Scene(page);
                newStage.setScene(scene);

            Controller controller = loader.getController();
            controller.setMainApp(this);

                newStage.show();
                setOpen(true);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }

	public void hideMenu()
    {
        newStage.hide();
        setOpen(false);
	}

    public boolean isOpen() {
        return this.isOpen;
    }

	public void setOpen(boolean b)
	{
		this.isOpen = b;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public Stage getNewStage() {
		return newStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
