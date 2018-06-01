package extend.proxyTest;

public interface Owner {

    /**
     * @return 时候租赁
     */
    Boolean rentHouse() throws InterruptedException;

    void cleanHouse() throws InterruptedException;

    void decorateHouse() throws InterruptedException;

    void sleepWithGirls() throws InterruptedException;

}
