import java.util.ArrayList;

public class Composition {
    private ArrayList<Component> components;
    
    Composition() {
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

    public void compose(Strategy strategy) {
        strategy.formIntoLines(components);
    }

    public void changeSize(String id, int size) {
        for (Component c : this.components) {
            if (id.equals(c.getId())) {
                if (c.changeSize(size)) {
                    System.out.println(String.format(
                        "component %s size changed to %d", c.getId(), size));
                } else {
                    System.out.println(String.format(
                        "component %s failed to change size", c.getId()));
                }
                break;
            }
        }
    }
}
