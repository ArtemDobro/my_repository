package by.epam.dobrohotov.englishWeb.bean;

import java.util.Objects;

public class Purchase {
    private String description;
    private int cost;

    public Purchase(String description, int cost) {
        this.description = description;
        this.cost = cost;
    }

    public Purchase() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return cost == purchase.cost && Objects.equals(description, purchase.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, cost);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
