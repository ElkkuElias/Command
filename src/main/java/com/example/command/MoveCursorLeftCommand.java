package com.example.command;

public class MoveCursorLeftCommand implements Command{
    private Editor editor;

    public MoveCursorLeftCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursorLeft();
    }
}
