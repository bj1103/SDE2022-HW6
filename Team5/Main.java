import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 1) {
            System.out.println("No input file");
            return;
        }
        String inputPath = args[0];
        File inputFile = new File(inputPath);
        Scanner scanner;
        Composition composition = new Composition();
        try {
            scanner = new Scanner(inputFile);
        }
        catch (FileNotFoundException e) {
            throw e;
        }
        String[] nextLine;
        
        while (scanner.hasNext()) {
            nextLine = scanner.nextLine().split(" ");
            if (nextLine.length == 6) {
                Component component;
                String type = nextLine[0];
                String id = nextLine[1];
                int naturalSize = Integer.parseInt(nextLine[2]);
                int shrinkability = Integer.parseInt(nextLine[3]);
                int stretchability = Integer.parseInt(nextLine[4]);
                String content = nextLine[5];

                if (type.equals("Text")) {
                    component = new Text(id, content, naturalSize, 
                        stretchability, shrinkability);
                } else {
                    component = new Graphic(id, content, naturalSize, 
                        stretchability, shrinkability);
                }
                composition.addComponent(component);
            } else if (nextLine.length == 3) {
                String id = nextLine[1];
                int size = Integer.parseInt(nextLine[2]);
                composition.changeSize(id, size);
            } else if (nextLine.length == 2) {
                Strategy strategy;
                switch (nextLine[1]) {
                case "SimpleComposition":
                    strategy = new SimpleComposition();
                    composition.compose(strategy);
                    break;
                case "TexComposition":
                    strategy = new TexComposition();
                    composition.compose(strategy);
                    break;
                case "ArrayComposition":
                    strategy = new ArrayComposition();
                    composition.compose(strategy);
                    break;
                default:
                    break;
                }
            }
        }
        scanner.close();
    }
}