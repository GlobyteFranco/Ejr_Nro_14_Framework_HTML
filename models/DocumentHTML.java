package models;

import java.util.List;

//todo hacer funcines para manejar el estado del utimo elemento insertado. Dependiendo de si esta sea un Anchor o Parragraph. La idea es que estas funcionalidades permitan jugar con la insercion de tags recursiva
public class DocumentHTML {
    private Body body;

    public DocumentHTML() {

    }

    public String getHTML() {
        if (body != null) {

            return body.displayTag();
        } else {
            throw new IllegalStateException("tried to obtain de HTML page without a body");
        }
    }

    public void addTagToBody(Tag tag) {

        if (body != null) {

            body.insertSelfTag(tag);
        } else {
            throw new IllegalStateException("tried to add without a body");
        }
    }

    public void setBody(Body body) {
        if (this.body == null) {

            this.body = body;
        } else {
            throw new IllegalStateException("There is already a body in hereee");
        }
    }

    public String identifyTags() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (Tag tag : body.getListTags()) {
            stringBuilder.append("[" + index + "] " + tag.displayTag());
            index += 1;
            while (tag.hasTag() != null) {
                index += 1;

                stringBuilder.append("[" + index + "] " + tag.hasTag().displayTag());
                tag = tag.hasTag();
            }
        }
        return stringBuilder.toString();
    }

    public void insertInLastTag(Tag tagInsertion) {
        Tag tagParent = obtainReferenceToLastTag();
        tagParent.insertSelfTag(tagInsertion);
    }

    private Tag obtainReferenceToLastTag() {
        List<Tag> listBodyTags = this.body.getListTags();
        if (!listBodyTags.isEmpty()) {
            Tag auxTag = listBodyTags.get(listBodyTags.size() - 1);

            while (auxTag.hasTag() != null) {
                auxTag = auxTag.hasTag();
            }
            return auxTag;
        } else {
            return null;
        }

    }

}
