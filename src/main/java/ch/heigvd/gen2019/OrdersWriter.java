package ch.heigvd.gen2019;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            getOrderContents(sb, orders.getOrder(i));
        }

        if (orders.getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

    private void getOrderContents(StringBuffer sb, Order order) {
        sb.append("{");
        sb.append(addContent("id", order.getOrderId()));
        getProductArray(sb, order);
        sb.append("}, ");
    }

    private void getProductArray(StringBuffer sb, Order order) {
        sb.append("\"products\": [");
        for (int j = 0; j < order.getProductsCount(); j++) {
            getProductContents(sb, order.getProduct(j));
        }

        if (order.getProductsCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]");
    }

    private void getProductContents(StringBuffer sb, Product product) {
        sb.append("{");

        sb.append(addContent("code", product.getCode()));
        sb.append(addContent("color", product.getColor()));

        if (product.getSize() != Size.SIZE_NOT_APPLICABLE) {
            sb.append(addContent("size", product.getSizeFor()));
        }

        sb.append(addContent("price", product.getPrice()));
        sb.append(addContent("currency", product.getCurrency()));

        sb.delete(sb.length() - 2, sb.length());
        sb.append("}, ");
    }

    private String addContent(String label, Object value) {
        return "\"" + label + "\": " + value + ", ";
    }

    private String addContent(String label, String value) {
        return addContent(label, (Object)("\"" + value + "\""));
    }
}