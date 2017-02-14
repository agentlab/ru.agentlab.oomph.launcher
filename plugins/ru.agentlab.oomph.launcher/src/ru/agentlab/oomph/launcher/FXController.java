package ru.agentlab.oomph.launcher;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FXController {
	@Inject
	private PrintService service;

    @FXML
    Button button;

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
		service.print("Hello World!");
	}
}
