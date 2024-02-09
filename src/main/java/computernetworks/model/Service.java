package computernetworks.model;

public class Service {
    private  String serviceName;
    private  int samplingRate;
    private  int sampleSize;

    private Service() {}

    public static final class ServiceBuilder{
        private ServiceBuilder() {}

        private  String serviceName;
        private  int samplingRate;
        private  int sampleSize;


        public static ServiceBuilder aService() {
            return new ServiceBuilder();
        }

        public ServiceBuilder withName(final String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public ServiceBuilder withSamplingRate(final int samplingRate) {
            this.samplingRate = samplingRate;
            return this;
        }

        public ServiceBuilder withSampleSize(final int sampleSize) {
            this.sampleSize = sampleSize;
            return this;
        }

        public Service build() {
            final Service service = new Service();
            service.serviceName = this.serviceName;
            service.samplingRate = this.samplingRate;
            service.sampleSize = this.sampleSize;
            return service;
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public int getSamplingRate() {
        return samplingRate;
    }


    @Override
    public String toString() {
        return "Service{" +
                "serviceName='" + serviceName + '\'' +
                ", samplingRate=" + samplingRate +
                ", sampleSize=" + sampleSize +
                '}';
    }
}
