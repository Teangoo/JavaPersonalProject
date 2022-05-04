public class MenuListDTO {
    private Long Id; //메뉴관리번호
    private String RestaurantName; // 식당이름
    private String FoodName; //음식이름
    private Long FoodPrice; //음식가격

    public MenuListDTO() {
    }

    public MenuListDTO(Long id, String restaurantName, String foodName, Long foodPrice) {
        Id = id;
        RestaurantName = restaurantName;
        FoodName = foodName;
        FoodPrice = foodPrice;
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

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public Long getFoodPrice() {
        return FoodPrice;
    }

    public void setFoodPrice(Long foodPrice) {
        FoodPrice = foodPrice;
    }

    @Override
    public String toString() {
        return " | 메뉴관리번호 : " + Id + " | 식당이름 : " + RestaurantName + " | FoodName : " + FoodName + " | FoodPrice : " + FoodPrice;
    }
}
