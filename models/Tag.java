package models;

public interface Tag {
    public String displayTag();

    public void insertSelfTag(Tag tag);

    public Tag hasTag();
}
