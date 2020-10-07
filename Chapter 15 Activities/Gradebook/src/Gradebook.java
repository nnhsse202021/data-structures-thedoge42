import java.util.Scanner;
import java.util.*;

/**
 * A program to add, remove, modify or print student names and grades.
 */
public class Gradebook {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, String> gradeMap = new TreeMap<>();
        boolean done = false;
        while (!done) {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q")) {
                done = true;
            } else if (input.equals("A")) {
                System.out.print("Enter the student's name: ");
                String name = in.next().toUpperCase();
                System.out.println();
                System.out.print("Enter " + name + "'s grade: ");
                String grade = in.next().toUpperCase();
                gradeMap.put(name, grade);
                System.out.println("-----");
            } else if (input.equals("R")) {
                System.out.print("Enter the name of the student to be removed: ");
                String name = in.next().toUpperCase();
                gradeMap.remove(name);
                System.out.println("-----");
            } else if (input.equals("M")) {
                System.out.print("Enter the name of student who's grade is being modified: ");
                String name = in.next().toUpperCase();
                System.out.println();
                System.out.print("Enter " + name + "'s new grade: ");
                String grade = in.next().toUpperCase();
                gradeMap.put(name, grade);
                System.out.println("-----");
            } else if (input.equalsIgnoreCase("P")) {
                Set<String> keySet = gradeMap.keySet();
                for (String key:keySet) {
                    System.out.println(key.substring(0, 1) + key.substring(1).toLowerCase() + ": " + 
                        gradeMap.get(key));
                }
				System.out.println("-----");
			} else {
                done = true;
            }
        }
	}
}