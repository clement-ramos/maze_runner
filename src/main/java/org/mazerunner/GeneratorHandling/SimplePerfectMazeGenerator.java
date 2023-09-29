package org.mazerunner.GeneratorHandling;

import org.mazerunner.MazeGenerator;
import org.mazerunner.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class SimplePerfectMazeGenerator implements MazeGenerator{

    public SimplePerfectMazeGenerator(Cell[] cellTab, int width, int height) {
        generateMaze(cellTab, width, height);
    }

    @Override
    public void generateMaze(Cell[] cellTab, int width, int height) {
        List<String> array = new ArrayList<String>();
        List<String> wall = new ArrayList<String>();
        List<String> line = new ArrayList<String>();

        for (int i = 0; i < width; i++) {
            wall.add("#");

            if(((i - 1) % 2 == 0)  && (i != (width - 1))){
                line.add(".");
            }
            else {
                line.add("#");
            }
        }
        for (int i = 0; i < height; i++) {
           if(i % 2 == 0){
               array.addAll(wall);
           }
           else if (i != height - 1){
               array.addAll(line);
           }

        }

        for(int y = 0; y < height; y++){
           for(int x =0; x < width;x++){
               System.out.print(array.get(x + y * width));
           }
           System.out.println();
        }

    }

}
