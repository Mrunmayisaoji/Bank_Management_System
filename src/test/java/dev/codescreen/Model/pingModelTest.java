package dev.codescreen.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class pingModelTest {

    private pingModel ping;
    private final Date serverDateTime = new Date();

    @BeforeEach
    void setUp() {
        ping = new pingModel(serverDateTime);
    }

    @Test
    void testGetServerDateTime() {
        assertEquals(serverDateTime, ping.getServerDateTime());
    }

    @Test
    void testSetServerDateTime() {
        Date newServerDateTime = new Date(serverDateTime.getTime() + 100000); // Add 100000 milliseconds to the current date
        ping.setServerDateTime(newServerDateTime);
        assertEquals(newServerDateTime, ping.getServerDateTime());
    }

    @Test
    void testToString() {
        String expectedString = "pingModel [serverDateTime=" + serverDateTime + "]";
        assertEquals(expectedString, ping.toString());
    }
}
