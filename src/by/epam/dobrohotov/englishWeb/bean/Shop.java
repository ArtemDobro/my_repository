package by.epam.dobrohotov.englishWeb.bean;

import java.util.List;
import java.util.Objects;

public class Shop {
    private List<Purchase> purchases;

    public Shop(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(purchases, shop.purchases);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchases);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "purchases=" + purchases +
                '}';
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
