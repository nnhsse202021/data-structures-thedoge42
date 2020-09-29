import java.util.*;
import java.io.*;

/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
	public static Set<Integer> sieve(int n) {
		Set<Integer> set = new HashSet<>();

		for (int i = 2; i <= n; i++) {
			set.add(i);
		}

		for (int i = 2; i <= n; i++) {
			if (set.contains(i)) {
				for (int j = 2*i; j <= n; j += i) {
					set.remove(j);
				}
			}
		}

		return set;
	}
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
		int n = in.nextInt();

		System.out.println(sieve(n));

		in.close();
    }
}
