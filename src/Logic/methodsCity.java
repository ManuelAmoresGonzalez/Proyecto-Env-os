
package Logic;
import Classes.*;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class methodsCity {
    
    
    
    public static methodsCity instance = null;    

    public static methodsCity getInstance() {
        if (instance == null) {
            instance = new methodsCity();
        }
        return instance;
    }
    
    public City iniCity, finCity, global;
    
    public boolean insertCity(String nameCity){
        
        City newCity= new City(nameCity);
        global= newCity;
        if(iniCity==null){
            iniCity= finCity =newCity;
            return true;
        }
        City search= searchCity(newCity.nameCity);
        if(search!=null){
            return false;             
        }        
        newCity.sigC= iniCity;
        iniCity=newCity;
        return true;      
    }
    
    public City searchCity(String name){
        
        City auxI= iniCity;
        City auxF= finCity;
    
        if(auxI.nameCity.equals(name)){
            return auxI;
        }
        if(auxF.nameCity.equals(name)){
            
            return auxF;
        }
        while(auxI.sigC!=null){
            if(!auxI.nameCity.equals(name)){
                auxI= auxI.sigC;
            }else{
                return auxI;
            }            
        }
    return null;    
    }
    
    public boolean editCity(City city){       
        
        
            Scanner sn = new Scanner(System.in);
            boolean exit = false;
            int dat;

            while (!exit) {
                //String nameUser, String password, String country, String city, String id, String name, String firstSurname, String secondSurname
                dat = Integer.parseInt(JOptionPane.showInputDialog("1) Desea modificar el nombre: \n" +"2)Salir: "));

                switch (dat) {
                    case 1:
                        String name = JOptionPane.showInputDialog("Ingrese el nuevo nombre: ");                        
                            city.nameCity = name;
                            return true;
                         
                    case 2:
                        exit = true;
                        break;
                    default:
                        JOptionPane.showInputDialog("Solo se aceptan las opciones anteriores ");
                        return false;
                }
            }    
        return false;
        }
    
    public boolean deleteCity(City delete) {
       
        City aux = iniCity;
        City ant = iniCity;
        while (aux != null){ 
            deleteRoad(aux, delete);  

           
            if (aux.sigC!=null && aux.sigC.equals(delete)) {
                ant = aux;
            }
            aux = aux.sigC;
        }//eliminar el vertice
        if (delete.equals(iniCity)) { //si es el primero
            iniCity = delete.sigC;
        }
        ant.sigC = delete.sigC;
        return true;
    }
    
    public boolean insertRoad(City origin, City destination, String typeRoad, int roadDistance, int maxSpeed) {
            if (searchRoad(origin, destination) == null) {
                Road newRoad = new Road(typeRoad, roadDistance, maxSpeed);
                newRoad.destination = destination;
                if (origin.rutRoad == null) {
                    origin.rutRoad = newRoad;
                    return true;
                } else {
                    newRoad.sigR = origin.rutRoad;                
                    origin.rutRoad.antR = newRoad;
                    origin.rutRoad= newRoad;
                    return true;                    
                }          
            }
            return false;
        }

    public Road searchRoad(City origin, City destination){
        if (origin.rutRoad != null){
            Road aux = origin.rutRoad;
            while (aux!=null) {
                if (aux.destination == destination) {
                    return aux;
                }
                aux= aux.sigR;
            }
        }
        return null;
    }


     public boolean modifiRoad(City origin, City destiniti){
            City ori= searchCity(origin.nameCity);
            City desti= searchCity(destiniti.nameCity);
            if(ori!=null && desti==null){
                JOptionPane.showMessageDialog(null, "El destino ingresado no se encuentra");
                return false;
            }
            else if(ori==null && desti!=null){
                JOptionPane.showMessageDialog(null, "El origen ingresado no se encuentra");
                return false;
            }
            else if(ori==null && desti==null){
                JOptionPane.showMessageDialog(null, "Ninguno de los dos se encuentran");
                return false;
            }
            Road value= searchRoad(origin, destiniti);
            Scanner sn = new Scanner(System.in);
            boolean exit = false;
            int dat;

            while (!exit) {
                //String nameUser, String password, String country, String city, String id, String name, String firstSurname, String secondSurname
                dat = Integer.parseInt(JOptionPane.showInputDialog("1) Deseas modificar el tipo del camino: \n" + "2) Desea modificar la distancia del camino: \n"
                        + "" + "3) Desea modificar la velocidad maxima: \n" + "4)Salir"));

                switch (dat) {
                    case 1:
                        String road = JOptionPane.showInputDialog("Digite el tipo del camino: \n" + "Son dos tipos: \n"+ "Carga Pesada \n"+ "Carga Liviana");
                        if(road.equals("Carga Pesada") || road.equals("Carga Liviana")){
                            value.typeRoad = road;
                            return true;
                        }else{
                            JOptionPane.showInputDialog("Solo se aceptan las opciones anteriores de camino ");
                        }
                    case 2:
                        int dist = Integer.parseInt(JOptionPane.showInputDialog("Digite la nueva distancia: "));
                        value.roadDistance = dist;
                        return true;
                    case 3:
                        int velmax = Integer.parseInt(JOptionPane.showInputDialog("Digite la nueva velocidad: "));
                         value.maxSpeed = velmax;
                        return true;                
                    case 4:
                        exit = true;
                        break;
                    default:
                        JOptionPane.showInputDialog("Solo se aceptan las opciones anteriores ");
                        return false;
                }
            }
            return true;
        }

     
    public boolean deleteRoad(City origin, City destiniti){
        
        Road road= searchRoad(origin, destiniti);
        if(road!=null){
            if(origin.rutRoad== road){
                if (origin.rutRoad.sigR!=null){ //si hay otro nodo
                    road.sigR.antR = null;
                    origin.rutRoad=road.sigR;
                    return true;
                }else{
                origin.rutRoad = road.sigR;
                return true;
                }
            }            
            if (road.sigR!=null){
                road.sigR.antR = road.antR;
                return true;
            }
            road.antR.sigR = road.sigR;
            return true;
        }
        return false;      
     }
    
     
   
    
}
