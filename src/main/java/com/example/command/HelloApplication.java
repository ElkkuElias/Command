package com.example.command;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private Editor editor = new Editor();
    private Circle cursorCircle;

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        cursorCircle = new Circle(10, Color.RED);
        cursorCircle.setStroke(Color.BLACK);


        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle rect = new Rectangle(20, 20);
                rect.setFill(Color.WHITE);
                rect.setStroke(Color.PINK);
                GridPane.setRowIndex(rect, y);
                GridPane.setColumnIndex(rect, x);
                gridPane.getChildren().add(rect);
            }
        }


        gridPane.add(cursorCircle, 0, 0);
        GridPane.setHalignment(cursorCircle, HPos.CENTER);
        GridPane.setValignment(cursorCircle, VPos.CENTER);

        Scene scene = new Scene(gridPane, 160, 160);
        stage.setScene(scene);
        stage.show();


        scene.setOnKeyPressed(event -> {
            Command command = null;
            switch (event.getCode()) {
                case UP:
                    command = new MoveCursorUpCommand(editor);
                    break;
                case DOWN:
                    command = new MoveCursorDownCommand(editor);
                    break;
                case LEFT:
                    command = new MoveCursorLeftCommand(editor);
                    break;
                case RIGHT:
                    command = new MoveCursorRightCommand(editor);
                    break;
                case SPACE:
                    command = new TogglePixelCommand(editor);
                    break;
                case ENTER:
                    command = new GenerateCodeCommand(editor);
                    break;
                default:
                    break;
            }
            if (command != null) {
                command.execute();
                updateGrid(gridPane);
            }
        });
    }


    private void updateGrid(GridPane gridPane) {
        for (Node node : gridPane.getChildren()) {
            if (node instanceof Rectangle) {
                Rectangle rect = (Rectangle) node;
                int y = GridPane.getRowIndex(rect);
                int x = GridPane.getColumnIndex(rect);
                rect.setFill(editor.getGrid()[y][x] == 1 ? Color.BLACK : Color.WHITE);
            }
        }
        GridPane.setColumnIndex(cursorCircle, editor.getCursorX());
        GridPane.setRowIndex(cursorCircle, editor.getCursorY());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
