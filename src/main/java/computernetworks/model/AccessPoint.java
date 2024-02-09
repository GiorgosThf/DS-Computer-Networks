package computernetworks.model;

import java.util.ArrayList;
import java.util.List;

public class AccessPoint {
    private  int numberOfServices;
    private  int accessPointCapacity;
    private  List<Service> services;

    private AccessPoint(){}

    public static final class AccessPointBuilder{
        private AccessPointBuilder() {}

        private int numberOfServices;
        private List<Service> services = new ArrayList<>();
        private int accessPointCapacity;

        public static AccessPointBuilder anAccessPoint() {
            return new AccessPointBuilder();
        }

        public AccessPointBuilder withNumberOfServices(final int numberOfServices) {
            this.numberOfServices = numberOfServices;
            return this;
        }

        public AccessPointBuilder withService(final Service service) {
            this.services.add(service);
            return this;
        }

        public AccessPointBuilder withServicesList(final List<Service> services){
            this.services.addAll(services);
            return this;
        }
        public AccessPointBuilder withAccessPointCapacity(final int accessPointCapacity){
            this.accessPointCapacity = accessPointCapacity;
            return this;
        }

        public AccessPoint build() {
            final AccessPoint accessPoint = new AccessPoint();
            accessPoint.numberOfServices = this.numberOfServices;
            accessPoint.services = this.services;
            accessPoint.accessPointCapacity = this.accessPointCapacity;
            return accessPoint;
        }
    }

    public int getNumberOfServices() {
        return numberOfServices;
    }

    public int getAccessPointCapacity() {
        return accessPointCapacity;
    }

    public List<Service> getServices() {
        return services;
    }

    @Override
    public String toString() {
        return "AccessPoint{" +
                "numberOfServices=" + numberOfServices +
                ", accessPointCapacity=" + accessPointCapacity +
                ", services=" + services +
                '}';
    }


}
