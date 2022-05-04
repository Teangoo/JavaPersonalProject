import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    List<RestaurantDTO> restaurantList = new ArrayList<>(); // 식당리스트

    public void restaurantList(RestaurantDTO list) {
        restaurantList.add(list);
    }


    public RestaurantDTO findById(String restaurantname) {
        RestaurantDTO pass = null;
    for (int i = 0; i<restaurantList.size();i++){
        if(restaurantname.equals(restaurantList.get(i).getRestaurantName())){
            pass = restaurantList.get(i);
        }
    }
    return pass;
    }

    public List<RestaurantDTO> findAll() {
        return restaurantList;
    }

    public void remove(RestaurantDTO restaurantNameResult) {
        restaurantList.remove(restaurantNameResult);
    }
}
