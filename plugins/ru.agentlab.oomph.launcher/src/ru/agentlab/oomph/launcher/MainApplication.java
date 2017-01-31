package ru.agentlab.oomph.launcher;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.fx.core.di.LocalInstance;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApplication {

	@PostConstruct
	void run(IApplicationContext applicationContext, javafx.application.Application jfxApplication, Stage primaryStage, @LocalInstance FXMLLoader loader) {
		loader.setLocation(getClass().getResource("ExampleGraph.fxml"));
		try {
			BorderPane pane = loader.load();
            Scene s = new Scene(pane, 300, 50);
			primaryStage.setScene(s);
			primaryStage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
