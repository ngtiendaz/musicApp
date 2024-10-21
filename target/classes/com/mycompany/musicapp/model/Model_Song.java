package com.mycompany.musicapp.model;

public class Model_Song {

    private int SongID;
    private int CategoryID;
    private int AlbumID;
    private int ArtistID;
    private String ImagePathSong;
    private String TitleSong;
    private String AudioSrc;
    private int Like;
    String NameArtist;

    public Model_Song(int SongID, int CategoryID, int AlbumID, int ArtistID, String ImagePathSong, String TitleSong, String AudioSrc, int Like, String NameArtist) {
        this.SongID = SongID;
        this.CategoryID = CategoryID;
        this.AlbumID = AlbumID;
        this.ArtistID = ArtistID;
        this.ImagePathSong = ImagePathSong;
        this.TitleSong = TitleSong;
        this.AudioSrc = AudioSrc;
        this.Like = Like;
        this.NameArtist = NameArtist;
    }

    public String getNameArtist() {
        return NameArtist;
    }

    public void setNameArtist(String NameArtist) {
        this.NameArtist = NameArtist;
    }

    public int getSongID() {
        return SongID;
    }

    public void setSongID(int SongID) {
        this.SongID = SongID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
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

    public String getImagePathSong() {
        return ImagePathSong;
    }

    public void setImagePathSong(String ImagePathSong) {
        this.ImagePathSong = ImagePathSong;
    }

    public String getTitleSong() {
        return TitleSong;
    }

    public void setTitleSong(String TitleSong) {
        this.TitleSong = TitleSong;
    }

    public String getAudioSrc() {
        return AudioSrc;
    }

    public void setAudioSrc(String AudioSrc) {
        this.AudioSrc = AudioSrc;
    }

    public int getLike() {
        return Like;
    }

    public void setLike(int Like) {
        this.Like = Like;
    }

}
