import java.util.*;


class BurgerMeal {
    private String bunType;
    private String patty;


    private final boolean hasCheese;
    private final List<String> toppings;
    private final String side;
    private final String drink;


    private BurgerMeal (BurgerBuilder Builder){
        this.bunType = Builder.bunType;
        this.patty = Builder.patty;
        this.hasCheese = Builder.hasCheese;
        this.toppings = Builder.toppings;
        this.side = Builder.side;
        this.drink = Builder.drink;
    }


    public static class BurgerBuilder {
        private final String bunType;
        private final String patty;


        private boolean hasCheese;
        private List<String> toppings;
        private String side;
        private String drink;


        public BurgerBuilder(String bunType, String patty){
            this.bunType = bunType;
            this.patty = patty;
        }

        public BurgerBuilder withCheese(boolean hasCheese){
            this.hasCheese = hasCheese;
            return this;
        }

        public BurgerBuilder withToppings(List<String> toppings){
            this.toppings = toppings;
            return this;
        }

        public BurgerBuilder withSide(String side){
            this.side = side;
            return this;
        }


        public BurgerBuilder withDrink(String drink){
            this.drink = drink;
            return this;
        }


        public BurgerMeal build(){
            return new BurgerMeal(this);
        }
    }



}



public class Builder_Pattern {
    public static void main(String args[]){

        BurgerMeal burgerMeal = new BurgerMeal.BurgerBuilder("wheat", "veg").build();
        BurgerMeal burgerMealWithCheese = new BurgerMeal.BurgerBuilder("wheat", "veg").withCheese(true).withSide("fries").build();
    }
}
