package com.mycompany.musicapp.model;

public class Model_Artist {

    private int ArtistID;

    private String Name;
    private String ImagePathArtists;
    private int Flow;

    public int getArtistID() {
        return ArtistID;
    }

    public void setArtistID(int ArtistID) {
        this.ArtistID = ArtistID;
    }

    public int getFlow() {
        return Flow;
    }

    public void setFlow(int Flow) {
        this.Flow = Flow;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getImagePathArtists() {
        return ImagePathArtists;
    }

    public void setImagePathArtists(String ImagePathArtists) {
        this.ImagePathArtists = ImagePathArtists;
    }

    public Model_Artist(int ArtistID, String Name, String ImagePathArtists, int Flow) {
        this.ArtistID = ArtistID;
        this.Name = Name;
        this.ImagePathArtists = ImagePathArtists;
        this.Flow = Flow;
    }

}
