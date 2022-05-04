import java.util.Scanner;

public class rootService {
    Scanner scan = new Scanner(System.in);
    RestaurantRepository rr = new RestaurantRepository();
    ReviewRepository rev = new ReviewRepository();
    MenuListRepository mlr = new MenuListRepository();

    static Long restaurantId =0L; //가게관리번호
    static Long menuId = 0L; //메뉴관리번호
    static Long reviewId = 0L; // 리뷰관리번호

    String restaurantname,foodname = null;
    Long foodprice = null;

    public void rootmode() {
        int pwd = 1234;//관리자 비밀번호
        System.out.println("관리자 모드입니다.");
        System.out.print("비밀번호를 입력하세요 : ");
        int pwdpass = scan.nextInt();
        boolean run = true;
        if(pwdpass == pwd){
            while (run) {
                System.out.println("-------------------------------------------------------------");
                System.out.print("1:식당추가 | 2: 메뉴추가 | 3:메뉴삭제 | 4: 리뷰 관리 | 5:식당삭제 | 6:종료 ");
                System.out.println("-------------------------------------------------------------");
                int selectnember = scan.nextInt();
                if (selectnember == 1) {
                    System.out.println("##### 식당추가 서비스입니다. #####");
                    String name,address,phone;
                    int distance = 0;
                    System.out.println("식당이름을 입력하세요.");
                    System.out.print(" > ");
                    name = scan.nextLine();

                    System.out.println("식당주소를 입력하세요.");
                    System.out.print(" > ");
                    address = scan.nextLine();

                    System.out.println("식당전화번호를 입력하세요.");
                    System.out.print(" > ");
                    phone = scan.nextLine();

                    System.out.println("거리(Km)를 입력하세요");
                    System.out.print(" > ");
                    distance = scan.nextInt();

                    RestaurantDTO list = new RestaurantDTO(++restaurantId,name,address,phone,distance);
                    rr.restaurantList(list);

                } else if (selectnember == 2) {
                    System.out.println("##### 메뉴추가 서비스입니다. #####");

                    System.out.println("메뉴를 추가하실 가게이름을 입력하세요.");
                    restaurantname = scan.nextLine();
                   boolean restaurantnameresult = rr.findById(restaurantname);
                    if (restaurantnameresult){
                        boolean menurun = true;
                        while (menurun) {
                            System.out.println("음식이름을 작성하세요.");
                            System.out.print(" > ");
                            foodname = scan.nextLine();
                            System.out.println("가격을 입력하세요.");
                            System.out.print(" > ");
                            foodprice = scan.nextLong();
                            MenuListDTO list = new MenuListDTO(++menuId,restaurantname,foodname,foodprice);
                            mlr.save(list);
                            System.out.println("더 추가하실거면 1번을 메뉴로 돌아가시려면 2번을 눌러주세요");
                            System.out.print(" > ");
                            int input = scan.nextInt();
                            if (input == 2) {
                                menurun = false;
                            }
                        }
                    }else{
                        System.out.println("해당하는 가게가 없습니다.");
                    }

                } else if (selectnember == 3) {
                    System.out.println("##### 메뉴삭제 서비스입니다. #####");
                    String restaurantname,foodname;
                    Long foodprice;
                    System.out.println("메뉴를 추가하실 가게이름을 입력하세요.");
                    restaurantname = scan.nextLine();
                    boolean restaurantnameresult = rr.findById(restaurantname);
                    if (restaurantnameresult){
                        boolean menurun = true;
                        while (menurun) {
                            System.out.println("음식이름을 작성하세요.");
                            System.out.print(" > ");
                            foodname = scan.nextLine();
                            System.out.println("가격을 입력하세요.");
                            System.out.print(" > ");
                            foodprice = scan.nextLong();
                            MenuListDTO list = new MenuListDTO(++menuId,restaurantname,foodname,foodprice);
                            mlr.save(list);
                            System.out.println("더 추가하실거면 1번을 메뉴로 돌아가시려면 2번을 눌러주세요");
                            System.out.print(" > ");
                            int input = scan.nextInt();
                            if (input == 2) {
                                menurun = false;
                            }
                        }
                    }else{
                        System.out.println("해당하는 가게가 없습니다.");
                    }

                }else if (selectnember == 4){


                } else if (selectnember == 5){
                    System.out.println("관리자모드를 종료합니다.");
                    run = false;
                    scan.close();
                }
            }
        }else{
            System.out.println("비밀번호가 틀립니다.");
        }

    }
}
