package com.mycompany.musicapp.model;

public class Model_Album {

    private int AlbumID;
    private int ArtistID;
    private String TitleAlbum;
    private String ImagePathAlbum;
    private String NameArtist;

    public Model_Album(int AlbumID, int ArtistID, String TitleAlbum, String ImagePathAlbum, String NameArtist) {
        this.AlbumID = AlbumID;
        this.ArtistID = ArtistID;
        this.TitleAlbum = TitleAlbum;
        this.ImagePathAlbum = ImagePathAlbum;
        this.NameArtist = NameArtist;
    }

    public String getNameArtist() {
        return NameArtist;
    }

    public void setNameArtist(String NameArtist) {
        this.NameArtist = NameArtist;
    }

    public int getAlbumID() {
        return AlbumID;
    }

    public void setAlbumID(int AlbumID) {
        this.AlbumID = AlbumID;
    }

    public int getArtistID() {
        return ArtistID;
    }

    public void setArtistID(int ArtistID) {
        this.ArtistID = ArtistID;
    }

    public String getTitleAlbum() {
        return TitleAlbum;
    }

    public void setTitleAlbum(String TitleAlbum) {
        this.TitleAlbum = TitleAlbum;
    }

    public String getImagePathAlbum() {
        return ImagePathAlbum;
    }

    public void setImagePathAlbum(String ImagePathAlbum) {
        this.ImagePathAlbum = ImagePathAlbum;
    }

}
