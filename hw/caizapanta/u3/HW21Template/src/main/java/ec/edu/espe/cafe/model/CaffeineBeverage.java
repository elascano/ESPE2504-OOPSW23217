package ec.edu.espe.cafe.model;

/**
 * 
 * @author Tammy Caizapanta
 */

public abstract class CaffeineBeverage {
    
    public void prepareRecipe(){ //template method
        boilWater();
        brew();
        pourInCup();
        if(wantsCondiments()){
            addCondiments();
        }
    }
    
    void boilWater(){
        System.out.println("Boiling water");
    }
    
    abstract void brew();
    
    void pourInCup(){
        System.out.println("Pouring into cup\n");
    }
    
    abstract void addCondiments();
    
    boolean wantsCondiments(){
        return true;
    }
}