package computernetworks.algorithm;


import computernetworks.model.Signal;

import java.util.List;
import java.util.stream.Collectors;

/* ΠΑΚΕΤΑ / ΡΟΕΣ ΠΛΗΡΟΦΟΡΙΑΣ. */
public class PacketsAndInformationFlows {
    private final Signal signal;

    public PacketsAndInformationFlows(final Signal signal) {
        this.signal = signal;
    }

    public List<String> quantizeSignal() {

        double stepSize =
                (this.signal.getMaxSignalValue()- this.signal.getMinSignalValue())
                        / this.signal.getQuantizationLevel();

       return this.signal.getSignalValues().stream()
                .map(signalValue -> Integer.toBinaryString((int) ((signalValue - this.signal.getMinSignalValue())/stepSize)))
               .toList();
    }
}
