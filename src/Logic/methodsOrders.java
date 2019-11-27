/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Classes.City;
import Classes.Orders;
import Frames.Routescreate;
import java.awt.HeadlessException;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class methodsOrders{
    
    public Orders root;
    methodsCity met= methodsCity.getInstance();
    
    public static methodsOrders instance = null;

    public static methodsOrders getInstance() {
        if (instance == null) {
            instance = new methodsOrders();
        }
        return instance;
    }
    
    
    public boolean insertOrder(int idOrder, String originOrder, String destinitiOrder, int weightOrder, int idUser){
    
        Orders newOrder= new Orders(idOrder,originOrder,destinitiOrder,weightOrder, idUser);
        if(root==null){
            root = newOrder;
            return true;
            
        }else{            
            Orders aux= root;
            Orders father;
            while(true){
                father=aux;
                if(idOrder==aux.idOrder){
                    return false;
                }
                if(idOrder<aux.idOrder){
                    aux=aux.left;
                    if(aux==null){
                        father.left=newOrder;
                        return true;
                    }
                    
                }else{
                    aux=aux.rigth;
                    if(aux==null){
                        father.rigth=newOrder;
                        return true;
                    }                    
                }                
            }
        }  
    }
    
    public int editOrder(int id){        
        
        Orders edit= searchOrder(root, id);
        if(edit!=null){
            Scanner sn = new Scanner(System.in);
            boolean exit = false;
            int dat;

            while (!exit){                
                dat = Integer.parseInt(JOptionPane.showInputDialog("1) Deseas modificar el id del pedido: \n" + "2) Desea modificar el origen : \n"
                    + "" + "3) Desea modificar el destino : \n" + "4) Desea modificar el peso : \n" + "5)Salir"));
                switch (dat){
                    case 1:
                        String idO = JOptionPane.showInputDialog("Digite el nuevo id de pedido");                        
                        try{
                            
                            int idorde= Integer.parseInt(idO);
                            String origin= edit.originOrder;
                            String desiniti= edit.destinitiOrder;
                            int weight= edit.weightOrder;
                            int idUser= edit.idUser;
                            boolean delete= deleteOrder(id);
                            if(delete==true){
                                boolean insert= insertOrder(idorde, origin, desiniti, weight, idUser);
                                if(insert== true){
                                    return 1; 
                                }                                       
                            }                           
                        }   
                        catch(HeadlessException | NumberFormatException e){
                            return 2;
                        }
                        
                    case 2:
                        String orig = JOptionPane.showInputDialog("Digite el nuevo origen: ");
                        City ori= met.searchCity(orig);                        
                        if(ori!=null){
                            
                            if(edit.destinitiOrder.equals(orig)){
                                return 6;
                            }
                            edit.originOrder= orig;
                            return 1;
                        }
                        return 4;
                        
                    case 3:
                        String dest = JOptionPane.showInputDialog("Digite el nuevo destino: ");
                        City desti= met.searchCity(dest);                        
                        if(desti!=null){
                            if(edit.originOrder.equals(dest)){
                                return 6;
                            }
                            edit.destinitiOrder= dest;
                            return 1;
                        }
                        return 5; 
                    case 4:
                        String wei = JOptionPane.showInputDialog("Digite el nuevo peso: ");
                        try{
                            int weight= Integer.parseInt(wei);
                            edit.weightOrder=weight;
                            return 1;
                        }
                        catch(HeadlessException | NumberFormatException e){
                            return 7;
                        }
                    case 5:
                        exit = true;
                        break;
                    default:
                        JOptionPane.showInputDialog("Solo se aceptan las opciones anteriores ");
                        return 8;
                    }
                }
               
        }else{
            return 3;
        }
    return 1;
    }
    
    public Orders searchOrder(Orders aux, int idOrder){
        
        while(aux.idOrder!=idOrder){           
            if(idOrder<aux.idOrder){
                aux=aux.left;
            }else{
                aux=aux.rigth;
            }
            if(aux==null){
                return null;
            }
        }return aux;
    }
    
    public boolean deleteOrder(int id){
        Orders aux=root;
        Orders father=root;
        boolean orderLeft=true;
        while(aux.idOrder!=id){        
            father=aux;
            if(id<aux.idOrder){
                orderLeft=true;
                aux=aux.left;
            }else{

                orderLeft=false;
                aux=aux.rigth;
            }
            if(aux==null){
                return false;
            }        
        }
        if(aux.left==null && aux.rigth==null){
            if(aux==root){
                root=null;
            }else if(orderLeft){
                father.left=null;
            }else{
                father.rigth=null;
            }
        }else if(aux.rigth== null){
            if(aux==root){
                root=aux.left;
            }else if(orderLeft){
                father.left=aux.left;
            }else{
                father.rigth=aux.left;
            }
        }else if(aux.left== null){
            if(aux==root){
                root=aux.rigth;
            }else if(orderLeft){
                father.left=aux.rigth;
            }else{
                father.rigth=aux.left;
            }
        }else{
            Orders replace= orderReplace(aux);
            if(aux==root){
                root=replace;
            }else if(orderLeft){
                father.left= replace;            
            }else{
                father.rigth=replace;
            }
            replace.left=aux.left;    
        }
        return true;   
    }
    
    
    
    public Orders orderReplace(Orders nodeRep){

        Orders replaceFather=nodeRep;
        Orders replace= nodeRep;
        Orders aux= nodeRep.rigth;

        while(aux!=null){
            replaceFather=replace;
            replace=aux;
            aux=aux.left;
        }
        if(replace!=nodeRep.rigth){
            replaceFather.left=replace.rigth;
            replace.rigth=nodeRep.rigth;
        }return replace;   
    }
}
