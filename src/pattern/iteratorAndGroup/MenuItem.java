package pattern.iteratorAndGroup;

public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetable;
    double price;

    public MenuItem(String name, String description, boolean vegetable, double price) {
        this.name = name;
        this.description = description;
        this.vegetable = vegetable;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVegetable() {
        return vegetable;
    }

    public void setVegetable(boolean vegetable) {
        this.vegetable = vegetable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void print() {
        System.out.println(""+getName());
        if(isVegetable()){
            System.out.println("(v)");
        }
        System.out.println(","+price);
        System.out.println(" --"+description);
    }
}
