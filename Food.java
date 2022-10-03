import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Food implements Consumable {
    protected String name = null;

    public Food(String name) {
        this.name = name;
    }

    public Food(){
        name = null;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                '}' + "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Food)) {
            return false;
        }
        if (name==null || ((Food)arg0).name==null) {
            return false;
        }
        return name.equals(((Food)arg0).name);
    }

    public void Print(){

    }

}
