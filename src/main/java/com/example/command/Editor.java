package com.example.command;

public class Editor {
    private int cursorX = 0;
    private int cursorY = 0;
    private int[][] grid = new int[8][8];

    public int getCursorY(){
        System.out.println(cursorY);
        return cursorY;
    }
    public int getCursorX(){
        return cursorX;
    }

    public void moveCursorUp() {
        if (cursorY > 0) cursorY--;
    }

    public void moveCursorDown() {
        if (cursorY < 7) cursorY++;
    }

    public void moveCursorLeft() {
        if (cursorX > 0) cursorX--;
    }

    public void moveCursorRight() {
        if (cursorX < 7) cursorX++;
    }

    public void togglePixel() {
        grid[cursorY][cursorX] ^= 1;
    }

    public int[][] getGrid() {
        return grid;
    }
}

