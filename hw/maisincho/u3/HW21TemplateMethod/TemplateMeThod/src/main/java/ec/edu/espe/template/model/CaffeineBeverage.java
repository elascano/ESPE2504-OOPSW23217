package ec.edu.espe.template.model;

/**
 *
 * @author Isaac Maisincho Crafters_Market DCCO ESPE
 */
public abstract class CaffeineBeverage {

    public void prepareRecipe() {//Templete Method
        boilWater();
        brew();
        pourInCup();
        if (wantsCondiments()) {
            addCondiments();
        }
    }

    void boilWater() {
        System.out.println("Boling water");
    }

    abstract void brew();

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    abstract void addCondiments();

    boolean wantsCondiments() {
        return true;
    }

}
