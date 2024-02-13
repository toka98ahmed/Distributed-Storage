/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

import Balancer.Item;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Store2 extends UnicastRemoteObject implements StoreInterface {

    double size;
    String storeNumber = "Store2";

    public Store2(double size) throws RemoteException {
        this.size = size;
    }

    @Override
    public double getSize() throws RemoteException {
        return size;
    }

    @Override
    public void receiveLoad(Item item) throws RemoteException {
        String data[] = {Integer.toString(item.getId()), item.getType(), Double.toString(item.getSize())};
        Store2_GUI.updateTable(data, item.getSize());
    }

    @Override
    public String getStoreNumber() throws RemoteException {
        return storeNumber;
    }
}
