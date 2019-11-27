
package Classes;


public class Orders {
    
    public int idOrder;
    public String originOrder;
    public String destinitiOrder;
    public int weightOrder;
    public int idUser;
    public Orders left,rigth;
    
    public Orders(int idOrder, String originOrder, String destinitiOrder, int weightOrder, int idUser){
        
        this.idOrder= idOrder;
        this.originOrder= originOrder;
        this.destinitiOrder= destinitiOrder;
        this.weightOrder= weightOrder;
        this.idUser= idUser;
        
    }
    
}
