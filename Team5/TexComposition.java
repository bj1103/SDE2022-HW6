import java.util.ArrayList;

public class TexComposition implements Strategy {
    public void formIntoLines(ArrayList<Component> components) {
        StringBuilder sb = new StringBuilder();
        for (Component c : components) {
            String layout = c.getLayout();
            sb.append(layout);
            if (c.isParagraphEnd()) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }
        System.out.print(sb.toString());
    }
}
