package Combination.backtrack_uses;

public class Product {

    String code;
    String name;
    double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return code + ", " + name + ", " + (int) price + "\n";
    }

}
