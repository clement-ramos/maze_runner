package org.mazerunner.GeneratorHandling;

import java.util.*;
public class Maze {
    private final Cell[] cellTab;
    private HashMap<Integer, List<Integer>> valuesGroups = new HashMap<>();
    private final int width;
    private final int height;
    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        cellTab = new Cell[width * height];
        initGrid();
    }
    public void initGrid() {
        for (int id = 0; id < cellTab.length; id++) {
            cellTab[id] = new Cell(id );
            cellTab[id].setValue(id);
            valuesGroups.put(id, List.of(id));
        }
        createMaze();
    }
    public void createMaze(){

        ArrayList<Integer> stacks = new ArrayList<Integer>();
        for (int i = 0; i < cellTab.length; i++) {
            stacks.add(i);

        }
        Collections.shuffle(stacks);
        System.out.println("Sequence random : " + stacks);
        
        for (int i = 0; i < valuesGroups.size(); i++) {
            List validDirections = getValidNeighbor(stacks.get(i));
            System.out.println("Valid Directions : " + validDirections);
            String direction = randDirection(validDirections);
            System.out.println("Direction : " + direction);
            modifyGrid(direction, stacks.get(i));
        }
    }

    public List<String> getValidNeighbor(int cellID) { //
        List<String> validNeighbors = new ArrayList<String>();
        int currentX = cellTab[cellID].getId() % width;
        int currentY = cellTab[cellID].getId() / width;

        System.out.println("Cell ID " + cellID);
            if (currentY > 0 ){
                if(cellTab[cellID - width].getValue() != cellTab[cellID].getValue()){
                    validNeighbors.add("top");
                }
            }
            if (currentX < width-1){
                if(cellTab[cellID + 1].getValue() != cellTab[cellID].getValue()){
                    validNeighbors.add("right");
                }
            }
            if (currentY < height-1){
                if(cellTab[cellID + width].getValue() != cellTab[cellID].getValue()){
                    validNeighbors.add("bottom");
                }
            }
            if (currentX > 0){
                if(cellTab[cellID - 1].getValue() != cellTab[cellID].getValue()){
                    validNeighbors.add("left");
                }
            }
            return validNeighbors;

        }

        public String randDirection(List<String> validDirection){
            Random rand = new Random();
            int randomIndex = rand.nextInt(validDirection.size());
            return validDirection.get(randomIndex);
        }

        public void modifyGrid(String direction, int cellID){
            switch (direction){
                case "top":
                    //méthdde TOP gere les 2 cells
                    cellTab[cellID].breakTopWall();
                    cellTab[cellID - width].breakBottomWall();
                    setValues(cellID, cellID - width);
                    break;
                case "right":
                    cellTab[cellID].breakRightWall();
                    cellTab[cellID + 1].breakLeftWall();
                    setValues(cellID, cellID  + 1);
                    break;
                case "bottom":
                    cellTab[cellID].breakBottomWall();
                    cellTab[cellID + width].breakTopWall();
                    setValues(cellID, cellID + width);
                    break;
                case "left":
                    cellTab[cellID].breakLeftWall();
                    cellTab[cellID - 1].breakRightWall();
                    setValues(cellID, cellID - 1);
                    break;
            }
        }
    private void setValues(int id1, int id2){  // ID current cell et ID cell du voisin
        List<Integer> temp = new ArrayList<>(valuesGroups.get(id1)) ;
        temp.addAll(valuesGroups.get(id2));

        if (id1 > id2){            // tout ce qui se trouve dans la key ID1 se change en ID2 et on ecrit tout ce qu'il y a dans ID1 dans la key ID 2
            for (int i = 0; i < valuesGroups.get(id1).size(); i++) {
                cellTab[id1].setValue(id2);
                valuesGroups.put(id1, valuesGroups.get(id2));
            }
            System.out.println("oui");

        }
        else {
            for (int i = 0; i < valuesGroups.get(id2).size(); i++) {
                cellTab[id2].setValue(id1);
                valuesGroups.put(id2, valuesGroups.get(id1));
            }
            System.out.println("non");
        }
        System.out.println(valuesGroups);
        System.out.println(temp);


    }

    public void displayMaze() {
        int delta = 0;
        // Avoir une liste une seule dimension
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




