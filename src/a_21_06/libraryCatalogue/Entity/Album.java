package a_21_06.libraryCatalogue.Entity;

public class Album extends Book {
    public enum PaperQuality {Glossy, Coarse, BlackAndWhite, Color}
    private PaperQuality quality;

    public Album() {
    }

    public Album(String name, int pageCount, PaperQuality quality) {
        super(name, pageCount);
        this.quality = quality;
    }

    public PaperQuality getQuality() {
        return quality;
    }

    public void setQuality(PaperQuality quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Album{" +
                "quality=" + quality +
                '}';
    }
}
