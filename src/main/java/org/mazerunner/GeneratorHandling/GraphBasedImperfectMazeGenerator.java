package org.mazerunner.GeneratorHandling;

import org.mazerunner.Cell;
import org.mazerunner.MazeGenerator;

import java.util.Random;
import java.util.Stack;

public class GraphBasedImperfectMazeGenerator implements MazeGenerator{
    public GraphBasedImperfectMazeGenerator(Cell[] cell, int width, int height) {

        generateMaze(cell, width, height);
    }

    @Override
    public void generateMaze(Cell[] cellTab, int width, int height) {

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
        if (cellTab[0].hasWall(1)) {
            cellTab[0].removeWall(1);
            cellTab[1].removeWall(3);
        } else {
            cellTab[0].removeWall(2);
            cellTab[width].removeWall(0);
        }
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

}
