package Balancer;

import Stores.StoreInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BalancerImp extends UnicastRemoteObject implements BalancerInt {

    static BalancerGUI balancer_gui = new BalancerGUI();
    Random rand = new Random();
    ArrayList<StoreInterface> storeList = new ArrayList<>();

    public BalancerImp() throws RemoteException {
    }

    @Override
    public void receiveItem(String type, double size) throws RemoteException {
        Item item = new Item(rand.nextInt(), type, size);
        ArrayList<String> Stores = balanceLoad(item);
        String data[] = {Integer.toString(item.getId()), item.getType(), Double.toString(item.getSize()), Stores.toString()};
        balancer_gui.updateTable(data);
    }

    @Override
    public ArrayList<String> balanceLoad(Item item) throws RemoteException {
        ArrayList<String> Stores = new ArrayList<>();
        if (storeList.size() == 1) {
            storeList.get(0).receiveLoad(item);
            Stores.add(storeList.get(0).getStoreNumber());
            switch (storeList.get(0).getStoreNumber()) {
                case "Store1":
                    balancer_gui.updateStoreOneProgress(item.getSize());
                    break;
                case "Store2":
                    balancer_gui.updateStoreTwoProgress(item.getSize());
                    break;
                default:
                    balancer_gui.updateStoreThreeProgress(item.getSize());
                    break;
            }
        } else {
            Collections.shuffle(storeList);
            storeList.get(0).receiveLoad(item);
            storeList.get(1).receiveLoad(item);
            Stores.add(storeList.get(0).getStoreNumber());
            Stores.add(storeList.get(1).getStoreNumber());

            ////////////////////////////////////////////
            switch (storeList.get(0).getStoreNumber()) {
                case "Store1":
                    balancer_gui.updateStoreOneProgress(item.getSize());
                    break;
                case "Store2":
                    balancer_gui.updateStoreTwoProgress(item.getSize());
                    break;
                default:
                    balancer_gui.updateStoreThreeProgress(item.getSize());
                    break;
            }
            switch (storeList.get(1).getStoreNumber()) {
                case "Store1":
                    balancer_gui.updateStoreOneProgress(item.getSize());
                    break;
                case "Store2":
                    balancer_gui.updateStoreTwoProgress(item.getSize());
                    break;
                default:
                    balancer_gui.updateStoreThreeProgress(item.getSize());
                    break;
            }
        }
        return Stores;
    }

    @Override
    public void registerStore(StoreInterface store) throws RemoteException {
        storeList.add(store);
        balancer_gui.showIcon(store.getStoreNumber());
    }
}
