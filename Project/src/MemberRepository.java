import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    static List<MemberDTO> memberList = new ArrayList<>();


    public boolean findById(String id) { // 아이디 체크
        boolean pass = false;
        for(int i = 0; i< memberList.size();i++){
            if(id.equals(memberList.get(i).getMemberId())){
                pass = true;
            }
        }
        return pass;
    }

    public boolean findByNick(String nick) { // 닉네임 체크
        boolean pass = false;
        for(int i = 0; i< memberList.size();i++){
            if(nick.equals(memberList.get(i).getMemberNickName())){
                pass = true;
            }
        }
        return pass;
    }

    public void save(MemberDTO member) { // 계정등록
        memberList.add(member);
    }

    public boolean idpwdpass(String id, String pwd) { //아이디 비밀번호 체크
        boolean pass = false;
        for (int i = 0; i < memberList.size(); i++) {
            if(id.equals(memberList.get(i).getMemberId()) && pwd.equals(memberList.get(i).getMemberPassword())){
                pass = true;
            }
        }
        return pass;
    }

    public MemberDTO findByIdlist(String id) {
        MemberDTO member = null;
        for (int i = 0; i< memberList.size();i++){
            if(id.equals(memberList.get(i).getMemberId())){
                member = memberList.get(i);
            }
        }
        return member;
    }

    public void delete(MemberDTO member) {
        memberList.remove(member);
    }

    public String nickname(String id) {
        String nick = null;
        for (int i=0; i<memberList.size();i++){
            if(id.equals(memberList.get(i).getMemberId())){
                nick = memberList.get(i).getMemberNickName();
            }
        }
        return nick;
    }
}
