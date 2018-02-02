package kuzhelko_dmitry.horoscope.domain.entities;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Zodiac extends RealmObject {

    @PrimaryKey
    @Required
    private String id;
    private String title;
    private int imageId;
    private String range;
    private String description;

    public Zodiac() {
    }

    public Zodiac(String title, int imageId, String range, String description) {
        this.title = title;
        this.imageId = imageId;
        this.range = range;
        this.description = description;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int image) {
        this.imageId = imageId;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
