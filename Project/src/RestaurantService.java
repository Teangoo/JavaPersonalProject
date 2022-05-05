import java.util.List;
import java.util.Scanner;

public class RestaurantService {
    RestaurantRepository restaurantrepository = new RestaurantRepository();
    ReviewRepository reviewrepository = new ReviewRepository();
    MenuListRepository menuListRepository = new MenuListRepository();
    MemberService memberServer = new MemberService();
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

    public void review() {

        System.out.println("리뷰 서비스입니다.");
        System.out.println("이용하실 서비스를 선택해주세요.");
        System.out.println("1: 가게 리뷰 확인 2: 리뷰 작성 3: 리뷰 삭제 4: 종료 ");
        System.out.println(" > ");
    }

    public void memsave() {
        System.out.println("회원가입 및 회원 탈퇴서비스 입니다.");
        System.out.println("1: 회원가입 | 2:회원탈퇴 | 3: 종료");
        int input = scan.nextInt();
        boolean run = true;
        while (run) {
            if (input == 1) {
                // 회원가입
                memberServer.save();

            } else if (input == 2) {
                //회원탈퇴

            } else if (input == 3) {
                run = false;
            }
        }
    }
}
