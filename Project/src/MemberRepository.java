import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    static List<MemberDTO> memberList = new ArrayList<>();


    public boolean findById(String id) {
        boolean pass = false;
        for(int i = 0; i< memberList.size();i++){
            if(id.equals(memberList.get(i).getMemberId())){
                pass = true;
            }
        }
        return pass;
    }

    public boolean findByNick(String nick) {
        boolean pass = false;
        for(int i = 0; i< memberList.size();i++){
            if(nick.equals(memberList.get(i).getMemberNickName())){
                pass = true;
            }
        }
        return pass;
    }

    public void save(MemberDTO member) {
        memberList.add(member);
    }
}
