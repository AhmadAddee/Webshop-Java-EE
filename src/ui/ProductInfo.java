package ui;

public class ProductInfo {
    private int id;
    private String name;
    private String imgUrl;
    private String descr;
    private float price;

    public ProductInfo(int id, String name, String imgUrl, String descr, float price) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.descr = descr;
        this.price = price;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
