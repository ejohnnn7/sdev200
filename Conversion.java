public class Conversion {

    // Convert feet to meters
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    // Convert meters to feet
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    // Chapter 6: Programming Exercise 6.9 Table
    
    // Print Header
    public static void main(String[] args) {
        System.out.println("Feet    Meters    |    Meters    Feet");
        System.out.println("---------------------------------------");

    // Print Rows    
        int meterValue = 20;
        for (int feetValue = 1; feetValue <= 10; feetValue++) {
            double meters = footToMeter(feetValue);
            double feet = meterToFoot(meterValue);

            System.out.println(feetValue + "       " + meters + "    |    " 
                               + meterValue + "       " + feet);

            meterValue += 5;
        }
    }
}
