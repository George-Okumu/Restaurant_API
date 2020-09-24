package dao;

import models.Review;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oReviewDao implements ReviewDao {
    private final Sql2o sql2o;
    public Sql2oReviewDao(Sql2o sql2o) {this.sql2o = sql2o; }// making the sql2o object available everywhere so we can call methods in it

    @Override
    public void add(Review review) {
        String sql = "INSERT INTO reviews (content, writtenBy, rating, restaurantID) VALUES (:content, :writtenBy, :rating, :restaurantId)";
        try (Connection con = sql2o.open()) {//try to open connection
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .bind(review)//map my argument onto the query so we can use information from it
                    .executeUpdate()//run it all
                    .getKey();//int id is now the row number (row “key”) of db
            review.setId(id);//update object to set id now from database
        }catch (Sql2oException ex) {
            System.out.println(ex);// prints out an error if exception is cached
        }
    }

    @Override
    public List<Review> getAll() {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM reviews")
                    .executeAndFetch(Review.class);// Fetches a list
        }
    }

    @Override
    public List<Review> getAllReviewsByRestaurant(int restaurantId) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM reviews WHERE restaurantId = :restaurantID")
                    .addParameter("restaurantID", restaurantId) //key value pair
                    .executeAndFetch(Review.class);// fetches restaurant id
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM reviews WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from reviews";
        try (Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
