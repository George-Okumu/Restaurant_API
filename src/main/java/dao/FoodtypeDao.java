package dao;

import models.Foodtype;

import java.util.List;

public interface FoodtypeDao {
    void add();
    void findById(Foodtype foodtype);
    List<Foodtype> getAll();
    // List<Restaurant> getAllRestaurantsForAFoodtype(int id);

    void deleteById(int id);
    void clearAll();
}
