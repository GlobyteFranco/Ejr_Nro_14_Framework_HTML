package factories;

import models.Anchor;
import models.Body;
import models.Image;
import models.Parragraph;
import models.Tag;

public class TagFactory {
    // private boolean isBodySet = false;

    public TagFactory() {
    }

    public Tag getAnchor(String href, Tag htmlTag, String texto) {
        if (htmlTag != null) {
            return new Anchor(href, htmlTag);
        } else {
            return new Anchor(href, texto);
        }
    }

    public Body getBody() {
        return new Body();
    }

    public Tag getImage(String imageUrl, String alt) {
        return new Image(imageUrl, alt);

    }

    public Tag getParragaph(String texto, Tag htmlTag) {
        if (htmlTag == null) {
            return new Parragraph(texto);
        } else {
            return new Parragraph(htmlTag);
        }
    }

}
