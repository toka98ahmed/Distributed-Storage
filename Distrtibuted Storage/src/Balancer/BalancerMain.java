package Balancer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BalancerMain {

    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1099);
        BalancerImp obj = new BalancerImp();
        reg.rebind("LoadBalancer", obj);
        BalancerImp.balancer_gui.setVisible(true);
    }

}
