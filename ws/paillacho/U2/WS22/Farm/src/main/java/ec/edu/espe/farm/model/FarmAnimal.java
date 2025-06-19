package ec.edu.espe.farm.model;

/**
 *
 * @author Carlos Paillacho
 */


public abstract class FarmAnimal {
    private int id;
    private String breed;
    private Date bornOn;
    
    
    public FarmAnimal(int id, String breed, Date bornOn){
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
    }
}

    
   