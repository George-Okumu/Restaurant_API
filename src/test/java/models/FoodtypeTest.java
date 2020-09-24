package models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodtypeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void foodtype_instantiatesCorrectly_true() throws Exception {
        Foodtype testFoodtype = setUpFoodtype();
        Assert.assertTrue(true);
    }

    @Test
    public void foodtype_getsNameCorrectly_string() throws Exception {
        Foodtype testFoodtype = setUpFoodtype();
        assertEquals("Chips", testFoodtype.getName());
    }

    @Test
    public void foodtype_setsNameCorrectly() throws Exception {
        Foodtype testFoodtype = setUpFoodtype();
        testFoodtype.setName("Chips");
        assertEquals("Chips", testFoodtype.getName());
    }

    @Test
    public void equals_foodtypeReturnsTrueIfFoodtypeNameAreTheSame() throws Exception{
        Foodtype oneFoodtype = setUpFoodtype();
        Foodtype secondFoodtype = setUpFoodtype();
        assertTrue(oneFoodtype.equals(secondFoodtype));
    }

    @Test
    public void foodtype_setsId() throws Exception {
        Foodtype testFoodtype = setUpFoodtype();
        testFoodtype.setId(5);
        assertEquals(5, testFoodtype.getId());
    }

    public Foodtype setUpFoodtype(){
        return new Foodtype("Chips");
    }
}