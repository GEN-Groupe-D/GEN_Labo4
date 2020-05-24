package ch.heigvd.gen2019;

public class ProductWriter implements JsonWritable {
    private Product product;

    public ProductWriter(Product product) {
        this.product = product;
    }

    public String json() {
        StringBuilder sb = new StringBuilder("{");

        sb.append(addTag("code", product.getCode()));
        sb.append(addTag("color", product.getColor()));

        if (product.getSize() != Size.SIZE_NOT_APPLICABLE) {
            sb.append(addTag("size", product.getSizeFor()));
        }

        sb.append(addTag("price", product.getPrice()));
        sb.append(addTag("currency", product.getCurrency()));

        sb.delete(sb.length() - 2, sb.length());
        return sb.append("}, ").toString();
    }

    private String addTag(String label, Object value) {
        return "\"" + label + "\": " + value + ", ";
    }

    private String addTag(String label, String value) {
        return addTag(label, (Object)("\"" + value + "\""));
    }
}
