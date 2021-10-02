package com.ProjectModule5.Module5;

import java.io.IOException;

import junit.framework.TestCase;

public class userTest extends TestCase{
    private User newuser;
    /**
    * Sets up the test fixture.
    *
    * Called before every test case method.
    */
    protected void setUp() {
        //creates test user
        User newuser = new User();

    }

     /**
    * Tears down the test fixture.
    *
    * Called after every test case method.
    */
    protected void tearDown() {
        // release objects under test here, if necessary
    }
    /**
    * Tests setting and getting all values of the user
    */
    public void testUser() {
        newuser.setPassword("pass1");
        newuser.setUsername("userName1");
        assertEquals("pass1", newuser.getPassword());
        assertEquals("userName1", newuser.getUsername());
    }

    /**
    * reads and registers user to the user xml
    *
    * if the method prints out the list of users, pass.
     * @throws IOException
    */
    public void testUtil() throws IOException {
        UserUtil.registerUser(newuser);
        UserUtil.readUsers();
    }
}
