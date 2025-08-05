/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.mavenproject1;

/**
 *
 * @author Kevin Vaca Edison's OOP ESPE
 */
public abstract class CaffeineBeverage {

public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (wantsCondiments()) {
            addCondiments();
        }
    }
    
    // Common implementation for all beverages
    private void boilWater() {
        System.out.println("Boiling water");
    }
    
    // Common implementation for all beverages
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }
    
    // Primitive operations to be implemented by subclasses
    protected abstract void brew();
    protected abstract void addCondiments();
    
    // Hook - subclasses can override if needed
    protected boolean wantsCondiments() {
        return true;
    }
}
