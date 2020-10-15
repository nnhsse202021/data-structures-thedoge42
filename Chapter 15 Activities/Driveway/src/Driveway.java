import java.util.Stack;

/**
 * Class for simulating a driveway and a street, using stacks of cars with
 * license plate numbers as representation.
 */
public class Driveway {
    /**
     * Stack representing the cars in the driveway.
     */
    private Stack<Integer> driveway;

    /**
     * Stack representing the cars in the street.
     */
    private Stack<Integer> street;

    /**
     * Constructor.
     */
    public Driveway() {
        this.driveway = new Stack<>();
        this.street = new Stack<>();
    }

    /**
     * Add the given license plate to the driveway.
     *
     * @param licensePlate number of license plate.
     */
    public void add(int licensePlate) {
        driveway.push(licensePlate);
        print();
    }

    /**
     * Remove the given license plate from the driveway.
     *
     * @param licensePlate number of license plate.
     */
    public void remove(int licensePlate) {
        int plate = driveway.pop();
        while (licensePlate != plate) {
            street.add(plate);
            plate = driveway.pop();
        }
        print();
    }

    /**
     * Prints the driveway and street details to the screen.
     */
    public void print() {
        System.out.println("In Driveway, starting at first in:");
        System.out.println(this.driveway);

        System.out.println("In Street, starting at first in:");
        System.out.println(this.street);
    }
}
