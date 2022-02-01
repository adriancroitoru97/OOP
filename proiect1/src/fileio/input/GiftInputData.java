package fileio.input;

import enums.Category;

public final class GiftInputData {

    private final String productName;
    private final Double price;
    private final Category category;

    public GiftInputData() {
        this.productName = null;
        this.price = null;
        this.category = null;
    }
    public GiftInputData(final String productName, final Double price,
                         final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
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
}
