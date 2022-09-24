package fr.tomoetek.jfxgalery.model;

public class Exemple {
    private String exempleFxml;
    private String name;
    private String comment;

    private String fxml;

    public Exemple( String name, String comment, String fxml) {
        this.exempleFxml = "exemple_tile.fxml";
        this.name = name;
        this.comment = comment;
        this.fxml = fxml;
    }

    public String getFxml() {
        return fxml;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public String getExempleFxml() {
        return exempleFxml;
    }
}
