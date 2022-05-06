import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {
    static List<ReviewDTO> reviewList = new ArrayList<>();
        // 리뷰관리번호 가게이름 리뷰작성한메뉴이름 리뷰작성자 리뷰내용 평점

    public List<ReviewDTO> reviewAll(String name) {
        List<ReviewDTO> list = new ArrayList<>();
        for (int i = 0; i < reviewList.size(); i++) {
            if (name.equals(reviewList.get(i).getRestaurantName())){
                list.add(reviewList.get(i));
            }
        }
        return list;
    }


    public int avgScore(List<ReviewDTO> list) { // 가게 평점
        int score = 0;
        for(int i = 0; i<list.size();i++){
            score += list.get(i).getReviewScore();
        }
        score = score/list.size();
        return score;
    }

    public void save(ReviewDTO review) {
        reviewList.add(review);
    }

    public List<ReviewDTO> idReviewAll(String id) {
        List<ReviewDTO> list = new ArrayList<>();
        for (int i = 0; i<reviewList.size();i++){
            if(id.equals(reviewList.get(i).getMemberNickName())){
                list.add(reviewList.get(i));
            }
        }
        return list;
    }

    public void delete(Long delid) {
        for (int i = 0; i<reviewList.size();i++){
            if(delid == reviewList.get(i).getId()){
                reviewList.remove(reviewList.get(i));
            }
        }
    }

    public void deleteAll(String review) {
        for (int i = 0; i< reviewList.size();i++){
            if(review.equals(reviewList.get(i).getMemberNickName())){
                reviewList.remove(reviewList.get(i));
            }
        }
    }

    public List<ReviewDTO> reviewListAll() {
        return reviewList;
    }

    public List<ReviewDTO> nicklist(String nick) {
        List<ReviewDTO> list = new ArrayList<>();
        for (int i = 0; i < reviewList.size(); i++) {
            if (nick.equals(reviewList.get(i).getMemberNickName())){
                list.add(reviewList.get(i));
            }
        }
        return list;
    }

    public List<ReviewDTO> restaurantNameReview(String restaurantName) {
        List<ReviewDTO> list = new ArrayList<>();
        for(int i = 0 ; i < reviewList.size();i++){
            if(restaurantName.equals(reviewList.get(i).getRestaurantName())){
                list.add(reviewList.get(i));
            }
        }
        return list;
    }
}
