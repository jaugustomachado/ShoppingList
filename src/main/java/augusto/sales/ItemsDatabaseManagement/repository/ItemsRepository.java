package augusto.sales.ItemsDatabaseManagement.repository;

import augusto.sales.ItemsDatabaseManagement.model.Items;
import augusto.sales.ItemsDatabaseManagement.repository.Interface.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ItemsRepository extends Repository<Items> {

    @Query("SELECT t FROM Items t WHERE t.item LIKE %?1%")
    List<Items> findByItem(String item);

    @Query("SELECT t FROM Items t WHERE t.item LIKE %?1%")
    Items findByPurchase(String item);

}

