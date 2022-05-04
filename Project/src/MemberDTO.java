public class MemberDTO {
    private Long Id; // 회원관리번호
    private String MemberId; // 회원아이디
    private String MemberPassword; //회원비밀번호
    private String MemberName; //회원이름
    private String MemberMobile; // 회원전화번호
    private String MemberNickName; //회원닉네임

    public MemberDTO() {
    }

    public MemberDTO(Long id, String memberId, String memberPassword, String memberName, String memberMobile, String memberNickName) {
        Id = id;
        MemberId = memberId;
        MemberPassword = memberPassword;
        MemberName = memberName;
        MemberMobile = memberMobile;
        MemberNickName = memberNickName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String memberId) {
        MemberId = memberId;
    }

    public String getMemberPassword() {
        return MemberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        MemberPassword = memberPassword;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }

    public String getMemberMobile() {
        return MemberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        MemberMobile = memberMobile;
    }

    public String getMemberNickName() {
        return MemberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        MemberNickName = memberNickName;
    }

    @Override
    public String toString() {
        return " | Id : " + Id + " | MemberId : " + MemberId  + " | MemberPassword : " + MemberPassword  + " | MemberName : " + MemberName  + " | MemberMobile : " + MemberMobile  + " | MemberNickName : " + MemberNickName;
    }
}
