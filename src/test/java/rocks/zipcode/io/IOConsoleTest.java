package rocks.zipcode.io;

/**
 * @author leon on 03/02/2019.
 */

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by leon on 8/22/17.
 */
public class IOConsoleTest {
    private IOConsole console;


    @Test
    public void testGetFloatInput0() {
        testGetFloatInput("0", 0.0f);
    }

    @Test
    public void testGetFloatInput1() {
        testGetFloatInput("1", 1.0F);
    }

    @Test
    public void testGetFloatInput2() {
        testGetFloatInput("1.1", 1.1F);
    }

    @Test(expected=NoSuchElementException.class)
    public void testGetFloatInput3() {
        testGetFloatInput("_", 1.1F);
    }









    @Test
    public void testGetLongInput0() {
        testGetLongInput("0", 0L);
    }

    @Test
    public void testGetLongInput1() {
        testGetLongInput("1", 1L);
    }

    @Test(expected=NoSuchElementException.class)
    public void testGetLongInput2() {
        testGetLongInput("1.1", 1L);
    }

    @Test(expected=NoSuchElementException.class)
    public void testGetLongInput3() {
        testGetLongInput("_", 1L);
    }









    @Test
    public void testGetStringInput() {
        // Given
        String expected = "Hello world";
        this.console = createTestIOConsole(expected);

        // When
        String actual = console.getStringInput("");

        // Then
        Assert.assertEquals(actual, expected);
    }

    private void testGetLongInput(String input, Long expected) {
        // Given
        this.console = createTestIOConsole(input);

        // When
        Long actual = console.getLongInput("");

        // Then
        Assert.assertEquals(actual, expected);
    }


    private void testGetFloatInput(String input, Float expected) {
        // Given
        this.console = createTestIOConsole(input);

        // When
        Float actual = console.getFloatInput("");

        // Then
        Assert.assertEquals(actual, expected);
    }


    private IOConsole createTestIOConsole(String inputString) {
        byte[] inputBytes = inputString.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        IOConsole console = new IOConsole(scanner, System.out);
        return console;
    }
}