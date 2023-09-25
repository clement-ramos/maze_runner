package org.mazerunner;
public class MazeRunner {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java -jar MazeGenerator [largeur] [hauteur] [perfect/imperfect] [simple/graph/optimized]");
            System.exit(1);
        }

        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        String type = args[2];
        String algorithm = args[3];

        // Utilisez les valeurs de width, height, type et algorithm pour configurer votre générateur de labyrinthe.
        // Appelez ensuite les méthodes appropriées pour générer le labyrinthe.

        // Print tout mes args

        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Type: " + type);
        System.out.println("Algorithm: " + algorithm);

    }
}