package ch.heigvd.gen2019;

public class Product {
    private String code;
    private int color;
    private Size size;
    private double price;
    private String currency;
    
    public enum Size {SIZE_NOT_APPLICABLE, XS, S, M, L, XL, XXL}

    public Product(String code, int color, Size size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public int getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSizeFor() {
        return size.name();
    }

    public String getColorFor() {
        switch (getColor()) {
            case 1:
                return "blue";
            case 2:
                return "red";
            case 3:
                return "yellow";
            default:
                return "no color";
        }
    }
}