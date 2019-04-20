import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class FulfillmentCenterContainer{
    private Map<String, FulfillmentCenter> warehouses;
    FulfillmentCenterContainer(){
        warehouses=new HashMap();
    }

    public void addCenter(String name, double maxCapacity){
        warehouses.put(name, new FulfillmentCenter(maxCapacity,name));
        System.out.println("Added : "+name);
    }
    public void addCenter(FulfillmentCenter warehouse) {
        warehouses.put(warehouse.getName(), warehouse);
    }

    public void removeCenter(String name){
        warehouses.remove(name);
        System.out.println("Removed : "+name);
    }

    public List<FulfillmentCenter> findEmpty(){
        List<FulfillmentCenter> temp=new ArrayList();
        for(String key: warehouses.keySet()){
            if(warehouses.get(key).getActualCapacity()==0)
                temp.add(warehouses.get(key));
        }
        return temp;
    }

    public void summary(){
        System.out.println("Warehouse list: ");
        for(String key:warehouses.keySet()){
            warehouses.get(key).summary();
        }
    }



}
