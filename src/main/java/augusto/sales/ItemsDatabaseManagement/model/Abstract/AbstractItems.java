package augusto.sales.ItemsDatabaseManagement.model.Abstract;


import augusto.sales.ItemsDatabaseManagement.model.Interface.ItemsEntity;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public class AbstractItems implements ItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "item", nullable = false, length = 100)
    private String item;

    @Column(name = "classification", nullable = false, length = 20)
    private String classification;

    protected AbstractItems() {
        super();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getItem() {
        return item;
    }

    @Override
    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String getClassification() {
        return classification;
    }

    @Override
    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(this.getClass().equals(object.getClass()))) {
            return false;
        }

        return Objects.equals(this.getId(), ((AbstractItems) object).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }


}
