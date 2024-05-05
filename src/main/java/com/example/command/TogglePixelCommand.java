package com.example.command;

public class TogglePixelCommand implements Command{
    private Editor editor;

    public TogglePixelCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.togglePixel();
    }
}
