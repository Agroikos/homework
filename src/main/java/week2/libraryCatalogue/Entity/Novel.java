package week2.libraryCatalogue.Entity;

public class Novel extends Book {
    public enum Type {Mystery, SciFi, Romance, Adventure, Thriller, Crime}

    private Type type;

    public Novel() {
    }

    public Novel(String name, int pageCount, Type type) {
        super(name, pageCount);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Novel{" +
                "type=" + type +
                '}';
    }
}
