package ru.agentlab.oomph.launcher;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;

import javafx.fxml.FXML;

public class FXSubController {
	@Inject
	private PrintService service;

	@PostConstruct
	void created(IEclipseContext context) {
		System.err.println("Subcontroller post construction");
	}

	@FXML
	void initialize() {
		System.err.println("Subcontroller controller");
	}

	@FXML
	void sayHello() {
		service.print("Subcontroller - Hello World!");
	}
}
