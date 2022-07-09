public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 34, 1, 1.0, "рубль");
        basket.add("Baguette", 1, 2, 0.8, "евро");
        basket.add("Chocolate", 32, 1, 0.2, "сом");
        basket.add("Egg", 10, 12, 0.1, "сом");
        basket.add("Tuna", 4, 1, 1.0, "доллар");
        basket.print("Milk");
    }
}
