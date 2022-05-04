import java.util.List;

public class RestaurantService {
    RestaurantRepository restaurantrepository = new RestaurantRepository();
    ReviewRepository reviewrepository = new ReviewRepository();
    MenuListRepository menuListRepository = new MenuListRepository();

    public void restauranglist() {
        List<RestaurantDTO> listAll = restaurantrepository.findAll();
        for (int i=0; i< listAll.size(); i++) {
            System.out.println(listAll.get(i));
        }
    }


}
