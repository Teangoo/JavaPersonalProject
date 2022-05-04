public class RestaurantDTO {
    private Long Id; //식당 관리번호
    private String RestaurangName; //식당이름
    private String RestaurangAddress; //식당주소
    private String RestaurangPhoneNumber; //식당전화번호
    private int RestautangDistance; //인천일보아카데미와 식당의 거리

    public RestaurantDTO() {
    }

    public RestaurantDTO(Long id, String restaurangName, String restaurangAddress, String restaurangPhoneNumber, int restautangDistance) {
        Id = id;
        RestaurangName = restaurangName;
        RestaurangAddress = restaurangAddress;
        RestaurangPhoneNumber = restaurangPhoneNumber;
        RestautangDistance = restautangDistance;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRestaurangName() {
        return RestaurangName;
    }

    public void setRestaurangName(String restaurangName) {
        RestaurangName = restaurangName;
    }

    public String getRestaurangAddress() {
        return RestaurangAddress;
    }

    public void setRestaurangAddress(String restaurangAddress) {
        RestaurangAddress = restaurangAddress;
    }

    public String getRestaurangPhoneNumber() {
        return RestaurangPhoneNumber;
    }

    public void setRestaurangPhoneNumber(String restaurangPhoneNumber) {
        RestaurangPhoneNumber = restaurangPhoneNumber;
    }

    public int getRestautangDistance() {
        return RestautangDistance;
    }

    public void setRestautangDistance(int restautangDistance) {
        RestautangDistance = restautangDistance;
    }

    @Override
    public String toString() {
        return "RestaurantDTO{" +
                "Id=" + Id +
                ", RestaurangName='" + RestaurangName + '\'' +
                ", RestaurangAddress='" + RestaurangAddress + '\'' +
                ", RestaurangPhoneNumber='" + RestaurangPhoneNumber + '\'' +
                ", RestautangDistance='" + RestautangDistance + '\'' +
                '}';
    }
}
