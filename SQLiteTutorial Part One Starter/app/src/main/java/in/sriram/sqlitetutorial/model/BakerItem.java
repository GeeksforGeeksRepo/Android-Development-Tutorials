package in.sriram.sqlitetutorial.model;

import java.util.Objects;

public class BakerItem {

    private int id;
    private String title, cost, time;

    public BakerItem(String title, String cost, String time) {
        this.title = title;
        this.cost = cost;
        this.time = time;
    }

    public BakerItem() {
    }

    public BakerItem(int id, String title, String cost, String time) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BakerItem bakerItem = (BakerItem) o;
        return Objects.equals(title, bakerItem.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cost, time);
    }
}
