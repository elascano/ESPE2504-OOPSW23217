package ec.edu.espe.store.controller;

import ec.edu.espe.store.model.Store;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Mateo Unda
 */
public class Manage {
    private List<Stores> stores;

    public Manage() {
        stores = new ArrayList<>();
        
        stores.add(new Store(1, "MegaStore", 200.0, 5000.0));
        stores.add(new Store(2, "MiniStore", 100.0, 2000.0));
    }

    public Stores findStoreById(int id) {
        for (Stores stores : stores) {
            if (store.getId() == id) {
                return store;
            }
        }
        return null;
    }
}

}
