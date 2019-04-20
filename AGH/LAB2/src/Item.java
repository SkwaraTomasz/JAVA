public class Item implements Comparable<Item> {
    String name;
    ItemCondition condition;
    double weight;
    Integer amount;

    Item() {
        this.name = "null";
        this.condition = condition;
        this.weight = 0;
        this.amount = 0;
    }
    Item(String name, ItemCondition condition,double weight, Integer amount) {
        this.name = name;
        this.condition = condition;
        this.weight = weight;
        this.amount = amount;
    }
    public void print(){
        System.out.println("Product: "+name+", Condition: "+condition+", Weight: "+weight+", Amount: "+amount);
    }
    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }
    public ItemCondition getItemCondition() {
        return condition;
    }
    public boolean compareToSpecific(Item item)
    {
        return this.name == item.getName() && this.condition == this.condition
                && this.weight == item.weight;
    }
    public int addAmount(int amount) {
        return this.amount += amount;
    }
    @Override
    public int compareTo(Item item) {
        return name.compareTo(item.name);
    }
}
