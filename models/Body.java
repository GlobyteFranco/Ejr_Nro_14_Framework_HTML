package models;

import java.util.ArrayList;
import java.util.List;

public class Body implements Tag {
    private List<Tag> listTags = new ArrayList<>();

    public Body() {
    }

    public Body(List<Tag> list) {
        for (Tag tag : list) {
            insertSelfTag(tag);
        }

    }

    @Override
    public String displayTag() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<body>\n");
        for (Tag tagListElement : listTags) {
            stringBuilder.append(tagListElement.displayTag());
        }
        stringBuilder.append("</body>\n");

        return stringBuilder.toString();
    }

    @Override
    public void insertSelfTag(Tag tag) {
        if (tag instanceof Body) {
            throw new IllegalArgumentException("A body cannot contain another body dude pls");
        } else {
            listTags.add(tag);
        }
    }

    @Override
    public Tag hasTag() {
        return null;
    }

    public List<Tag> getListTags() {
        return listTags;
    }

}
