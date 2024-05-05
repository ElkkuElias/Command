package com.example.command;

public class MoveCursorRightCommand implements Command{
    private Editor editor;

    public MoveCursorRightCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursorRight();
    }
}
