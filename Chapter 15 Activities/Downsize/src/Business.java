import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Business utility methods.
 */
public class Business {
	/**
	 * Removes every nth element from the linked list
	 *
	 * @param employeeNames the linked list to remove from
	 * @param n             the parameter to determine "nth"
	 */
	public static void downsize(LinkedList<String> employeeNames, int n) {
		int i = 0;
		ListIterator<String> iterator = employeeNames.listIterator();
		while (iterator.hasNext()) {
			iterator.next();
			i++;
			if (i%n == 0) {
				iterator.remove();
			}
		}
	}
}