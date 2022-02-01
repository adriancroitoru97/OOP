package fileio.input;

import enums.Category;

public final class GiftInputData {

    private final String productName;
    private final Double price;
    private final Category category;

    private final Integer quantity;

    public GiftInputData() {
        this.productName = null;
        this.price = null;
        this.category = null;
        this.quantity = null;
    }
    public GiftInputData(final String productName, final Double price,
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
}
