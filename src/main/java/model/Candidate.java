package model;

import java.util.Objects;

public class Candidate {
    private int id;
    private int cityId;
    private String photoPath;
    private String name;

    public Candidate(int id, String name, int cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }

    public Candidate(int id, String photoPath, String name, int cityId) {
        this.id = id;
        this.photoPath = photoPath;
        this.name = name;
        this.cityId = cityId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return id == candidate.id &&
                cityId == candidate.cityId &&
                Objects.equals(photoPath, candidate.photoPath) &&
                Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityId, photoPath, name);
    }
}
