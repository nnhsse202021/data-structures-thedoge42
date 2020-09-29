import java.util.LinkedList;

/**
 * A test program to reverse the entries in a linked list.
 */
public class ReverseTester {
	public static void main(String[] args) {
		LinkedList<String> employeeNames = new LinkedList<>();
		employeeNames.addLast("Dick");
		employeeNames.addLast("Harry");
		employeeNames.addLast("Romeo");
		employeeNames.addLast("Tom");
		employeeNames.addLast("George");
		ListUtil.reverse(employeeNames);
		System.out.println(employeeNames);
		System.out.println("Expected: [George, Tom, Romeo, Harry, Dick]");
	}
}