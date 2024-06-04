package dev.codescreen.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class userModelTest {

    private userModel user;
    private final long userid = 1L;
    private final String firstName = "John";
    private final String lastName = "Doe";
    private final String password = "securePassword123";

    @BeforeEach
    void setUp() {
        user = new userModel(userid, firstName, lastName, password);
    }

    @Test
    void testGetUserid() {
        assertEquals(userid, user.getUserid());
    }

    @Test
    void testSetUserid() {
        long newUserId = 2L;
        user.setUserid(newUserId);
        assertEquals(newUserId, user.getUserid());
    }

    @Test
    void testGetFirstName() {
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    void testSetFirstName() {
        String newFirstName = "Jane";
        user.setFirstName(newFirstName);
        assertEquals(newFirstName, user.getFirstName());
    }

    @Test
    void testGetLastName() {
        assertEquals(lastName, user.getLastName());
    }

    @Test
    void testSetLastName() {
        String newLastName = "Smith";
        user.setLastName(newLastName);
        assertEquals(newLastName, user.getLastName());
    }

    @Test
    void testGetPassword() {
        assertEquals(password, user.getPassword());
    }

    @Test
    void testSetPassword() {
        String newPassword = "newPassword2024!";
        user.setPassword(newPassword);
        assertEquals(newPassword, user.getPassword());
    }

    @Test
    void testToString() {
        String expectedString = "userModel [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + "]";
        assertEquals(expectedString, user.toString());
    }
}
