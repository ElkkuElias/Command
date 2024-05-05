package com.example.command;

public class MoveCursorDownCommand implements Command {
    private Editor editor;

    public MoveCursorDownCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursorDown();
    }
}
