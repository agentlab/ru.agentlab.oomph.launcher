package ru.agentlab.oomph.launcher;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXController {
	@Inject
	private PrintService service;
    @FXML
    private TextField textField;
    @FXML
    private Button button;

	@PostConstruct
	void created(IEclipseContext context) {
		System.err.println("Parent post construction");
	}

	@FXML
	void initialize() {
		System.err.println("Parent controller");
	}

    @FXML
    void sayHello() {
        //service.print(SocketListener.callURL("http://localhost:8080/hello/ihello/hello2"));
        service.print("Hello");
        textField.setText(SocketListener.callURL("http://localhost:8080/RestWebService/rest/helloWorld/hello"));
	}
}
