package ch.heigvd.gen2019;

public class OrderWriter extends JsonWritable {
    private Order order;

    public OrderWriter(Order order) {
        this.order = order;
    }

    public String json() {
        StringBuilder sb = new StringBuilder("{");
        sb.append(addTag("id", order.getOrderId()));

        sb.append("\"products\": [");
        for (int j = 0; j < order.getProductsCount(); j++) {
            sb.append(new ProductWriter(order.getProduct(j)).json());
        }

        if (order.getProductsCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}, ").toString();
    }
}
