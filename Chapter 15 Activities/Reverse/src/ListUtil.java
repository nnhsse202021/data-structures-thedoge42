//import java.util.LinkedList;
import java.util.*;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
 */
public class ListUtil {
	/**
	 * Reverses the elements in a linked list
	 *
	 * @param strings the linked list to reverse
	 */
	public static void reverse(LinkedList<String> strings) {
		// int l = strings.size();
		// for (int i = 0; i < l/2; i++) {
		// 	String a = strings.get(i);
		// 	strings.set(i, strings.get(l - 1 - i));
		// 	strings.set(l - 1 - i, a);
		// }

		if (strings.size() > 1) {
			String s = strings.removeFirst();
			reverse(strings);
			strings.addLast(s);
		}
	}
}