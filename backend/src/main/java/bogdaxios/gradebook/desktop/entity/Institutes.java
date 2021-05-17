package bogdaxios.gradebook.desktop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Institutes extends Base{
    private String name;
    private String rector;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRector() {
        return rector;
    }

    public void setRector(String rector) {
        this.rector = rector;
    }

    public Institutes() {
    }
}
