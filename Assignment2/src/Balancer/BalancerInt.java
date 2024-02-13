package Balancer;

import Stores.StoreInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface BalancerInt extends Remote {

    public void receiveItem(String type, double size) throws RemoteException;

    public ArrayList<String> balanceLoad(Item item) throws RemoteException;

    public void registerStore(StoreInterface store) throws RemoteException;

}
