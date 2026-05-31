package models;

public class Anchor implements Tag {
    private String href = "";
    private String text;
    private Tag htmlTag;

    public Anchor(String href, String text) {
        this.href = href;
        this.text = text;
    }

    @Override
    public void insertSelfTag(Tag tag) {
        this.htmlTag = tag;
    }

    @Override
    public String displayTag() {
        return "<a href=\" " + href + "\">" + getValidatedHTML() + "</a>\n";
    }

    @Override
    public Tag hasTag() {
        return this.htmlTag;
    }

    public Anchor(String href, Tag htmlTag) {
        this.href = href;
        this.htmlTag = htmlTag;
    }

    public String getValidatedHTML() {
        if (this.text != null) {
            return text;
        }
        if (this.htmlTag != null) {
            return htmlTag.displayTag();
        }
        throw new IllegalStateException("Not correct value intered");
    }

}
