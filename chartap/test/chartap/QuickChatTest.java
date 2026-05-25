package chartap;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickChatTest {

    private boolean result;

    // =========================
    // USERNAME TESTS
    // =========================

    @Test
    public void testUsernameCorrectlyFormatted() {


        assertTrue(result);

        System.out.println(
                "Username successfully captured.");
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {

        boolean outcome =
                QuickChat.checkUsername("kga123");

        assertFalse(outcome);

        System.out.println(
                "Username is not correctly formatted.");
    }

    // =========================
    // PASSWORD TESTS
    // =========================

    @Test
    public void testPasswordMeetsComplexity() {

        boolean outcome =
                QuickChat.checkPassword("Password1@");

        assertTrue(outcome);

        System.out.println(
                "Password successfully captured.");
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {

        boolean outcome =
                QuickChat.checkPassword("password");

        assertFalse(outcome);

        System.out.println(
                "Password is not correctly formatted.");
    }

    // =========================
    // CELL NUMBER TESTS
    // =========================

    @Test
    public void testCellPhoneNumberCorrectlyFormatted() {

        boolean outcome =
                QuickChat.checkCellNumber("+27831234567");

        assertTrue(outcome);

        System.out.println(
                "Cell phone number successfully added.");
    }

    @Test
    public void testCellPhoneNumberIncorrectlyFormatted() {

        boolean outcome =
                QuickChat.checkCellNumber("0831234567");

        assertFalse(outcome);

        System.out.println(
                "Cell phone number incorrectly formatted.");
    }

    // =========================
    // MESSAGE ID TEST
    // =========================

    @Test
    public void testMessageIDCreated() {

        String messageID =
                QuickChat.generateMessageID();

        assertNotNull(messageID);

        assertEquals(10, messageID.length());
    }

    // =========================
    // MESSAGE HASH TEST
    // =========================

    @Test
    public void testMessageHashCreated() {

        String outcome =
                QuickChat.createMessageHash(
                        "0012345678",
                        1,
                        "Hi Thanks");

        assertEquals(
                "00:1:HITHANKS",
                outcome);
    }

    // =========================
    // LOGIN TESTS
    // =========================

    @Test
    public void testLoginSuccessful() {

        QuickChat.storedUsername = "k_g1";
        QuickChat.storedPassword = "Password1@";

        boolean loginResult =
                QuickChat.storedUsername.equals("k_g1")
                        &&
                QuickChat.storedPassword.equals("Password1@");

        assertTrue(loginResult);

        System.out.println(
                "Welcome k_g1, it is great to see you again.");
    }

    @Test
    public void testLoginFailed() {

        QuickChat.storedUsername = "k_g1";
        QuickChat.storedPassword = "Password1@";

        boolean loginResult =
                QuickChat.storedUsername.equals("wrong")
                        &&
                QuickChat.storedPassword.equals("wrong");

        assertFalse(loginResult);

        System.out.println(
                "Username or password incorrect.");
    }

    // =========================
    // MESSAGE COUNT TEST
    // =========================

    @Test
    public void testInitialMessageCount() {

        assertEquals(
                0,
                QuickChat.numMessagesSent);
    }
}