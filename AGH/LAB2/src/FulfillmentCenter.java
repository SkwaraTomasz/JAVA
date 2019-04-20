import java.util.Comparator;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
public class FulfillmentCenter extends Item {
    String name;
    double maxCapacity;
    double actualCapacity;
    private List<Item> itemList;
    FulfillmentCenter(double maxCapacity, String name){
        this.name=name;
        this.maxCapacity=maxCapacity;
        itemList = new ArrayList();
        this.actualCapacity=0;
    }
    public String getName(){
        return name;
    }
    public double getActualCapacity(){
        return actualCapacity;
    }
    public void addProduct(Item item){
        if(actualCapacity+item.weight<=maxCapacity) {
            if (this.search(item.getName())!=null) {
                item.amount++;
                actualCapacity += item.weight;
            } else {
                itemList.add(item);
                actualCapacity += item.weight;
            }
            System.out.println("Added: " + item.name);
        }

        else{
            System.err.println("Not enough space in magazine!");

        }
    }
    public void getProduct(Item item){
        if(amount>1){
            item.amount--;
            actualCapacity-=item.weight;
        }
        else{
            amount=0;
            actualCapacity-=item.weight;
            itemList.remove(item);
        }
        System.out.println("Get!");
    }
    public void removeProduct(Item item){
        if(item.amount>0) {
            actualCapacity -= (amount * item.weight);
            amount = 0;
            itemList.remove(item);
            System.out.println("Removed!");
        }
        else System.out.println("You don't have this item");
    }
    public int countByCondition(ItemCondition condition) {
        int count =0;
        for(Item temp_product:itemList){
            if(temp_product.getItemCondition()==condition)
                count+=temp_product.getAmount();
        }
        return count;
    }
    public Item search(String name){
        Item temp=new Item(name, ItemCondition.NEW,0, 0);
        for (Item temp_product : itemList){
            if(temp.compareTo(temp_product)==0){
                return temp_product;
            }
        }
        return null;
    }
    public List<Item> searchPartial(String name){
        List <Item> temp=new ArrayList();
        for(Item temp_product:itemList){
            if(temp_product.getName().contains(name))
                temp.add(temp_product);
        }
        return temp;
    }

    public void summary(){
        System.out.println("Warehouse name: "+name);
        System.out.println("Warehouse used capacity: "+actualCapacity);
        System.out.println("Warehouse max capacity: "+maxCapacity);
        int i=1;
        for(Item temp_product:itemList){
            System.out.print(i+". ");
            temp_product.print();
            i++;
        }
    }
    public List<Item> sortByName(){
        Collections.sort(itemList);
        return itemList;
    }

    public List<Item> sortByAmount(){
        Collections.sort(itemList,new Comparator<Item>(){
            @Override
            public int compare(Item item1,Item item2){
                return Integer.compare(item2.getAmount(),item1.getAmount());
            }
        });
        return itemList;
    }

    public Item max() {
        Item temp = Collections.max(itemList, new Comparator<Item>() {
                    @Override
                    public int compare(Item item1, Item item2) {
                        return Integer.compare(item1.getAmount(),item2.getAmount());
                    }
                }
        );
        return temp;
    }




}
