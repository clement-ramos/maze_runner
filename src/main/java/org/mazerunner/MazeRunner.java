package org.mazerunner;

import org.mazerunner.GeneratorHandling.Maze;

import java.util.HashMap;
import java.util.List;

public class MazeRunner {
    public static void main(String[] args) {

        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);

        HashMap<Integer, List<Integer>> valuesGroups = new HashMap<>();

       Maze maze = new Maze(width, height);
    }
}