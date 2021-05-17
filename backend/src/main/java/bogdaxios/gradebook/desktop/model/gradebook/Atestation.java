package bogdaxios.gradebook.desktop.model.gradebook;

import java.sql.Timestamp;

public class Atestation {
    private Timestamp date;
    private String name;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Atestation() {
    }
}
