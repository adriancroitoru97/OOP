package database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import enums.Category;

public final class Gift {

    private final String productName;
    private final Double price;
    private final Category category;

    @JsonIgnore
    private Integer quantity;

    public Gift(final String productName, final Double price,
                final Category category, final Integer quantity) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }
}
