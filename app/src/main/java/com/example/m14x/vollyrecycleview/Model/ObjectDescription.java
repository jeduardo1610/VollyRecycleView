package com.example.m14x.vollyrecycleview.Model;

import java.util.List;

/**
 * Created by m14x on 27/01/2016.
 */
public class ObjectDescription {


    private String wrapperType;
    private String kind;
    private Integer artistId;
    private Integer collectionId;
    private Integer trackId;
    private String artistName;
    private String collectionName;



    public ObjectDescription() {

    }

    public ObjectDescription(String collectionName, String artistName, Integer trackId, Integer collectionId, Integer artistId, String kind, String wrapperType) {
        this.collectionName = collectionName;
        this.artistName = artistName;
        this.trackId = trackId;
        this.collectionId = collectionId;
        this.artistId = artistId;
        this.kind = kind;
        this.wrapperType = wrapperType;

    }



    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}
