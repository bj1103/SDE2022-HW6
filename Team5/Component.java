public abstract class Component {
    private String Id;
    private String content;
    private int naturalSize;
    private int stretchability;
    private int shrinkability;

    Component(String Id, String content, int naturalSize, 
        int stretchability, int shrinkability) {
        this.Id = Id;
        this.content = content;
        this.naturalSize = naturalSize;
        this.stretchability = stretchability;
        this.shrinkability = shrinkability;
    }

    public boolean grow(int size) {
        if (size <= this.stretchability) {
            this.naturalSize = size;
            return true;
        } else {
            return false;
        }
    }

    public boolean shrink(int size) {
        if (size >= this.shrinkability) {
            this.naturalSize = size;
            return true;
        } else {
            return false;
        }
    }

    public boolean changeSize(int size) {
        return (size > this.naturalSize)? this.grow(size) : this.shrink(size);
    }

    public String getId() {
        return this.Id;
    }

    public String getContent() {
        return this.content;
    }

    public String getLayout() {
        return String.format("[%d]%s", this.naturalSize, this.content);
    }

    public boolean isParagraphEnd() {
        return this.content.equals("<ParagraphEnd>");
    }
}
