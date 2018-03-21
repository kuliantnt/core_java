package Temp.ProxyTest;

public class ProxyTestCenter {
    public static void main(String[] args) throws InterruptedException {
        //房东
        HouseOwner houseOwner = new HouseOwner("包租婆");
        //中介
        HouseOwnerProxy proxy = new HouseOwnerProxy(houseOwner);
        //生产代理类
        Owner owner = proxy.getOwnerProxy();

        owner.rentHouse();
        owner.cleanHouse();
        owner.decorateHouse();
        owner.sleepWithGirls();

    }
}
