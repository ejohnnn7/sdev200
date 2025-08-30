public class Conversion {

    // Convert from feet to meters
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    // Convert from meters to feet
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main(String[] args) {
        System.out.println("Feet    Meters    |    Meters    Feet");
        System.out.println("---------------------------------------");

        int meterValue = 20;
        for (int feetValue = 1; feetValue <= 10; feetValue++) {
            // just do the math
            double meters = footToMeter(feetValue);
            double feet = meterToFoot(meterValue);

            // print without fancy formatting
            System.out.println(feetValue + "       " + meters + "    |    " 
                               + meterValue + "       " + feet);

            meterValue += 5; // add 5 to the meters column each time
        }
    }
}
