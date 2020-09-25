package dao;

import models.Foodtype;
import models.Restaurant;

import java.util.List;

public interface FoodtypeDao {
    //CREATE methods
    void add(Foodtype foodtype);
    void addFoodtypeToRestaurant(Restaurant restaurant, Foodtype foodtype);

  //updating methods
    //void update();

    //Read methods
    List<Foodtype> getAll();
    List<Restaurant> getAllRestaurantsForAFoodtype(int id);

    //void findById(Foodtype foodtype);

    void deleteById(int id);

    void clearAll();
}
