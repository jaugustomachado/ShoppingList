package augusto.sales.ItemsDatabaseManagement.model;

import augusto.sales.ItemsDatabaseManagement.model.Abstract.AbstractItems;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(schema = "items_database", name = "items", uniqueConstraints =  { @UniqueConstraint(name = "uk_item", columnNames = "item") })
public class Items extends AbstractItems {

    public Items() {
        super();
    }

    public String toString() {
        return String.format("{ %s id=%d, item='%s', classification='%s'}",
                super.toString(),
                super.getId(),
                this.getItem(),
                this.getClassification()
        );
    }


}
