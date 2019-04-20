import java.util.List;
public class Main {
    public static void main(String [] args){

        Item jeans=new Item("Jeans", ItemCondition.NEW,10,1);
        Item blouse=new Item("Blouse", ItemCondition.REFURBISHED,50,1);
        Item jacket=new Item("Jacket", ItemCondition.USED, 30,1);

        jeans.print();
        blouse.print();
        jacket.print();

        FulfillmentCenter clothesWarehouse = new FulfillmentCenter(100,"clothesWarehouse");

        System.out.println("|| Add products ||");
        clothesWarehouse.addProduct(jeans);
        clothesWarehouse.addProduct(blouse);
        clothesWarehouse.addProduct(jacket);

        clothesWarehouse.summary();
        System.out.println("|| Adding next products ||");
        clothesWarehouse.addProduct(jeans);
        clothesWarehouse.summary();
        clothesWarehouse.addProduct(jeans);
        clothesWarehouse.summary();

        System.out.println("|| Search partial ||");
        List<Item> temp=clothesWarehouse.searchPartial("J");
        for(Item tmp:temp) tmp.print();

        System.out.println("|| Count items ||");
        System.out.println("Items: "+clothesWarehouse.countByCondition(ItemCondition.USED));

        System.out.println("|| Sort by name ||");
        clothesWarehouse.sortByName();
        clothesWarehouse.summary();

        System.out.println("|| Sort by amount ||");
        clothesWarehouse.sortByAmount();
        clothesWarehouse.summary();

        System.out.println("|| Item max amount ||");
        clothesWarehouse.max().print();

        System.out.println("|| Add warehouse to centre ||");
        FulfillmentCenterContainer warehouses=new FulfillmentCenterContainer();
        warehouses.addCenter(clothesWarehouse);
        warehouses.summary();

        System.out.println("|| Add empty warehouse to centre ||");
        warehouses.addCenter("Empty",200);
        warehouses.summary();

        System.out.println("|| Remove warehouse||");
        warehouses.removeCenter(warehouses.findEmpty().get(0).getName());

        System.out.println("|| Get product ||");
        clothesWarehouse.getProduct(jeans);
        clothesWarehouse.summary();
        clothesWarehouse.getProduct(jeans);
        clothesWarehouse.summary();

        System.out.println("|| Remove product ||");
        clothesWarehouse.removeProduct(blouse);
        clothesWarehouse.summary();












    }
}
