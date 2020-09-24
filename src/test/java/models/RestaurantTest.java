package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void restaurant_instantiates_correctlyWithObjects_true() throws Exception{
        Restaurant testRestaurant = setUpRestaurant();
        assertEquals(true, testRestaurant instanceof Restaurant);
    }

    @Test
    public void getNameReturnsCorrectName() throws Exception {
        Restaurant testRestaurant = setUpRestaurant();
        assertEquals("George", testRestaurant.getName());
    }


    @Test
    public void getAddressReturnsCorrectAddress() throws Exception {
        Restaurant testRestaurant = setUpRestaurant();
        assertEquals("0100", testRestaurant.getAddress());
    }


    @Test
    public void getZipcodeReturnsCorrectZipcode() throws Exception {
        Restaurant testRestaurant = setUpRestaurant();
        assertEquals("01200", testRestaurant.getZipcode());
    }


    @Test
    public void getPhoneReturnsCorrectPhone() throws Exception {
        Restaurant testRestaurant = setUpRestaurant();
        assertEquals("07123456789", testRestaurant.getPhone());
    }


    @Test
    public void getWebsiteReturnsCorrectWebsite() throws Exception {
        Restaurant testRestaurant = setUp2Restaurant();
        assertEquals("no website listed here", testRestaurant.getWebsite());
    }

    @Test
    public void getEmailReturnsCorrectEmail() throws Exception {
        Restaurant testRestaurant = setUp2Restaurant();
        assertEquals("no email listed here", testRestaurant.getEmail());
    }

    @Test
    public void setNameSetsCorrectName() throws Exception {
        Restaurant testRestaurant = setUpRestaurant();
        testRestaurant.setName("George");
        assertEquals("George", testRestaurant.getName());
    }

    @Test
    public void equals_ReturnsTrueIfAllObjectsOfRestaurantAreTheSame() throws Exception{
        Restaurant firstRestaurant = setUpRestaurant();
        Restaurant secondRestaurant = setUpRestaurant();
        assertTrue(firstRestaurant.equals(secondRestaurant));   
    }

    @Test
    public void setAddressSetsCorrectAddress() throws Exception {
        Restaurant testRestaurant = setUpRestaurant();
        testRestaurant.setAddress("00100");
        assertNotEquals("214 NE Broadway", testRestaurant.getAddress());
    }

    @Test
    public void setZipSetsCorrectZip() throws Exception {
        Restaurant testRestaurant = setUpRestaurant();
        testRestaurant.setZipcode("01200");
        assertNotEquals("97232", testRestaurant.getZipcode());
    }
    @Test
    public void setPhoneSetsCorrectPhone() throws Exception {
        Restaurant testRestaurant = setUpRestaurant();
        testRestaurant.setPhone("07123456789");
        assertNotEquals("503-402-9874", testRestaurant.getPhone());
    }

    @Test
    public void setWebsiteSetsCorrectWebsite() throws Exception {
        Restaurant testRestaurant = setUpRestaurant();
        testRestaurant.setWebsite("http://bluelink.com");
        assertNotEquals("http://fishwitch.com", testRestaurant.getWebsite());
    }

    @Test
    public void setEmailSetsCorrectEmail() throws Exception {
        Restaurant testRestaurant = setUpRestaurant();
        testRestaurant.setEmail("gokumu12@gmail.com");
        assertNotEquals("hellofishy@fishwitch.com", testRestaurant.getEmail());
    }

    public Restaurant setUpRestaurant(){
        return new Restaurant("George", "0100", "01200", "07123456789", "https//bluelink.com", "gokumu12@gmail.com");
    }

    public Restaurant setUp2Restaurant(){
        return new Restaurant("George", "0100", "01200", "073836453654");
    }
}