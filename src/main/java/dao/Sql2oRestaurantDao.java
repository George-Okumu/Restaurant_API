package dao;

import models.Foodtype;
import models.Restaurant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oRestaurantDao implements RestaurantDao {
    private final Sql2o sql2o;
    public Sql2oRestaurantDao(Sql2o sql2o) {this.sql2o = sql2o ;}

    @Override
    public void update(int id, String newName, String newAddress, String newZipcode, String newPhone, String newWebsite, String newEmail) {
        String sql = "UPDATE restaurants SET (name, address, zipcode, phone, website, email) = (:name, :address, :zipcode, :phone, :website, :email) WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("address", newAddress)
                    .addParameter("zipcode", newZipcode)
                    .addParameter("phone", newPhone)
                    .addParameter("website", newWebsite)
                    .addParameter("email", newEmail)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void add(Restaurant restaurant) {
        String sql = "INSERT INTO restaurants (name, address, zipcode, phone, website, email) VALUES (:name, :address, :zipcode, :phone, :website, :email)";
        try (Connection con = sql2o.open()) {//try to open connection
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .bind(restaurant)//map my argument onto the query so we can use information from it
                    .executeUpdate()//run it all
                    .getKey();//int id is now the row number (row “key”) of db
            restaurant.setId(id);//update object to set id now from database
        }catch (Sql2oException ex) {
            System.out.println(ex);// prints out an error if exception is cached
        }
    }

    @Override
    public void addRestaurantToFoodtype(Restaurant restaurant, Foodtype foodtype){
        String sql = "INSERT INTO restaurants_foodtypes (restaurantid, foodtypeid) VALUES (:restaurantId, :foodtypeId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("restaurantId", restaurant.getId())
                    .addParameter("foodtypeId", foodtype.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Restaurant> getAll() {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM restaurants")
                    .executeAndFetch(Restaurant.class);// Fetches a list
        }
    }

    @Override
    public Restaurant findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM restaurants WHERE id = :id")
                    .addParameter("id", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Restaurant.class); //fetch an individual item
        }
    }

    @Override
    public List<Foodtype> getAllFoodtypesByARestaurant(int restaurantId) {
        ArrayList<Foodtype> foodtypes = new ArrayList<>();

        String joinQuery = "SELECT foodtypeid FROM restaurants_foodtypes WHERE restaurantid = :restaurantId";

        try (Connection con = sql2o.open()) {
            List<Integer> allFoodtypesIds = con.createQuery(joinQuery)
                    .addParameter("restaurantId", restaurantId)
                    .executeAndFetch(Integer.class);
            for (Integer foodId : allFoodtypesIds){
                String foodtypeQuery = "SELECT * FROM foodtypes WHERE id = :foodtypeId";
                foodtypes.add(
                        con.createQuery(foodtypeQuery)
                                .addParameter("foodtypeId", foodId)
                                .executeAndFetchFirst(Foodtype.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return foodtypes;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from restaurants WHERE id = :id";
        String deleteJoin = "DELETE from restaurants_foodtypes WHERE restaurantid = :restaurantId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(deleteJoin)
                    .addParameter("restaurantId", id)
                    .executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from restaurants";
        try (Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
