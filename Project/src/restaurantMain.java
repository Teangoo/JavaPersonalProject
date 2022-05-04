import java.util.Scanner;

public class restaurantMain {
    public static void main(String[] args) {

        int selectnumber = 0;
        boolean run = true;
        Scanner scan = new Scanner(System.in);
        RestaurantService restaurantService = new RestaurantService();

        while(run) {
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆식당의민족 서비스 입니다.☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
                System.out.println("※※주의※※ 해당서비스는 인천일보아카데미를 기준으로 합니다.");
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("1:식당 리스트 | 2:식당 검색 메뉴 확인 | 3: 메뉴 검색 식당 리스트 | 4. 식당 리뷰 | 5. 식당 예약 | 6.종료 ");
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("원하시는 서비스를 선택하세요.");
                System.out.print("선택 > ");
                selectnumber = scan.nextInt();
                if (selectnumber == 1) {
                    //식당 리스트
                    restaurantService.restaurantlist();

                } else if (selectnumber == 2) {
                    //검색한 식당의 메뉴 확인
                    restaurantService.findByRestaurant();

                } else if (selectnumber == 3) {
                    //메뉴 검색 식당 리스트
                    restaurantService.findByMenu();

                } else if (selectnumber == 4) {
                    //식당 리뷰확인 및 리뷰 작성

                } else if (selectnumber == 5) {
                    //식당 음식 예약 주문

                } else if (selectnumber == 6) {
                    //서비스 종료
                    System.out.println("서비스를 종료합니다.");
                    run = false;
                    scan.close();

                } else if (selectnumber == 7) {
                    //관리자 기능(숨겨진 기능)
                    rootService ros = new rootService();
                    ros.rootMode();
                }

            }

    }
}
