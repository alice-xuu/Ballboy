package ballboy.model.entities;

public enum Layer {
    /**
     * The set of available layers
     */
        BACKGROUND (150), FOREGROUND (50), EFFECT (50);
        private final double z;
        Layer(double z) {
            this.z = z;
        }
        public double getZ() {
            return z;
        }

}
