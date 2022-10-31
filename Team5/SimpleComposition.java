import java.util.ArrayList;

public class SimpleComposition implements Strategy {
    public void formIntoLines(ArrayList<Component> components) {
        StringBuilder sb = new StringBuilder();
        for (Component c : components) {
            String layout = c.getLayout();
            sb.append(layout);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
