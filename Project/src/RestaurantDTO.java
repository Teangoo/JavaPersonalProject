public class RestaurantDTO {
    private Long Id; //식당 관리번호
    private String RestaurantName; //식당이름
    private String RestaurantAddress; //식당주소
    private String RestaurantPhoneNumber; //식당전화번호
    private int RestaurantDistance; //인천일보아카데미와 식당의 거리

    public RestaurantDTO() {
    }

    public RestaurantDTO(Long id, String restaurantName, String restaurantAddress, String restaurantPhoneNumber, int restaurantDistance) {
        Id = id;
        RestaurantName = restaurantName;
        RestaurantAddress = restaurantAddress;
        RestaurantPhoneNumber = restaurantPhoneNumber;
        RestaurantDistance = restaurantDistance;
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

    public String getRestaurantAddress() {
        return RestaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        RestaurantAddress = restaurantAddress;
    }

    public String getRestaurantPhoneNumber() {
        return RestaurantPhoneNumber;
    }

    public void setRestaurantPhoneNumber(String restaurantPhoneNumber) {
        RestaurantPhoneNumber = restaurantPhoneNumber;
    }

    public int getRestaurantDistance() {
        return RestaurantDistance;
    }

    public void setRestaurantDistance(int restaurantDistance) {
        RestaurantDistance = restaurantDistance;
    }

    @Override
    public String toString() {
        return " | 관리번호 : " + Id +" | 식당이름 : " + RestaurantName + " | 주소 : " + RestaurantAddress + " | 전화번호 : " + RestaurantPhoneNumber + " | 거리 : " + RestaurantDistance+"KM";
    }
}
