package augusto.sales.ItemsDatabaseManagement.repository.Interface;

import augusto.sales.ItemsDatabaseManagement.model.Abstract.AbstractItems;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository<T extends AbstractItems> extends JpaRepository<T, Long> {
}