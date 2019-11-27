/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import Classes.User;
import Frames.*;
import Logic.methodsCity;
import Logic.*;

public class main {

    public static void main(String args[]) {
       methodsCity insert= methodsCity.getInstance();
       HashMethods has= HashMethods.getInstance();
       methodsOrders insertOr= methodsOrders.getInstance();
       
//       double x=100*60/60; 
//        System.out.print(x);
       int id= 206670027;
       String name= "Manuel";
       String license= "B4";       
       User newUser= new User(id, name, license);
       boolean value= has.put(newUser);
       
       int id1= 206670026;
       String name1= "Mario";
       String license1= "B2";       
       User newUser1= new User(id1, name1, license1);
       boolean value1= has.put(newUser1);
       
       int id12= 206670028;
       String name12= "Marco";
       String license12= "B4";       
       User newUser12= new User(id12, name12, license12);
       boolean value12= has.put(newUser12);
       
       int id123= 203670029;
       String name123= "Jacky";
       String license123= "B3";       
       User newUser123= new User(id123, name123, license123);
       boolean value123= has.put(newUser123);
       
       int id1234= 204670029;
       String name1234= "Carmen";
       String license1234= "B4";       
       User newUser1234= new User(id1234, name1234, license1234);
       boolean value1234= has.put(newUser1234);
       
       int id12345= 205670029;
       String name12345= "Luis";
       String license12345= "B3";       
       User newUser12345= new User(id12345, name12345, license12345);
       boolean value12345= has.put(newUser12345);
       
       int id123456= 205671029;
       String name123456= "Martineli";
       String license123456= "B3";       
       User newUser123456= new User(id123456, name123456, license123456);
       boolean value123456= has.put(newUser123456);
       
       int id1234567= 205611029;
       String name1234567= "Camilo";
       String license1234567= "B1";       
       User newUser1234567= new User(id1234567, name1234567, license1234567);
       boolean value1234567= has.put(newUser1234567);
       
       int id12345678= 205611329;
       String name12345678= "Arnold";
       String license12345678= "B2";       
       User newUser12345678= new User(id12345678, name12345678, license12345678);
       boolean value12345678= has.put(newUser12345678);
       
       //Insertar Ciudades 
       insert.insertCity("Alajuela");
       insert.insertCity("San Jóse");
       insert.insertCity("Cartago");
       insert.insertCity("San Ramón");
       insert.insertCity("Fortuna");
       insert.insertCity("Quepos");
       insert.insertCity("Paso Canoas");
       insert.insertCity("Perez Zeledón");
       insert.insertCity("Parrita");   
       insert.insertCity("Ciudad Quesada"); 
       
       //pruebas
       insert.insertCity("talamanca");
       insert.insertCity("puris");
       insert.insertCity("pital");
       insert.insertCity("peje viejo");
       
       //caminos de pruebas
       insert.insertRoad(insert.searchCity("Parrita"), insert.searchCity("talamanca"), "Carga Pesada", 3,100);
       insert.insertRoad(insert.searchCity("talamanca"), insert.searchCity("peje viejo"), "Carga Pesada", 4,100);
       insert.insertRoad(insert.searchCity("peje viejo"), insert.searchCity("Ciudad Quesada"), "Carga Pesada", 2,100);
       
       insert.insertRoad(insert.searchCity("Parrita"), insert.searchCity("puris"), "Carga Pesada", 5,100);
       insert.insertRoad(insert.searchCity("puris"), insert.searchCity("pital"), "Carga Pesada", 30,100);
       insert.insertRoad(insert.searchCity("pital"), insert.searchCity("Ciudad Quesada"), "Carga Pesada", 10,100);       
       insert.insertRoad(insert.searchCity("puris"), insert.searchCity("talamanca"), "Carga Pesada", 5,100);
  //     insert.insertRoad(insert.searchCity("Parrita"), insert.searchCity("Ciudad Quesada"), "Carga Pesada", 1,100);

       
       insert.insertRoad(insert.searchCity("San Jóse"), insert.searchCity("Quepos"), "Carga Pesada", 32,100);
       insert.insertRoad(insert.searchCity("San Jóse"), insert.searchCity("Fortuna"), "Carga Liviana", 32,100);
       insert.insertRoad(insert.searchCity("San Jóse"), insert.searchCity("Cartago"), "Carga Pesada", 32,100);
       insert.insertRoad(insert.searchCity("San Jóse"), insert.searchCity("Paso Canoas"), "Carga Liviana", 32,100);
       insert.insertRoad(insert.searchCity("San Jóse"), insert.searchCity("Parrita"), "Carga Pesada", 32,100);
       insert.insertRoad(insert.searchCity("San Jóse"), insert.searchCity("Alajuela"), "Carga Liviana", 32,100);
       insert.insertRoad(insert.searchCity("San Jóse"), insert.searchCity("Perez Zeledón"), "Carga Pesada", 32,100);
       
       insert.insertRoad(insert.searchCity("Cartago"), insert.searchCity("Quepos"), "Carga Liviana", 200,40);
       insert.insertRoad(insert.searchCity("Cartago"), insert.searchCity("Fortuna"), "Carga Pesada", 10,100);
       insert.insertRoad(insert.searchCity("Quepos"), insert.searchCity("San Ramón"), "Carga Pesada", 125,100);
       insert.insertRoad(insert.searchCity("Fortuna"), insert.searchCity("San Ramón"), "Carga Liviana", 21,100);
       insert.insertRoad(insert.searchCity("Fortuna"), insert.searchCity("Quepos"), "Carga Liviana", 500,100);
       
       //Caminos de Parrita
       
       insert.insertRoad(insert.searchCity("Parrita"), insert.searchCity("Quepos"), "Carga Pesada", 32,100);
       insert.insertRoad(insert.searchCity("Parrita"), insert.searchCity("Fortuna"), "Carga Pesada", 32,100);
       insert.insertRoad(insert.searchCity("Parrita"), insert.searchCity("Cartago"), "Carga Liviana", 32,100);
       insert.insertRoad(insert.searchCity("Parrita"), insert.searchCity("Paso Canoas"), "Carga Pesada", 32,100);
       insert.insertRoad(insert.searchCity("Parrita"), insert.searchCity("San Ramón"), "Carga Liviana", 32,100);
       insert.insertRoad(insert.searchCity("Parrita"), insert.searchCity("Alajuela"), "Carga Pesada", 32,100);
       insert.insertRoad(insert.searchCity("Parrita"), insert.searchCity("Perez Zeledón"), "Carga Pesada", 32,100);
       
       //Caminos de Alajuela
       
       insert.insertRoad(insert.searchCity("Alajuela"), insert.searchCity("Quepos"), "Malo", 32,100);
       insert.insertRoad(insert.searchCity("Alajuela"), insert.searchCity("Fortuna"), "Carga Liviana", 32,100);
       insert.insertRoad(insert.searchCity("Alajuela"), insert.searchCity("Cartago"), "Carga Pesada", 32,100);
       insert.insertRoad(insert.searchCity("Alajuela"), insert.searchCity("Paso Canoas"), "Carga Liviana", 32,100);
       insert.insertRoad(insert.searchCity("Alajuela"), insert.searchCity("San Jóse"), "Carga Pesada", 32,100);
       insert.insertRoad(insert.searchCity("Alajuela"), insert.searchCity("Parrita"), "Carga Liviana", 32,100);
       insert.insertRoad(insert.searchCity("Alajuela"), insert.searchCity("Perez Zeledón"), "Carga Pesada", 32,100);
       
       
       //Insertar envios
       //int idOrder, String originOrder, String destinitiOrder, int weightOrder
       insertOr.insertOrder(12, "Alajuela", "San Ramón", 5000, 203670029);
       insertOr.insertOrder(23, "Parrita", "San Jóse", 25000, 206670027);
       insertOr.insertOrder(14, "Fortuna", "San Jóse", 10000, 206670023);
       insertOr.insertOrder(21, "Cartago", "San Jóse", 200, 206670029);
       insertOr.insertOrder(31, "Paso Canoas", "San Jóse", 1500, 206670020);
       insertOr.insertOrder(28, "Perez Zeledón", "Quepos", 21000, 203670029);
       insertOr.insertOrder(15, "Cartago", "San Ramón", 5000, 206670026);
       insertOr.insertOrder(18, "Parrita", "Ciudad Quesada", 25000, 206670026);
       
       
       
            
    
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
                new Init().setVisible(true);
            }
        });
    }
}
