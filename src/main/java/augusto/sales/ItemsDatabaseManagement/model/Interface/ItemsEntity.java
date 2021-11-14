package augusto.sales.ItemsDatabaseManagement.model.Interface;

import java.io.Serializable;

public interface ItemsEntity extends Serializable {

    Long getId();

    void setId(Long id);

    String getItem();

    void setItem(String item);

    String getClassification();

    void setClassification(String classification);
}
