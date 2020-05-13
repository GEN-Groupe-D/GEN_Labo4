package ch.heigvd.gen2019;

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
