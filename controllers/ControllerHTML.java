package controllers;

import factories.TagFactory;
import models.DocumentHTML;
import models.Tag;

public class ControllerHTML {
    DocumentHTML DOM = new DocumentHTML();
    TagFactory tagFactory = new TagFactory();

    public void createAnchor(String text, String link, Tag tag) {
        if (link.trim().isEmpty()) {
            link = null;
        }
        if (text.trim().isEmpty()) {
            text = null;
        }
        DOM.addTagToBody(tagFactory.getAnchor(link, tag, text));
    }

    public void createBody() {
        DOM.setBody(tagFactory.getBody());
    }

    public void createImage(String url, String alt) {
        DOM.addTagToBody(tagFactory.getImage(url, alt));
    }

    public void createParragraph(String text, Tag tag) {
        DOM.addTagToBody(tagFactory.getParragaph(text, tag));
    }

    public String createPage() {
        return DOM.getHTML();
    }

    public String representTags() {
        return DOM.identifyTags();
    }

    public void insertParragraphInLastTag(String text, Tag tag) {
        DOM.insertInLastTag(tagFactory.getParragaph(text, tag));
    }

    public void insertAnchorInLastTag(String text, String link, Tag tag) {
        if (link.trim().isEmpty()) {
            link = null;
        }
        if (text.trim().isEmpty()) {
            text = null;
        }
        DOM.insertInLastTag(tagFactory.getAnchor(link, tag, text));

    }

    public void insertImageInLastTag(String Url, String alt) {
        DOM.insertInLastTag(tagFactory.getImage(Url, alt));
    }
}
