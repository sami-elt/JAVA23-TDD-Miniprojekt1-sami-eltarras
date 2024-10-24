public class PrimeNumbers {
    
    public boolean isPrime(int number) {

        if (number <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0)
                return false;

        return true;

    }

    public void validationCheck(int first, int last){
        if (first < 0 || last > 1000 || first > last){
            throw new IllegalArgumentException("Input incorrect, enter input between 0-1000");
        }
    }

    public int sumPrimes(int first, int last) {
        validationCheck(first, last);

        int sum = 0;

        for (int i = first; i <= last; i++){
            if (isPrime(i)){
                sum += i;
            }
        }
    return sum;
    }

    public int totalPrimes(int first, int last) {
        validationCheck(first, last);

        int count = 0;

        for (int i = first; i <= last; i++){
            if (isPrime(i)){
                count++;
            }
        }
        return count;
    }

    public void printSum(){
        System.out.println("Total sum of the primes: " + sumPrimes(0,10));
    }

    public void printAmount(){
        System.out.println("Total amount of primes in number: " + totalPrimes(0,50));
    }


    public static void main(String[] args) {

        PrimeNumbers primeNumbers = new PrimeNumbers();

        primeNumbers.printSum();
        primeNumbers.printAmount();

    }
}
