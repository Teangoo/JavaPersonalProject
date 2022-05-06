import java.util.List;
import java.util.Scanner;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();
    Scanner scan = new Scanner(System.in);
    Long memId = 0L; //회원관리번호
    // 회원관리번호 회원아이디 회원비밀번호 회원이름 회원전화번호 회원닉네임
    public void save() {
        System.out.println("-----------------------------------------");
        System.out.println("\t\t회원가입 서비스 입니다.");
        System.out.println("-----------------------------------------");
        System.out.print("가입 하실 아이디를 입력하세요 : ");
        String id = scan.nextLine();
        boolean idpass = memberRepository.findById(id);
        if(!idpass){
            System.out.print("비밀번호를 입력하세요:");
            String pwd = scan.nextLine();
            System.out.print("이름을 입력하세요:");
            String name = scan.nextLine();
            System.out.print("전화번호를 입력하세요:");
            String phone = scan.nextLine();
            System.out.print("닉네임를 입력하세요:");
            String nick = scan.nextLine();
            boolean nickPass = memberRepository.findByNick(nick);
            if(!nickPass){
                MemberDTO member = new MemberDTO(++memId,id,pwd,name,phone,nick);
                memberRepository.save(member);
                System.out.println("가입을 축하합니다.");
            }else{
                System.out.println("닉네임이 중복됩니다.");
            }

        }else{
            System.out.println("아이디가 중복됩니다.");
        }
    }

    public void quit() {
        System.out.println("-----------------------------------------");
        System.out.println("\t\t회원탈퇴 서비스 입니다.");
        System.out.println("-----------------------------------------");
        System.out.println("탈퇴하실 ID를 입력하세요.");
        System.out.print(" > ");
        String id = scan.nextLine();
        System.out.println("비밀번호를 입력하세요.");
        System.out.print(" > ");
        String pwd = scan.nextLine();
        boolean pass = memberRepository.idpwdpass(id,pwd);
        if(pass){
            MemberDTO member = memberRepository.findByIdlist(id);
            System.out.println("탈퇴하시려는 계정의 정보는 다음과 같습니다.");
            System.out.println(member);
            System.out.println("탈퇴하시면 작성하신 리뷰도 함께 삭제됩니다.");
            String review = memberRepository.nickname(id);
            ReviewRepository reviewRepository = new ReviewRepository();
            List<ReviewDTO> list = reviewRepository.idReviewAll(review);
            for (int i=0; i<list.size(); i++){
                System.out.println(list.get(i));
            }
            System.out.print("정말 삭제하시겠습니까? 삭체하시려면 1번을 나가시려면 2번을 눌러주세요.");
            System.out.print(" > ");
            int selinput = scan.nextInt();scan.nextLine();
            if(selinput == 1){
                memberRepository.delete(member);
                reviewRepository.deleteAll(review);
                System.out.println("계정 과 리뷰가 삭제되었습니다.");
            }
        }else{
            System.out.println("아이디 및 비밀번호가 틀립니다.");
        }
    }
}
