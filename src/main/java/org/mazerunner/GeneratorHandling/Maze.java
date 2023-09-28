package org.mazerunner.GeneratorHandling;

import java.util.Stack;
import java.util.Random;


public class Maze {
    private final Cell[] cellTab;
    private final int width;
    private final int height;
    private Stack<Integer> path;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        cellTab = new Cell[width * height];
        initializeGrid();
        createMaze();
        displayMaze();
    }
    private void initializeGrid() {
        for (int id = 0; id < cellTab.length; id++) {
            cellTab[id] = new Cell(id);
        }
    }
    public void createMaze() {
        Stack<Integer> path = new Stack<>();
        path.push(0);

        while (!path.isEmpty()) {
            int id = path.peek();
            cellTab[id].setVisited();
            int x = id % width;
            int y = id / width;
            Random rand = new Random();

            int[] possibilities = {1, 1, 1, 1};
            if (x == 0 || cellTab[id - 1].isVisited()) {
                possibilities[3] = 0;
            }
            if (x == width - 1 || cellTab[id + 1].isVisited()) {
                possibilities[1] = 0;
            }
            if (y == 0 || cellTab[id - width].isVisited()) {
                possibilities[0] = 0;
            }
            if (y == height - 1 || cellTab[id + width].isVisited()) {
                possibilities[2] = 0;
            }

            if (sum(possibilities) != 0) {
                int index = rand.nextInt(4);

                while (possibilities[index] == 0) {
                    index = rand.nextInt(4);
                }
                switch (index) {
                    case 0 -> {
                        cellTab[id].removeWall(0);
                        cellTab[id - width].removeWall(2);
                        path.push(id - width);
                    }
                    case 1 -> {
                        cellTab[id].removeWall(1);
                        cellTab[id + 1].removeWall(3);
                        path.push(id + 1);
                    }
                    case 2 -> {
                        cellTab[id].removeWall(2);
                        cellTab[id + width].removeWall(0);
                        path.push(id + width);
                    }
                    case 3 -> {
                        cellTab[id].removeWall(3);
                        cellTab[id - 1].removeWall(1);
                        path.push(id - 1);
                    }
                }
            } else {
                path.pop();
            }
        }
        // IMPERFECT MAZE
/*        if (cellTab[0].hasWall(1)) {
            cellTab[0].removeWall(1);
            cellTab[1].removeWall(3);
        } else {
            cellTab[0].removeWall(2);
            cellTab[width].removeWall(0);
        }*/
    }
    public static int sum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
    public void displayMaze() {
        cellTab[0].removeWall(3);
        cellTab[cellTab.length - 1].removeWall(1);
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





