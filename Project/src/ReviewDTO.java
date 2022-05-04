public class ReviewDTO {
    private Long Id;//리뷰관리번호
    private String RestaurantName;//가게이름
    private String MenuName;//리뷰작성한 메뉴이름
    private String MemberNickName;//리뷰작성자
    private String ReviewContents; //리뷰내용
    private int ReviewScore; //평점

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String restaurantName, String menuName, String memberNickName, String reviewContents, int reviewScore) {
        Id = id;
        RestaurantName = restaurantName;
        MenuName = menuName;
        MemberNickName = memberNickName;
        ReviewContents = reviewContents;
        ReviewScore = reviewScore;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    public String getMemberNickName() {
        return MemberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        MemberNickName = memberNickName;
    }

    public String getReviewContents() {
        return ReviewContents;
    }

    public void setReviewContents(String reviewContents) {
        ReviewContents = reviewContents;
    }

    public int getReviewScore() {
        return ReviewScore;
    }

    public void setReviewScore(int reviewScore) {
        ReviewScore = reviewScore;
    }

    @Override
    public String toString() {
        return  " | Id : " + Id +
                " | RestaurantName : " + RestaurantName +
                " | MenuName : " + MenuName +
                " | MemberNickName : " + MemberNickName +
                " | ReviewContents : " + ReviewContents +
                " | ReviewScore : " + ReviewScore;
    }
}
