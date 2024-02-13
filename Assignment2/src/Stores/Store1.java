package Stores;

import Balancer.Item;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Store1 extends UnicastRemoteObject implements StoreInterface {

    double size;
    String storeNumber = "Store1";

    public Store1(double size) throws RemoteException {
        this.size = size;
    }

    @Override
    public double getSize() throws RemoteException {
        return size;
    }

    @Override
    public String getStoreNumber() throws RemoteException {
        return storeNumber;
    }

    @Override
    public void receiveLoad(Item item) throws RemoteException {
        String data[] = {Integer.toString(item.getId()), item.getType(), Double.toString(item.getSize())};
        Store1_GUI.updateTable(data, item.getSize());
    }

}
