package dao;

import models.Foodtype;

import java.util.List;

public interface FoodtypeDao {
    void add(Foodtype foodtype);
    //void update();
    List<Foodtype> getAll();
    //void findById(Foodtype foodtype);
    void deleteById(int id);
    void clearAll();
}
