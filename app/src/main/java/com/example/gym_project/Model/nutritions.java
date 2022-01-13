package com.example.gym_project.Model;

import com.example.gym_project.R;

public class nutritions {
    private int id ;
    private String name ;
    private int image ;
    private String description ;

    public nutritions() {
    }

    public nutritions(String name, int image, String description){
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public static final nutritions[] nutritions = {
            new nutritions("High-protein foods", R.drawable.highlevel,"In this nutrition program, you should eat large amounts of protein divided into three meals a day, which are breakfast, lunch and dinner\n" +
                    "Example of breakfast: boiled eggs with brown bread\n" +
                    "An example of lunch is baked chicken caprese\n" +
                    "And dinner like shrimp prawns" ),
            new nutritions("Low Carb diet", R.drawable.low,"A low-carb diet is a diet that restricts carbohydrates, such as those found in sugary foods, pasta and bread. It is high in protein, fat and healthy vegetables.\n" +
                    "\n" +
                    "There are many different types of low-carb diets, and studies show that they can cause weight loss and improve health \n" +
                    "Low-Carb Food List — Foods to Eat\n" +
                    "You should base your diet on these real, unprocessed, low-carb foods.\n" +
                    "\n" +
                    "Meat: Beef, lamb, pork, chicken and others; grass-fed is best.\n" +
                    "Fish: Salmon, trout, haddock and many others; wild-caught fish is best.\n" +
                    "Eggs: Omega-3-enriched or pastured eggs are best.\n" +
                    "Vegetables: Spinach, broccoli, cauliflower, carrots and many others.\n" +
                    "Fruits: Apples, oranges, pears, blueberries, strawberries.\n" +
                    "Nuts and seeds: Almonds, walnuts, sunflower seeds, etc.\n" +
                    "High-fat dairy: Cheese, butter, heavy cream, yogurt.\n" +
                    "Fats and oils: Coconut oil, butter, lard, olive oil and fish oil."),
            new nutritions("The Mediterranean diet", R.drawable.md,"\n" +
                    "The Mediterranean diet is a way of eating that's based on the traditional cuisines of Greece, Italy and other countries that border the Mediterranean Sea. Plant-based foods, such as whole grains, vegetables, legumes, fruits, nuts, seeds, herbs and spices, \n" +
                    "\n" +
                    "Breakfast Greek yogurt topped with berries and a drizzle of honey.\n" +
                    "Snack Handful of almonds.\n" +
                    "Lunch Tuna on a bed of greens with a vinaigrette made with olive oil.\n" +
                    "Snack Small bowl of olives.\n" +
                    "Dinner Small chicken breast over a warm grain salad made with sautéed zucchini, tomato."),
            new nutritions("The Ketogenic Diet", R.drawable.keto,"You should base the majority of your meals around these foods:\n" +
                    "\n" +
                    "meat: red meat, steak, ham, sausage, bacon, chicken, and turkey\n" +
                    "fatty fish: salmon, trout, tuna, and mackerel\n" +
                    "eggs: pastured or omega-3 whole eggs\n" +
                    "butter and cream: grass-fed butter and heavy cream\n" +
                    "cheese: unprocessed cheeses like cheddar, goat, cream, blue, or mozzarella\n" +
                    "nuts and seeds: almonds, walnuts, flaxseeds, pumpkin seeds, chia seeds, etc.\n" +
                    "healthy oils: extra virgin olive oil, and avocado oil\n" +
                    "avocados: whole avocados or freshly made guacamole\n" +
                    "low carb veggies: green veggies, tomatoes, onions, peppers, etc.\n" +
                    "condiments: salt, pepper, herbs, and spices"),
            new nutritions("Zone diet", R.drawable.z,"The Zone Diet has been popular for several decades.\n" +
                    "\n" +
                    "It encourages followers to eat a certain amount of protein, carbs and fat at every meal in order to reduce inflammation in the body, among other health benefits.\n" +
                    "Breakfast (4 food blocks): Scrambled eggs with turkey bacon, vegetables and fruit.\n" +
                    "\n" +
                    "Lunch (4 food blocks): Grilled chicken and egg salad with fruit.\n" +
                    "\n" +
                    "Mid-Afternoon Snack (1 food block): Boiled egg, nuts and fruit."),
    };





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
