package fr.tomoetek.jfxgalery.model;

public class Exemple {
    private String fxml;
    private String name;
    private String comment;

    public Exemple( String name, String comment) {
        this.fxml = "exemple_tile.fxml";
        this.name = name;
        this.comment = comment;
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
}
