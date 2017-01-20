package ru.agentlab.oomph.launcher;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Controller {

	private MainApp mainApp;

    @FXML
    private VBox vBox;

    @FXML
    private TextField search;

    private Parser parser = new Parser();
    private ArrayList<String> SearchResult = new ArrayList<>();
    private String SearchRequest = ""; //$NON-NLS-1$
    public ArrayList<String> list = parser.getLabels();

	public Controller()
	{

	}

	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
	}

	@FXML
	private void menuButton()
    {
		if(!mainApp.isOpen()) {
		mainApp.showMenu();
		}
        ifWorks();
	}

    @FXML
    private void search(KeyEvent ke) {

        if ((ke.getCode() == KeyCode.BACK_SPACE) && (!SearchRequest.isEmpty()))
        {
            SearchRequest = SearchRequest.substring(0, SearchRequest.length() - 1);
        }
        else
        {
            SearchRequest = SearchRequest + ke.getText();
        }
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).toLowerCase().contains(SearchRequest))
            {
                SearchResult.add(list.get(i));
            }
        }
        vBox.getChildren().clear();
        createNode(SearchResult);
        SearchResult.clear();

    }

    public void createNode(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++)
        {
            StackPane pane1 = new StackPane();
            Label label1 = new Label(list.get(i));
            pane1.setPrefWidth(400);
            pane1.setPrefHeight(100);
            pane1.getStyleClass().add("button1"); //$NON-NLS-1$
            StackPane.setAlignment(label1, Pos.CENTER);
            pane1.setOnMousePressed(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent me) {
                    System.out.println("Mouse Pressed"); //$NON-NLS-1$
                }
            });
            pane1.getChildren().add(label1);
            Separator sep = new Separator();
            sep.setPrefWidth(400);

            vBox.getChildren().add(pane1);
            vBox.getChildren().add(sep);
        }
    }

	@FXML
    private void ifWorks() {
            Integer b = vBox.getChildren().size();
        System.out.println(b);
        System.out.println(vBox.getChildren().get(0).toString());
        System.out.println(vBox.getWidth());
    }


    @FXML
    private void closeMenuButton()
    {
        if (mainApp.isOpen())
        {
            mainApp.hideMenu();
        }


	}

	@FXML
	private void closeButton()
	{
		Platform.exit();
	}

}
