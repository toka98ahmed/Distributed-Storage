
package Stores;

import Balancer.Item;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface StoreInterface extends Remote{
    
    public void receiveLoad(Item item) throws RemoteException;
    public double getSize() throws RemoteException;
    public String getStoreNumber() throws RemoteException;
    
}
