package Dish.model;

import java.util.List;

public class Dish {
    private int id;
    private String name;
    private DishEnum dishType;
    private List<Ingredients> ingredients;

    double getDishPrice(){
        return ingredients.stream()
                .mapToDouble(Ingredients::getPrice)
                .sum();
    }

    public Dish(DishEnum dishType, int id, List<Ingredients> ingredients, String name) {
        this.dishType = dishType;
        this.id = id;
        this.ingredients = ingredients;
        this.name = name;
    }

    public DishEnum getDishType() {
        return dishType;
    }

    public void setDishType(DishEnum dishType) {
        this.dishType = dishType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishType=" + dishType +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
