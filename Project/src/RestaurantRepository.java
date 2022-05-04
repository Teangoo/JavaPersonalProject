import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    List<RestaurantDTO> rrlist = new ArrayList<>();

    public void restaurantList(RestaurantDTO list) {
        rrlist.add(list);
    }


    public boolean findById(String restaurantname) {
    boolean pass = false;
    for (int i = 0; i<rrlist.size();i++){
        if(restaurantname.equals(rrlist.get(i).getRestaurangName())){
            pass = true;
        }
    }
    return pass;
    }
}
