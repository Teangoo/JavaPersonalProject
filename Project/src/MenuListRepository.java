import java.util.ArrayList;
import java.util.List;

public class MenuListRepository {
    static List<MenuListDTO> menuList = new ArrayList<>(); // 메뉴 리스트

    public void save(MenuListDTO list) {
        menuList.add(list);
    }

    public MenuListDTO getById(String foodname) {
        MenuListDTO list = null;
        for (int i = 0; i < menuList.size(); i++) {
            if(foodname.equals(menuList.get(i).getFoodName())){
                list = menuList.get(i);
            }
        }
        return list;
    }

    public void delete(MenuListDTO list) {
        menuList.remove(list);
    }

    public List<MenuListDTO> findAll() {
        return menuList;
    }

    public List<MenuListDTO> restaurantMenuListAll(String restaurantname) {
        List<MenuListDTO> reList = new ArrayList<>();
        for (int i = 0; i < menuList.size(); i++) {
            if (restaurantname.equals(menuList.get(i).getRestaurantName())) {
                reList.add(menuList.get(i));
            }
        }
        return  reList;
    }

    public void remove(List<MenuListDTO> list) {
        for (int i = 0; i < menuList.size(); i++) {
            for (int y = 0; y<list.size();y++) {
                if (list.get(y).equals(menuList.get(i))) {
                    menuList.remove(menuList.get(i));
                }
            }

        }
    }


    public List<MenuListDTO> findByName(String mn) {
        List<MenuListDTO> list = new ArrayList<>();
        for (int i=0; i< menuList.size();i++){
            if (mn.equals(menuList.get(i).getFoodName())) {
                list.add(menuList.get(i));
            }
        }
        return list;
    }

    public boolean namepass(String name, String foodname) {
        boolean pass = false;
        for (int i = 0; i < menuList.size(); i++) {
            if(name.equals(menuList.get(i).getRestaurantName()) && foodname.equals(menuList.get(i).getFoodName())){
                pass = true;
            }
        }
        return pass;
    }
}
