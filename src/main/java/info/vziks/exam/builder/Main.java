package info.vziks.exam.builder;

public class Main {
    public static void main(String[] args) {
        NutritionFacts apple = new NutritionFacts.Builder(4)
                .calories(300)
                .fat(2)
                .build();

    }
}
