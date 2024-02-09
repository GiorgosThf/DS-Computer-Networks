package computernetworks.model;

import java.util.List;

public class Signal {

    private double minSignalValue;
    private double maxSignalValue;
    private List<Double> signalValues;
    private int quantizationLevel;


    public static final class SignalBuilder{
        private SignalBuilder() {}

        private double minSignalValue;
        private double maxSignalValue;
        private List<Double> signalValues;
        private int quantizationLevel;

        public static SignalBuilder aSignal() {
            return new SignalBuilder();
        }

        public SignalBuilder withMinimumSignalValue(final double minSignalValue) {
            this.minSignalValue = minSignalValue;
            return this;
        }

        public SignalBuilder withMaximumSignalValue(final int maxSignalValue) {
            this.maxSignalValue = maxSignalValue;
            return this;
        }

        public SignalBuilder withSignalValues(final List<Double> signalValues) {
            this.signalValues = signalValues;
            return this;
        }

        public SignalBuilder withQuantizationLevel(final int quantizationLevel) {
            this.quantizationLevel = quantizationLevel;
            return this;
        }
        public  Signal build() {
            final Signal signal = new Signal();
            signal.minSignalValue = this.minSignalValue;
            signal.maxSignalValue = this.maxSignalValue;
            signal.signalValues = this.signalValues;
            signal.quantizationLevel = this.quantizationLevel;
            return signal;
        }
    }

    public double getMinSignalValue() {
        return minSignalValue;
    }

    public double getMaxSignalValue() {
        return maxSignalValue;
    }

    public List<Double> getSignalValues() {
        return signalValues;
    }

    public int getQuantizationLevel() {
        return quantizationLevel;
    }

    @Override
    public String toString() {
        return "Signal{" +
                "minSignalValue=" + minSignalValue +
                ", maxSignalValue=" + maxSignalValue +
                ", signalValues=" + signalValues +
                ", quantizationLevel=" + quantizationLevel +
                '}';
    }
}
