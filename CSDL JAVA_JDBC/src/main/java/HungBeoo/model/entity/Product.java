package HungBeoo.model.entity;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.util.Date;

/*
• ProductId int primary key auto_increment
• ProductName nvarchar(50) not null
• Price float not null
• Created date – ngày tạo
• Descriptions text
• ProductStatus bit
 */
public class Product {
    private int productId;
    private String productName;
    private float price;
    private Date created;
    private String descriptions;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, float price, Date created, String descriptions, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.created = created;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }
}
