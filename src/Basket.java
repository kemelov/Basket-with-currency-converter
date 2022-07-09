public class Basket {
    public static void main(String[] args) {
        Basket b = new Basket();
        System.out.println(b);
    }

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private double totalWeight = 0;
    private int priceLimit;
    private double weightLimit;
    public String currency;
    int dollarToSom;
    int euroToSom;
    int roubleToSom;
    int som = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.priceLimit = 1000000;
        this.weightLimit = 1000000;
    }

    public Basket(int priceLimit, double weightLimit) {
        this();
        this.priceLimit = priceLimit;
        this.weightLimit = weightLimit;
    }

    public Basket(String items, int totalPrice, double totalWeight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1,1);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= priceLimit) {
            error = true;
        }

        if (totalWeight + count * weight >= weightLimit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }
    }

    public void add(String name, int price, int count, double weight, String currency) {
        items = items + "\n" + name + " - " +weight + " кг. - "+
                count + " шт. - "+ price + " " + currency + "";
        switch (currency) {
            case "доллар":
                price = price * 98 * count;
                this.dollarToSom = price;
                items = items + " (" +dollarToSom+ " сом)";
                break;
            case "евро":
                price = price * 108 * count;
                this.euroToSom = price;
                items = items + " (" +euroToSom+ " сом)";
                break;
            case "рубль":
                price = price / 2 * count;
                this.roubleToSom = price;
                items = items + " (" +roubleToSom+ " сом)";
                break;
            case "сом":
                price = price * count;
                this.som = som + price;
                items = items + " (" +price+ " сом)";
                break;
        }
        totalPrice = totalPrice + price;
        totalWeight = totalWeight + count * weight;
        this.currency = currency;
        //this.price = price;//
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Общая стоимость корзины - " + getTotalPrice() + " сом" + " (" +roubleToSom+ " + " +euroToSom+ " + " +som+ " + " +dollarToSom+ ")");
            System.out.println("Общий вес корзины - " + getTotalWeight() + " кг");
            System.out.println();
        }
    }
}
