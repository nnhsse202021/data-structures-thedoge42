import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class and ListIterator class.
 */
public class ListDemo {
	public static void main(String[] args) {
		LinkedList<String> staff = new LinkedList<>();

		staff.addLast("Diana");
		staff.addLast("Harry");
		staff.addLast("Romeo");
		staff.addLast("Tom");

		ListIterator<String> iterator = staff.listIterator();

		iterator.next();

		System.out.println(iterator.next());

		iterator.add("Hello");
		System.out.println(iterator.previous());
		
		iterator.remove();

		while (iterator.hasNext()) {
			if (iterator.next().equals("Juliet")) {
				iterator.remove();
			}
		}

		System.out.println(staff);
	}
}
