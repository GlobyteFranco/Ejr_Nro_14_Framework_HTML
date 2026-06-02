package models;

public class Image implements Tag {
    private String href = "";
    private String alternative = "";

    public Image(String imageUrl, String alt) {
        this.href = imageUrl;
        this.alternative = alt;
    }

    @Override
    public String displayTag() {
        return " <img src=\"" + href + "\" alt=\"" + alternative + "\">\n";
    }

    @Override
    public void insertSelfTag(Tag tag) {
        throw new UnsupportedOperationException("UnCannot implemented method 'insertSelfTag' in this class");
    }

    @Override
    public Tag hasTag() {
        return null;
    }

}
