# Distributed-Storage

The system comprises a **Generator**, a **Balancer**, and a set of **Stores**. The Generator generates and send to the Balancer a sequence of items to be stores. The Balancer distributes the items to the Stores, which connects to it clients.

This project was implemented using Java's RMI.
