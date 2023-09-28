package org.mazerunner.GeneratorHandling;

public class Cell {

    private final int id;

    private int value;
    private Byte walls = 0b0000;

    private final Byte[] Masks = {
            0b0001, // top
            0b0010, // right
            0b0100, // bottom
            0b1000  // left
    };

    public void breakTopWall() {
        walls = (byte) (walls | Masks[0]);
    }
    public void breakRightWall() {
        walls = (byte) (walls | Masks[1]);
    }
    public void breakBottomWall() {
        walls = (byte) (walls | Masks[2]);
    }
    public void breakLeftWall() {
        walls = (byte) (walls | Masks[3]);
    }
    public Cell(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
    public String[] getCell() {
        String[] cell = new String[3];
        cell[0] = "###";
        cell[1] = "#" + id + "#";
        cell[2] = "###";
        return cell;
    }
}