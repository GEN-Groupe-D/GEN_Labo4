package ch.heigvd.gen2019;

public class Product {
    private String code;
    private Color color;
    private Size size;
    private double price;
    private String currency;

    public enum Size {SIZE_NOT_APPLICABLE, XS, S, M, L, XL, XXL}

    public enum Color {
        NO_COLOR("no color"),
        BLUE("blue"),
        RED("red"),
        YELLOW("yellow");

        private String printable;
        Color(String printable) {
            this.printable = printable;
        }

        @Override
        public String toString() {
            return printable;
        }
    }

    public Product(String code, Color color, Size size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public Color getColor() {
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
        return color.toString();
    }
}