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
        System.out.println("가입 하실 아이디를 입력하세요 : ");
        String id = scan.nextLine();
        boolean idpass = memberRepository.findById(id);
        if(!idpass){
            System.out.println("비밀번호를 입력하세요:");
            String pwd = scan.nextLine();
            System.out.println("이름을 입력하세요:");
            String name = scan.nextLine();
            System.out.println("전화번호를 입력하세요:");
            String phone = scan.nextLine();
            System.out.println("닉네임를 입력하세요:");
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
}
