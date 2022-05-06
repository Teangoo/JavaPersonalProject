import java.util.List;
import java.util.Scanner;

public class rootService {
    Scanner scan = new Scanner(System.in);
    RestaurantRepository restaurantrepository = new RestaurantRepository();
    ReviewRepository reviewrepository = new ReviewRepository();
    MenuListRepository menulistrepository = new MenuListRepository();

    static Long restaurantId =0L; //가게관리번호
    static Long menuId = 0L; //메뉴관리번호
    static Long reviewId = 0L; // 리뷰관리번호
    static int rootpwdf = 0000; //관리자 비밀번호(초기비밀번호)
    static int rootpwd = 0000;

    String restaurantName,foodName = null;
    Long foodPrice = null;

    public void rootMode() {
        System.out.println("관리자 모드입니다.");
        System.out.print("비밀번호를 입력하세요(초기0000) : ");
        int pwdpass = scan.nextInt();scan.nextLine();
        if (pwdpass == rootpwdf) {
            System.out.println("비밀번호 변경이 필요합니다.");
            System.out.println("변경하실 비밀번호를 변경하세요.");
            System.out.print(" > ");
            int password = scan.nextInt();
            scan.nextLine();
            rootpwd = password;
            rootpwdf= 0;
            System.out.println("비밀번호가 변경되었습니다.");
            System.out.print("비밀번호를 입력하세요(초기0000) : ");
            pwdpass = scan.nextInt();scan.nextLine();
        }
        boolean run = true;
            if (pwdpass == rootpwd) {
                while (run) {
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("1:식당추가 | 2: 식당삭제 | 3: 메뉴추가 | 4:메뉴삭제 | 5: 리뷰 관리 | 6: 비밀번호 변경| 7:종료 ");
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.print(" > ");
                    int selectnember = scan.nextInt();
                    scan.nextLine();

                    if (selectnember == 1) {
                        System.out.println("##### 식당추가 서비스입니다. #####");
                        String name, address, phone;
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
                        scan.nextLine();

                        RestaurantDTO list = new RestaurantDTO(++restaurantId, name, address, phone, distance);
                        restaurantrepository.restaurantList(list);

                    } else if (selectnember == 2) {
                        System.out.println("##### 식당삭제 서비스입니다. #####");
                        String restaurantName;
                        System.out.println("삭제하실 식당이름을 입력하세요.");
                        System.out.print(" > ");
                        restaurantName = scan.nextLine();
                        RestaurantDTO restaurantNameResult = restaurantrepository.findById(restaurantName);
                        if (restaurantNameResult != null) {
                            System.out.println("---------------------------------------------------------");
                            System.out.println("삭제하실 식당은 다음과 같습니다.");
                            System.out.println(restaurantNameResult);
                            System.out.println("---------------------------------------------------------");

                            System.out.println("식당과 함께 삭제되는 메뉴들은 다음과 같습니다.");
                            List<MenuListDTO> list = menulistrepository.restaurantMenuListAll(restaurantName);
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println(list.get(i));
                            }
                            System.out.println("---------------------------------------------------------");

                            System.out.println("식당을 삭제하시면 메뉴리스트도 함께 삭제됩니다.");
                            System.out.println("정말 삭제하시겠습니까? 1: 삭제 2: 아니요");
                            System.out.print(" > ");
                            int input = scan.nextInt();
                            scan.nextLine();

                            if (input == 1) {
                                restaurantrepository.remove(restaurantNameResult);
                                menulistrepository.remove(list);
                                System.out.println("식당과 메뉴가 삭제되었습니다.");
                            }
                        } else {
                            System.out.println("입력하신 식당과 일치하는 식당이 없습니다.");
                        }

                    } else if (selectnember == 3) {
                        System.out.println("##### 메뉴추가 서비스입니다. #####");
                        System.out.println("메뉴를 추가하실 가게이름을 입력하세요.");
                        System.out.print(" > ");
                        restaurantName = scan.nextLine();

                        RestaurantDTO restaurantnameresult = restaurantrepository.findById(restaurantName);
                        if (restaurantnameresult != null) {
                            boolean menurun = true;
                            while (menurun) {
                                System.out.println("음식이름을 작성하세요.");
                                System.out.print(" > ");
                                foodName = scan.nextLine();
                                System.out.println("가격을 입력하세요.");
                                System.out.print(" > ");
                                foodPrice = scan.nextLong();
                                scan.nextLine();
                                MenuListDTO list = new MenuListDTO(++menuId, restaurantName, foodName, foodPrice);
                                menulistrepository.save(list);
                                System.out.println("더 추가하실거면 1번을 메뉴로 돌아가시려면 2번을 눌러주세요");
                                System.out.print(" > ");
                                int input = scan.nextInt();
                                scan.nextLine();
                                if (input == 2) {
                                    menurun = false;
                                }
                            }
                        } else {
                            System.out.println("해당하는 가게가 없습니다.");
                        }

                    } else if (selectnember == 4) {
                        System.out.println("##### 메뉴삭제 서비스입니다. #####");
                        String restaurantname, foodname;

                        System.out.println("메뉴를 삭제하실 가게이름을 입력하세요.");
                        System.out.print(" > ");
                        restaurantname = scan.nextLine();

                        RestaurantDTO restaurantNameResult = restaurantrepository.findById(restaurantname);
                        if (restaurantNameResult != null) {
                            boolean menuRun = true;
                            while (menuRun) {
                                System.out.println("삭제하실 메뉴이름을 작성하세요.");
                                System.out.print(" > ");
                                foodname = scan.nextLine();
                                MenuListDTO list = menulistrepository.getById(foodname);

                                if (list != null) {
                                    System.out.println("삭제하실 메뉴는 다음과 같습니다.");
                                    System.out.println(list);

                                    System.out.println("정말삭제하시겠습니까? 1:예 2:아니요");
                                    System.out.print(" > ");
                                    int input = scan.nextInt();
                                    scan.nextLine();

                                    if (input == 1) {
                                        menulistrepository.delete(list);
                                        System.out.println("삭제되었습니다.");
                                    }
                                } else {
                                    System.out.println("삭제하실 메뉴이름과 일치하는 메뉴가 없습니다.");
                                }

                                System.out.println("더 삭제하실거면 1번을 메뉴로 돌아가시려면 2번을 눌러주세요");
                                System.out.print(" > ");
                                int input = scan.nextInt();
                                scan.nextLine();
                                if (input == 2) {
                                    menuRun = false;
                                }
                            }
                        } else {
                            System.out.println("해당하는 가게가 없습니다.");
                        }

                    } else if (selectnember == 5) {
                        System.out.println("##### 리뷰 삭제 서비스 입니다. #####");
                        System.out.println("1: 전체가게 리뷰에서 선택삭제 | 2:특정 회원의 리뷰삭제 | 3: 특정 가게의 리뷰삭제 ");
                        System.out.print(" > ");
                        int input = scan.nextInt();scan.nextLine();
                        if(input == 1){
                            List<ReviewDTO> list = reviewrepository.reviewListAll();
                            System.out.println("전체가게에 대한 리뷰는 다음과 같습니다.");
                            for (int i = 0; i < list.size();i++){
                                System.out.println(list.get(i));
                            }
                            boolean delrun = true;
                            while(delrun) {
                                System.out.println("리스트중 삭제하실 리뷰의 관리번호를 입력하세요.");
                                Long delreview = scan.nextLong();
                                scan.nextLine();
                                reviewrepository.delete(delreview);
                                System.out.println("리뷰가 삭제되었습니다.");
                                System.out.println("더 삭제하시려면 1번을 메인으로 가시려면 2번을 입력하세요.");
                                System.out.print(" > ");
                                int select = scan.nextInt();scan.nextLine();
                                if(select == 2){
                                    delrun = false;
                                }
                            }
                        }else if(input == 2){
                            //특정 회원의 리뷰삭제
                            System.out.println("회원의 아이디를 입력하세요.");
                            System.out.print(" > ");
                            String memid = scan.nextLine();
                            MemberRepository memberRepository = new MemberRepository();
                            boolean pass = memberRepository.findById(memid);
                            if(pass) {
                                String nick = memberRepository.nickname(memid);
                                List<ReviewDTO> list = reviewrepository.nicklist(nick);
                                System.out.println("회원이 작성한 리뷰는 다음과 같습니다.");
                                for (int i = 0; i < list.size(); i++) {
                                    System.out.println(list.get(i));
                                }
                                boolean delrun = true;
                                while (delrun) {
                                    System.out.println("삭제하실 리뷰의 관리번호를 입력하세요.");
                                    System.out.print(" > ");
                                    Long delreview = scan.nextLong();
                                    scan.nextLine();
                                    reviewrepository.delete(delreview);
                                    System.out.println("리뷰가 삭제되었습니다.");
                                    System.out.println("더 삭제하시려면 1번을 메인으로 가시려면 2번을 입력하세요.");
                                    System.out.print(" > ");
                                    int select = scan.nextInt();
                                    scan.nextLine();
                                    if (select == 2) {
                                        delrun = false;
                                    }
                                }
                            }else {
                                System.out.println("일치하는 아이디가 없습니다.");
                            }

                        }else if(input == 3){
                            //특정 가게의 리뷰삭제
                            System.out.println("가게의 이름을 입력하세요.");
                            String restaurantname = scan.nextLine();
                            RestaurantDTO pass = restaurantrepository.findById(restaurantname);
                            if(pass != null){
                                System.out.println("입력하신 가게에 달린 리뷰들은 다음과 같습니다.");
                                List<ReviewDTO> list = reviewrepository.restaurantNameReview(pass.getRestaurantName());
                                for (int i = 0; i < list.size(); i++) {
                                    System.out.println(list.get(i));
                                }
                                boolean delrun = true;
                                while (delrun) {
                                    System.out.println("삭제하고 싶은 리뷰의 관리번호를 입력하세요.");
                                    Long delreview = scan.nextLong();
                                    scan.nextLine();
                                    reviewrepository.delete(delreview);
                                    System.out.println("리뷰가 삭제되었습니다.");
                                    System.out.println("더 삭제하시려면 1번을 메인으로 가시려면 2번을 입력하세요.");
                                    System.out.print(" > ");
                                    int select = scan.nextInt();
                                    scan.nextLine();
                                    if (select == 2) {
                                        delrun = false;
                                    }
                                }

                            }else{
                                System.out.println("일치하는 가게가 없습니다.");
                            }
                        }

                    } else if (selectnember == 6) {
                        System.out.println("관리자 비밀번호 변경 서비스 입니다.");
                        System.out.println("기존 비밀번호를 입력하세요.");
                        System.out.print(" > ");
                        int pass = scan.nextInt();scan.nextLine();
                        if(pass == rootpwd){
                            System.out.println("변경하실 비밀번호를 입력하세요");
                            System.out.print(" > ");
                            int passre
                            rootpwd = pass;
                            System.out.println("비밀번호 변경이 완료되었습니다.");
                        }else {
                            System.out.println("비밀번호가 틀립니다.");
                        }


                    } else if (selectnember == 7) {
                        System.out.println("관리자모드를 종료합니다.");
                        run = false;

                    }
                }
            } else {
                System.out.println("관리자 비밀번호가 틀립니다.");
            }
    }
}
