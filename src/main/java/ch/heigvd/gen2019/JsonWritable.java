package ch.heigvd.gen2019;

public abstract class JsonWritable {
    public abstract String json();

    protected String addTag(String label, Object value) {
        return "\"" + label + "\": " + value + ", ";
    }

    protected String addTag(String label, String value) {
        return addTag(label, (Object)("\"" + value + "\""));
    }
}
