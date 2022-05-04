public class ReviewDTO {
    private Long Id;//리뷰관리번호
    private String ReviewWrite;//리뷰작성자
    private Long WritePwd; //리뷰작성자비밀번호
    private String ReviewContents; //리뷰내용
    private int ReviewScore; //평점

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String reviewWrite, Long writePwd, String reviewContents, int reviewScore) {
        Id = id;
        ReviewWrite = reviewWrite;
        WritePwd = writePwd;
        ReviewContents = reviewContents;
        ReviewScore = reviewScore;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getReviewWrite() {
        return ReviewWrite;
    }

    public void setReviewWrite(String reviewWrite) {
        ReviewWrite = reviewWrite;
    }

    public Long getWritePwd() {
        return WritePwd;
    }

    public void setWritePwd(Long writePwd) {
        WritePwd = writePwd;
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
        return "ReviewDTO{" +
                "Id=" + Id +
                ", ReviewWrite='" + ReviewWrite + '\'' +
                ", WritePwd=" + WritePwd +
                ", ReviewContents='" + ReviewContents + '\'' +
                ", ReviewScore=" + ReviewScore +
                '}';
    }
}
