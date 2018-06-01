package extend.proxyTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HouseOwner implements Owner {

    private String ownerName;

    public HouseOwner(String ownerName) {
        this.ownerName = ownerName;

    }

    @Override
    public Boolean rentHouse() throws InterruptedException {
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        return Boolean.TRUE;
    }

    @Override
    public void cleanHouse() throws InterruptedException {
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
    }

    @Override
    public void decorateHouse() throws InterruptedException {
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
    }

    @Override
    public void sleepWithGirls() throws InterruptedException {
        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
    }

    public String findHouseOwnerName() {
        return ownerName;
    }
}
