package computernetworks.algorithm;


import computernetworks.model.PacketTransmission;

/* ΚΑΘΥΣΤΕΡΗΣΗ ΣΕ ΔΙΚΤΥΑ */
public class DelayInNetworks {
    private final PacketTransmission packetTransmission;

    public DelayInNetworks(final PacketTransmission packetTransmission) {
        this.packetTransmission = packetTransmission;
    }

    public Double getTotalDeliveryTime() {
        return this.packetTransmission.getPropagationDelay() + (this.packetTransmission.getPacketSize() / this.packetTransmission.getBitRate());
    }

    public Double getBitDeliveryTime(final int selectedBit) {
        return this.packetTransmission.getPropagationDelay() + ((selectedBit - 1) / this.packetTransmission.getBitRate());
    }
}
