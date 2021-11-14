package augusto.sales.ItemsDatabaseManagement.service;


import augusto.sales.ItemsDatabaseManagement.exception.ItemNotFoundException;
import augusto.sales.ItemsDatabaseManagement.model.Items;
import augusto.sales.ItemsDatabaseManagement.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemsService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(final ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }


    @Transactional
    public List<Items> lisItem(final String item) {
        if(item!=null && !item.trim().isEmpty()) {
            return this.itemsRepository.findByItem(item);
        } else {
            return this.itemsRepository.findAll();
        }
    }

    @Transactional
    public Items get(final Long id) {
        return this.itemsRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }

    @Transactional
    public String delete(final Long id) {
        this.itemsRepository.delete(
                this.itemsRepository.findById(id)
                        .orElseThrow(() -> new ItemNotFoundException("Item not found")));
        return "Item Deleted";
    }

    @Transactional
    public String save(final Items item) {
        this.itemsRepository.save(item);
        return "Item saved";
    }

    @Transactional
    public Items update(final Long id, final Items updatedItem) {
        return this.itemsRepository.findById(id).map(item -> {
                    item.setItem(updatedItem.getItem());
                    item.setClassification(updatedItem.getClassification());

                    return this.itemsRepository.save(item);
        }).orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }

}
