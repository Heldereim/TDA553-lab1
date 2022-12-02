public class TipPlatform {

    // ------------------------------------- Variables
    // ----------------------------------------//
    private int platformAngle = 0;

    private final int MAXPLATFORMANGLE = 70;
    private final int MINPLATFORMANGLE = 0;

    // ------------------------------------- Constructor
    // ----------------------------------------//

    public TipPlatform() {
        
    }

    // ------------------------------------- Getters
    // ----------------------------------------//

    public int getPlatformAngle() {
        return this.platformAngle;
    }


    // ------------------------------------- Misc platformAngle
    // ----------------------------------------//

    
    public void lowerPlatform(int degrees) {
        if (degrees < 0) {                              // Only want positive integers, otherwise it will be -(-degrees) = + so it
                                                        // increases instead of decreasing!
            throw new ArithmeticException("Error! Can only input a positive integer");

        } else if (this.getPlatformAngle() - degrees >= MINPLATFORMANGLE) { // Checking if we can lower n without ending up below 0
            this.platformAngle -= degrees;                                  // If it is possible to lower n, do it!

        } else { // Otherwise, set at minimum value
            this.platformAngle = MINPLATFORMANGLE;
        }
    }

    public void raisePlatform(int degrees) {
        if (degrees < 0) { // Negative inputs throw an error (cannot raise a negative amount)
            throw new ArithmeticException("Error! Can only input a positive integer");

        } else if (this.getPlatformAngle() + degrees <= MAXPLATFORMANGLE) { // Check if we can raise n without ending up above 70
            this.platformAngle += degrees;                                  // If it can raise n, do it!

        } else { // Otherwise, set at max value
            this.platformAngle = MAXPLATFORMANGLE;
        }
    }

    public boolean isPlatformDown() {
        boolean platformDown = true;

        if (this.platformAngle != 0) {
            platformDown = false;
        }
        return platformDown;
    }

}
