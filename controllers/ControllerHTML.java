package controllers;

import factories.TagFactory;
import models.DocumentHTML;
import models.Tag;

public class ControllerHTML {
    DocumentHTML DOM = new DocumentHTML();
    TagFactory tagFactory = new TagFactory();

    public void createAnchor(String text, String link, Tag tag) {
        // TODO estas validaciones deberian estar dentro del tagfactory
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
        // En el propio objeto tienen valores por defecto
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

    public void workWithLastTagBeforeNull() {
        // Tag tagInFact = DOM.;
        // //TODO aca obtendriamos la ultima referencia a un Tag
        // antes de un null. Nos sirve para agregar tags dentro de otros tag sin poder
        // mantener un contexto de estos por parte de la vista

    }

}
