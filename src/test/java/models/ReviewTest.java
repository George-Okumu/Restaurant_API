package models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void review_instantiatesCorrectlyWithObjects_true() {
        Review testReview = setUpReview();
        Assert.assertTrue(true);
    }

    @Test
    public void getContentReturnsCorrectContent_true() throws Exception {
        Review testReview = setUpReview();
        assertEquals("Nice place to dinner", testReview.getContent());
    }

    @Test
    public void getWrittenByReturnsCorrectWrittenBy_string() throws Exception {
        Review testReview = setUpReview();
        assertEquals("Vivian", testReview.getWrittenBy());
    }

    @Test
    public void getRatingReturnsCorrectRating_int() throws Exception {
        Review testReview = setUpReview();
        assertEquals(100, testReview.getRating());
    }

    @Test
    public void getRestaurantIdReturnsCorrectRestaurantId_int() throws Exception {
        Review testReview = setUpReview();
        assertEquals(1, testReview.getRestaurantId());
    }

    @Test
    public void equals_reviewObjectsReturnsTheSameValues() {
        Review firstReview = setUpReview();
        Review secondReview = setUpReview();
        assertTrue(firstReview.equals(secondReview));
    }

    @Test
    public void reviewSetsCorrectContent() throws Exception{
        Review testReview = setUpReview();
        testReview.setContent("Nice place to dinner");
        assertNotEquals("No review", testReview.getContent());
    }

    @Test
    public void reviewSetsCorrectWrittenBy() throws Exception{
        Review testReview = setUpReview();
        testReview.setWrittenBy("Vivian");
        assertNotEquals("George", testReview.getWrittenBy());
    }

    @Test
    public void reviewSetsCorrectRating() throws Exception{
        Review testReview = setUpReview();
        testReview.setRating(100);
        assertEquals(100, testReview.getRating());
    }

    @Test
    public void reviewSetsCorrectRestaurantId() throws Exception{
        Review testReview = setUpReview();
        testReview.setRestaurantId(1);
        assertNotEquals(250, testReview.getRestaurantId());
    }

    public Review setUpReview(){
        return new Review ("Nice place to dinner", "Vivian", 100, 1);
    }
}