package com.example.inuapp.models;

public class Products {
    private String productId;
    private String productCategory;
    private String productName;

    private String productImageUrl;
    private Double productMarketPricePerUnit;
    private String productDescription;

    private String productUnit;
    private Double productSellingPricePerUnit;
    private String postedAt;

    private int productSellCount;

    public static final String ELECTRONICS = "Electronics";
    public static final String HOME = "Home";
    public static final String GAMING = "Gaming";
    public static final String FASHION = "Fashion";
    public static final String COMPUTING = "Computing";
    public static final String SPORTING = "Sporting";

    public static final String WEIGHT = "Weight";
    public static final String LITRES = "Litres";
    public static final String COUNT = "Count";

    public static final String PRODUCT_IMAGES = "Product Images";

    public static final String PRODUCT_SUR = "PD";
    public static final String NO_IMAGE = "https://techweez.com/wp-content/uploads/2017/07/NO-IMAGE.png";

    public Products(String productId, String productCategory, String productName, String productImageUrl, Double productMarketPricePerUnit, String productDescription, String productUnit, Double productSellingPricePerUnit, String postedAt, int productSellCount) {
        this.productId = productId;
        this.productCategory = productCategory;
        this.productName = productName;
        this.productImageUrl = productImageUrl;
        this.productMarketPricePerUnit = productMarketPricePerUnit;
        this.productDescription = productDescription;
        this.productUnit = productUnit;
        this.productSellingPricePerUnit = productSellingPricePerUnit;
        this.postedAt = postedAt;
        this.productSellCount = productSellCount;
    }

    public Products() {
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public Double getProductMarketPricePerUnit() {
        return productMarketPricePerUnit;
    }

    public void setProductMarketPricePerUnit(Double productMarketPricePerUnit) {
        this.productMarketPricePerUnit = productMarketPricePerUnit;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Double getProductSellingPricePerUnit() {
        return productSellingPricePerUnit;
    }

    public void setProductSellingPricePerUnit(Double productSellingPricePerUnit) {
        this.productSellingPricePerUnit = productSellingPricePerUnit;
    }

    public String getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(String postedAt) {
        this.postedAt = postedAt;
    }

    public int getProductSellCount() {
        return productSellCount;
    }

    public void setProductSellCount(int productSellCount) {
        this.productSellCount = productSellCount;
    }
}
