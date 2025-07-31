package ec.edu.espe.templatemethod.model;

/**
 *
 * @author Bonilla David SoftCrafters
 */
public abstract class CaffeineBeverage {

    public void prepareRecipe() {
        boilWater();
        brew();
        pourlnCup();
        if (wantsCondiments()) {
            addCondiments();
        }
    }

    void boilWater() {
        System.out.println("Boiling water");
    }

    abstract void brew();

    void pourlnCup() {
        System.out.println("Pouring into cup");
    }

    abstract void addCondiments();

    boolean wantsCondiments() {
        return true;
    }
}
