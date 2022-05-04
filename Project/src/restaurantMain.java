import java.util.Scanner;

public class restaurantMain {
    public static void main(String[] args) {

        int selectnumber = 0;
        boolean run = true;
        Scanner scan = new Scanner(System.in);
        RestaurantService rs = new RestaurantService();
        while(run){
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("인천일보아카데미 주변 식당 서비스 입니다.");
            System.out.println("1:주변 식당 리스트 | 2:식당 검색 메뉴 확인 | 3: 메뉴 검색 식당 리스트 | 4. 식당 리뷰 | 5.종료 ");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println(" 원하시는 서비스를 선택하세요.");
            System.out.print("선택 > ");
            selectnumber=scan.nextInt();
            if(selectnumber==1){
                //주변 식당 리스트
                rs.restauranglist();
            }else if(selectnumber==2){
                //검색한 식당의 메뉴 확인

            }else if(selectnumber==3){
                //메뉴 검색 식당 리스트

            }else if(selectnumber==4){
                //식당 리뷰확인 및 리뷰 작성

            }else if (selectnumber==5){
                //서비스 종료
                System.out.println("서비스를 종료합니다.");
                run = false;
                scan.close();
            }else if (selectnumber==6){
                //관리자 기능(숨겨진 기능)
                rootService ros = new rootService();
                ros.rootmode();
            }

        }
    }
}
