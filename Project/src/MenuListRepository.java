import java.util.ArrayList;
import java.util.List;

public class MenuListRepository {
    List<MenuListDTO> ml = new ArrayList<>();

    public void save(MenuListDTO list) {
        ml.add(list);
    }
}
