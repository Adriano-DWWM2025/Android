package com.example.recyclerview;
public class Items {

    private int image;
    private String titre;
    private String description;

    public Items(int image, String titre, String description) {
        this.image = image;
        this.titre = titre;
        this.description = description;
    }
    public int getImage() {
        return image;
    }
    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
