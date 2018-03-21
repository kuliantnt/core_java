package Temp.ProxyTest;

public interface Owner {
    /**
     * @param tenantName 承租人姓名
     * @return 时候租赁
     */
    Boolean rentHouse()throws InterruptedException;

    void cleanHouse() throws InterruptedException;

    void decorateHouse() throws InterruptedException;

    void sleepWithGirls() throws InterruptedException;

}
