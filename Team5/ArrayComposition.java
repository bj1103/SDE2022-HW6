import java.util.ArrayList;

public class ArrayComposition implements Strategy {
    public void formIntoLines(ArrayList<Component> components) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < components.size(); i++) {
            String layout = components.get(i).getLayout();
            sb.append(layout);
            if ((i + 1) % 3 == 0 || i + 1 == components.size()) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }
        System.out.print(sb.toString());
    }
}
