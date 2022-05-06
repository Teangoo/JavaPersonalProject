import java.util.List;
import java.util.Scanner;

public class RestaurantService {
    RestaurantRepository restaurantrepository = new RestaurantRepository();
    ReviewRepository reviewrepository = new ReviewRepository();
    MenuListRepository menuListRepository = new MenuListRepository();
    MemberService memberServer = new MemberService();
    MemberRepository memberRepository = new MemberRepository();
    Scanner scan = new Scanner(System.in);
    Long reviewid = 0L; // 리뷰관리번호

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
        boolean run = true;
        while (run) {
            System.out.println("1: 가게 리뷰 확인 | 2: 리뷰 작성 | 3: 리뷰 삭제 | 4: 종료 ");
            System.out.print(" > ");
            int select = scan.nextInt();
            scan.nextLine();
            if(select == 1){
                System.out.println("리뷰 확인 서비스 입니다.");
                System.out.println("리뷰를 확인 하실 가게 이름을 입력하세요.");
                System.out.print(" > ");
                String name = scan.nextLine();
                RestaurantDTO pass = restaurantrepository.findById(name);
                if(pass != null) {
                    List<ReviewDTO> list = reviewrepository.reviewAll(name);
                    System.out.println("입력하신 가게에 리뷰는 다음과 같습니다.");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }
                    int avgScore = reviewrepository.avgScore(list);
                    System.out.println("가게에 대한 평점은 : "+ avgScore +"입니다.");

                }else{
                    System.out.println("입력하신 가게와 일치하는 가게가 없습니다.");
                }

            }else if(select == 2){
                System.out.println("리뷰 작성 서비스 입니다.");
                System.out.println("로그인이 필요합니다.");
                System.out.println("1:로그인 2:회원가입");
                System.out.print(" > ");
                int selectlogin = scan.nextInt();scan.nextLine();
                if(selectlogin == 1){
                    System.out.println("아이디를 입력하세요,");
                    System.out.print(" > ");
                    String id = scan.nextLine();
                    System.out.println("비밀번호를 입력하세요.");
                    System.out.print(" > ");
                    String pwd = scan.nextLine();
                    boolean idpwdpass = memberRepository.idpwdpass(id,pwd);
                    if(idpwdpass){
                        System.out.println("리뷰를 작성하실 가게 이름을 입력하세요.");
                        System.out.print(" > ");
                        String name = scan.nextLine();
                        RestaurantDTO pass = restaurantrepository.findById(name);
                        if(pass != null){
                            System.out.println("리뷰를 작성하실 메뉴의 이름을 입력하세요");
                            System.out.print(" > ");
                            String foodname = scan.nextLine();
                            boolean foodnamepass = menuListRepository.namepass(name,foodname);
                            if(foodnamepass){
                                System.out.println("리뷰내용을 작성하세요.");
                                System.out.print(" > ");
                                String reviewContents = scan.nextLine();
                                System.out.println("평점을 입력하세요(0점~5점)");
                                System.out.print(" > ");
                                int score = scan.nextInt();scan.nextLine();
                                String nick = memberRepository.nickname(id);
                                ReviewDTO review = new ReviewDTO(++reviewid,name,foodname,nick,reviewContents,score);
                                reviewrepository.save(review);
                                System.out.println("리뷰가 등록되었습니다.");

                            }else{
                                System.out.println("일치하는 메뉴가 없습니다.");
                            }

                        }else {
                            System.out.println("입력하신 가게와 일치하는 가게가 없습니다.");
                        }

                    }else{
                        System.out.println("아이디 또는 비밀번호가 틀립니다.");
                    }
                }else if(selectlogin == 2){
                    memberServer.save();
                }


            }else if(select == 3){
                System.out.println("리뷰삭제 서비스 입니다.");
                System.out.println("로그인이 필요합니다.");
                System.out.println("아이디를입력하세요.");
                System.out.print(" > ");
                String id = scan.nextLine();
                System.out.println("비밀번호를 입력하세요.");
                System.out.println(" > ");
                String pwd = scan.nextLine();

                boolean idpwdpass = memberRepository.idpwdpass(id,pwd);
                if(idpwdpass){
                    System.out.println("로그인되었습니다.");
                    System.out.println("회원님께서 작성하신 리뷰리스트 입니다.");
                    String nick = memberRepository.nickname(id);
                    List<ReviewDTO> list = reviewrepository.idReviewAll(nick);
                    for (int i=0; i<list.size(); i++){
                        System.out.println(list.get(i));
                    }
                    boolean delrun = true;
                    while (delrun) {
                        System.out.println("삭제하실 리뷰의 관리번호를 입력하세요.");
                        System.out.println(" > ");
                        Long delid = scan.nextLong();scan.nextLine();
                        reviewrepository.delete(delid);
                        System.out.println("삭제되었습니다.");
                        System.out.println("리뷰를 더 삭제하시려면 1번을 메인메뉴로 돌아가시려면 2번을 입력하세요.");
                        int selectdel = scan.nextInt();scan.nextLine();
                        if (selectdel==2){
                            delrun = false;
                        }
                    }

                }else{
                    System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
                }

            }else if(select == 4){
                System.out.println("메인메뉴로 돌아갑니다.");
                run = false;
            }
        }
    }

    public void memsave() {
        System.out.println("회원가입 및 회원 탈퇴서비스 입니다.");
        boolean run = true;
        while (run) {
        System.out.println("1: 회원가입 | 2:회원탈퇴 | 3: 종료");
        System.out.print("원하시는 서비스를입력하세요 > ");
        int input = scan.nextInt();

            if (input == 1) {
                // 회원가입
                memberServer.save();

            } else if (input == 2) {
                //회원탈퇴
                memberServer.quit();

            } else if (input == 3) {
                System.out.println("메인메뉴로 돌아갑니다.");
                run = false;
            }
        }
    }
}
