package dao;

import models.Foodtype;

import java.util.List;

public interface FoodtypeDao {
    //CREATE methods
    void add(Foodtype foodtype);

  //updating methods
    //void update();

    //Read methods
    List<Foodtype> getAll();

    //void findById(Foodtype foodtype);

    void deleteById(int id);

    void clearAll();
}
