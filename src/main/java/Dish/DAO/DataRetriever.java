package Dish.DAO;

import Dish.Util.DBConnection;
import Dish.model.CategoryEnum;
import Dish.model.Dish;
import Dish.model.DishEnum;
import Dish.model.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataRetriever {
    DBConnection dbConnection = new DBConnection();
    public Dish findDishById(Integer id) throws SQLException {
     String sql ="SELECT d.id AS dish_id, d.name AS dish_name, d.dish_type AS dish_type, " +
             "i.id AS ingredient_id, i.name AS ingredient_name, i.price AS ingredient_price, i.category AS ingredient_category " +
             "FROM dish d " +
             "JOIN ingredient i ON d.id = i.id_dish " +
             "WHERE d.id = ?";

        PreparedStatement statement = dbConnection.getDBConnection().prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        Dish dish = null;

        while (resultSet.next()) {
            if (dish == null) {
                dish = new Dish(
                        resultSet.getInt("dish_id"),
                        resultSet.getString("dish_name"),
                        DishEnum.valueOf(resultSet.getString("dish_type")),
                        new ArrayList<>()
                );
            }

            Ingredient ingredient = new Ingredient(
                    resultSet.getInt("ingredient_id"),
                    resultSet.getString("ingredient_name"),
                    resultSet.getDouble("ingredient_price"),
                    CategoryEnum.valueOf(resultSet.getString("ingredient_category")),
                    dish
            );

            dish.getIngredients().add(ingredient);
        }

        return dish;
    }
}
