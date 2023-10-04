package org.mazerunner;

import org.mazerunner.GeneratorHandling.*;
import org.mazerunner.exeptions.MazeGenerationException;

public class Maze {
    private final Cell[] cellTab;
    private final int width;
    private final int height;
    public String generationType, generatorMethod;
/*    private Stack<Integer> path;*/

    public Maze(int width, int height, String generationType, String generatorMethod){
        this.width = width;
        this.height = height;
        cellTab = new Cell[width * height];
        this.generationType = generationType; // perfect or imperfect
        this.generatorMethod = generatorMethod; // simple, graph or optimized
        initializeGrid();
        chooseGenerator();
        displayMaze();
    }
    private void initializeGrid() {
        for (int id = 0; id < cellTab.length; id++) {
            cellTab[id] = new Cell(id);
        }
    }
    public void chooseGenerator(){
        switch (generationType) {
            case "perfect" -> {
                switch (generatorMethod) {
                    case "simple" -> new SimplePerfectMazeGenerator(cellTab, width, height);
                    case "graph" -> new GraphBasedPerfectMazeGenerator(cellTab, width, height);
                    case "optimized" -> new OptimizedMazeGenerator(cellTab, width, height);
                }
            }
            case "imperfect" -> {
                switch (generatorMethod) {
                    case "simple" -> new SimpleImperfectMazeGenerator(cellTab, width, height);
                    case "graph" -> new GraphBasedImperfectMazeGenerator(cellTab, width, height);
                    case "optimized" -> new OptimizedMazeGenerator(cellTab, width, height);
                }
            }
        }
    }

    public void displayMaze() {
        cellTab[0].removeWall(0);
        cellTab[cellTab.length - 1].removeWall(2);
        int delta = 0;
        for (int y = 0; y < height; y++) {
            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
            StringBuilder str3 = new StringBuilder();
            for (int x = 0; x < width; x++) {
                String[] strs = cellTab[x + delta].getCell();
                str1.append(strs[0]);
                str2.append(strs[1]);
                str3.append(strs[2]);
            }
            delta += width;
            System.out.println(str1 + "\n" + str2 + "\n" + str3);
        }
    }
}





