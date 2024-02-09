package computernetworks.model;

public class PacketTransmission {
   private  double propagationDelay;
    private  double bitRate;
    private  int packetSize;

    private PacketTransmission() {
    }
    public static final class PacketTransmissionBuilder{
        private PacketTransmissionBuilder() {}

        private  double propagationDelay;
        private  double bitRate;
        private  int packetSize;

        public static PacketTransmissionBuilder aPacketTransmission() {
            return new PacketTransmissionBuilder();
        }

        public PacketTransmissionBuilder withPropagationDelay(final double propagationDelay) {
            this.propagationDelay = propagationDelay;
            return this;
        }

        public PacketTransmissionBuilder withBitRate(final double bitRate) {
            this.bitRate = bitRate;
            return this;
        }

        public PacketTransmissionBuilder withPacketSize(final int packetSize) {
            this.packetSize = packetSize;
            return this;
        }


        public PacketTransmission build() {
            final  PacketTransmission packetTransmission = new PacketTransmission();
            packetTransmission.propagationDelay = this.propagationDelay;
            packetTransmission.bitRate = this.bitRate;
            packetTransmission.packetSize = this.packetSize;
            return packetTransmission;
        }
    }

    public double getPropagationDelay() {
        return this.propagationDelay;
    }

    public double getBitRate() {
        return this.bitRate;
    }

    public int getPacketSize() {
        return this.packetSize;
    }

    @Override
    public String toString() {
        return "PacketTransmission{" +
                "propagationDelay=" + propagationDelay +
                ", bitRate=" + bitRate +
                ", packetSize=" + packetSize +
                '}';
    }
}

