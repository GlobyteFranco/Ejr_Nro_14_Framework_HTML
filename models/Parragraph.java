package models;

public class Parragraph implements Tag {
    private String text;
    private Tag htmlTag;

    public Parragraph(Tag htmlTag) {
        this.htmlTag = htmlTag;
    }

    public Parragraph(String text) {
        this.text = text;
    }

    public Parragraph() {
    }

    @Override
    public String displayTag() {
        return "<p>" + getValidatedHTML() + "</p>\n";
    }

    @Override
    public void insertSelfTag(Tag tag) {
        this.htmlTag = tag;
    }

    @Override
    public Tag hasTag() {
        return this.htmlTag;
    }

    public String getValidatedHTML() {
        if (this.text != null) {
            return text;
        }
        if (this.htmlTag != null) {
            return htmlTag.displayTag();
        } else {
            return "";
        }
    }

}
