package org.mazerunner.GeneratorHandling;

import org.mazerunner.Cell;
import org.mazerunner.MazeGenerator;

public class OptimizedMazeGenerator implements MazeGenerator{

    public OptimizedMazeGenerator(Cell[] cell, int width, int height) {

        generateMaze(cell, width, height);
    }

    @Override
    public void generateMaze(Cell[] cell, int width, int height) {
        System.out.println("OptimizedMazeGenerator");
    }

}
