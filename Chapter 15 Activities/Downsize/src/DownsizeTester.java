import java.util.*;

/**
 * A test class for the downsize method.
 */
public class DownsizeTester {
	public static void main(String[] args) {
		LinkedList<String> employeeNames = new LinkedList<>();
		employeeNames.addLast("Dick");
		employeeNames.addLast("Harry");
		employeeNames.addLast("Romeo");
		employeeNames.addLast("Tom");

		Business.downsize(employeeNames, 2);

		System.out.println(employeeNames);
		System.out.println("Expected: [Dick, Romeo]");
	}
}
