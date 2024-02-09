package computernetworks.algorithm;


import computernetworks.model.AccessPoint;
import computernetworks.model.Service;

/* ΡΥΘΜΟΙ ΜΕΤΑΔΟΣΗΣ ΠΛΗΡΟΦΟΡΙΑΣ ΣΕ ΔΙΚΤΥΑ */

public class TransmissionRatesInNetworks {
    private final AccessPoint accessPoint;

    public TransmissionRatesInNetworks(final AccessPoint accessPoint) {
        this.accessPoint = accessPoint;
    }

    public int calculateMinimumAccessPoints() {
        double totalRequiredBitRate = 0;
        for (Service service : accessPoint.getServices()) {
            System.out.println(service.getSampleSize() + " " + service.getSamplingRate());
            totalRequiredBitRate += (service.getSamplingRate() * service.getSampleSize());
        }

        System.out.println("Total required bit rate: " + totalRequiredBitRate);


        return (int) Math.ceil(totalRequiredBitRate / accessPoint.getAccessPointCapacity());
    }
}
