import java.util.List;
import java.util.Scanner;

public class RestaurantService {
    RestaurantRepository restaurantrepository = new RestaurantRepository();
    ReviewRepository reviewrepository = new ReviewRepository();
    MenuListRepository menuListRepository = new MenuListRepository();
    Scanner scan = new Scanner(System.in);

    public void restaurantlist() {
        List<RestaurantDTO> listAll = restaurantrepository.findAll();
        for (int i=0; i< listAll.size(); i++) {
            System.out.println(listAll.get(i));
        }
    }


    public void findByRestaurant() {

            System.out.println("식당검색 서비스입니다.");
            System.out.println("검색하실 식당의 이름을 입력하세요.");
            System.out.print(" > ");
            String rn = scan.nextLine();
            RestaurantDTO rnpass = restaurantrepository.findById(rn);
            if (rnpass != null) {
                List<MenuListDTO> nameMenu = menuListRepository.restaurantMenuListAll(rn);
                System.out.println("검색하신 " + rn + " 식당의 메뉴는 아래와 같습니다.");
                for (int i = 0; i < nameMenu.size(); i++) {
                    System.out.println(nameMenu.get(i));
                }
            } else {
                System.out.println("검색하신 식당이 없습니다.");
            }
    }

    public void findByMenu() {

            System.out.println("음식검색 서비스입니다.");
            System.out.println("검색하실 음식의 이름을 입력하세요.");
            System.out.print(" > ");
            String mn = scan.nextLine();
            List<MenuListDTO> mnpass = menuListRepository.findByName(mn);
            if (mnpass != null) {
                List<RestaurantDTO> rn = restaurantrepository.findByname(mnpass);
                System.out.println("검색하신 " + mn + " 음식을 파는 가게 정보는 다음과 같습니다.");
                for (int i = 0; i < rn.size(); i++) {
                    System.out.println(rn.get(i));
                }
            } else {
                System.out.println("검색하신 음식을 파는 가게가 없습니다.");
            }
    }
}
