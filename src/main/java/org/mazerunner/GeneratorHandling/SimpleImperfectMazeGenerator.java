package org.mazerunner.GeneratorHandling;

import org.mazerunner.Cell;
import org.mazerunner.MazeGenerator;
import java.util.Random;
import java.util.Stack;

public class SimpleImperfectMazeGenerator implements MazeGenerator{
    public SimpleImperfectMazeGenerator(Cell[] cell, int width, int height) {
        generateMaze(cell, width, height);
    }
    @Override
    public void generateMaze(Cell[] cellTab, int width, int height) {

    }

}
