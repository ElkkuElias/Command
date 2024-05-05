package com.example.command;

public class MoveCursorUpCommand implements Command{
    private Editor editor;

    public MoveCursorUpCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursorUp();
    }
}
