package org.mazerunner;

public class Cell {

    private final int id;
    private boolean visited = false;
    private final boolean[] walls = {true, true, true, true}; // Top, Right, Bottom, Left
    public Cell(int id) {
        this.id = id;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setVisited() {
        this.visited = true;
    }
    public int getId() {
        return this.id;
    }
    public boolean hasWall(int direction) {
        return walls[direction];
    }

    public void removeWall(int direction) {
        walls[direction] = false;
    }

    public String[] getCell() {
        String top = walls[0] ? "#" : ".";
        String right = walls[1] ? "#" : ".";
        String bot = walls[2] ? "#" : ".";
        String left = walls[3] ? "#" : ".";
        String[] cell = new String[3];
        cell[0] = "#" + top + "#";
        cell[1] = left + "." + right;
        cell[2] = "#" + bot + "#";
        return cell;
    }
}