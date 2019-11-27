
package Classes;


public class Road {
    
    public String typeRoad;
    public int roadDistance;
    public int maxSpeed;
    public Road sigR,antR;
    public City destination;
    
    
    public Road(String typeRoad, int roadDistance, int maxSpeed){
        
        this.typeRoad=typeRoad;
        this.roadDistance= roadDistance;
        this.maxSpeed= maxSpeed;
    }    
}
