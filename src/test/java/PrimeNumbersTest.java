import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeNumbersTest {

    @BeforeEach
    public void setup(){
        primeNumbers = new PrimeNumbers();
    }

    PrimeNumbers primeNumbers = new PrimeNumbers();

    @Test
    @DisplayName("test if its a primenumber")
    public void isPrimeNumber(){
        assertTrue(primeNumbers.isPrime(3));
        assertTrue(primeNumbers.isPrime(2));
        assertFalse(primeNumbers.isPrime(4));
        assertFalse(primeNumbers.isPrime(6));
    }

    @Test
    @DisplayName("count for adding primes")
    public void totalSumOfPrimes(){
        assertEquals(10, primeNumbers.sumPrimes(0,6));
        assertEquals(17, primeNumbers.sumPrimes(0,10));
        assertEquals(0, primeNumbers.sumPrimes(8,10));
    }

    @Test
    @DisplayName("count of how many primes")
    public void totalPrimes(){
        assertEquals(4, primeNumbers.totalPrimes(0,10));
        assertEquals(0, primeNumbers.totalPrimes(8,10));
        assertEquals(8, primeNumbers.totalPrimes(0,20));
    }

    @Test
    @DisplayName("check for errors in input with negative")
    public void negativeInput(){
        assertThrows(IllegalArgumentException.class, ()-> primeNumbers.validationCheck(-5,999));
    }

    @Test
    @DisplayName("check for above 1000 input")
    public void overBoundInput(){
        assertThrows(IllegalArgumentException.class, ()-> primeNumbers.validationCheck(0,1002));
    }

    @Test
    @DisplayName("check for first range greater than last")
    public void firstBiggerThanLast(){
        assertThrows(IllegalArgumentException.class, ()-> primeNumbers.validationCheck(20,10));
    }

    @Test
    @DisplayName("check för konsol antalprimtal")
    public void amountMessage(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

        primeNumbers.printAmount();

        System.setOut(System.out);

        assertEquals("Total amount of primes in number: 15", outContent.toString().trim());
    }

    @Test
    @DisplayName("check för konsol summa av primtal")
    public void countMessage(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

        primeNumbers.printSum();

        System.setOut(System.out);

        assertEquals("Total sum of the primes: 17", outContent.toString().trim());
    }







}