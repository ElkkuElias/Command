package com.example.command;

public class GenerateCodeCommand implements Command{
    private Editor editor;

    public GenerateCodeCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        System.out.println("int[][] pixelArt = {");
        for (int[] row : editor.getGrid()) {
            System.out.print("    {");
            for (int cell : row) {
                System.out.print(cell + ", ");
            }
            System.out.println("},");
        }
        System.out.println("};");
    }
}
