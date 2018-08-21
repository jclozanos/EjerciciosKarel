/*El robot deberá mover las cosas (ladrillos) de un cuarto A otro recordando las posiciones exactas*/

package unal.poo.practica;

import becker.robots.*;
import java.lang.*;
import java.util.*;

public class Ejercicio6{

  //Declaracion de Variables -- Forma temporal - No es buena practica tener
  //variables estaticas
  public static City ciudad;
  public static Robot godel_e;

	public static void main (String[] args){
    //Declarar la creacion de la ciudad
    ciudad = new City("Field.txt");
    ciudad.showThingCounts(true);

    //Direction.NORTH, EAST, SOUTH, WEST
    //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
    godel_e = new Robot(ciudad, 5, 1, Direction.NORTH, 0);

    //Se ejecuta el movimiento principal del problema
    int[] arr_Things = new int[25];
    arr_Things = inicializaArrbool(arr_Things);
    arr_Things = mover_dentro_caja1(arr_Things);
    mover_entre_cajas();
    mover_dentro_caja2(arr_Things);
    mover_final();
  }
  public static int[] inicializaArrbool(int[] arr_Things){
    for(int ii=0; ii<=arr_Things.length-1; ii++){
      arr_Things[ii] = 0;
    }
    return arr_Things;
  }
  public static int cuenta_Things(){
    int cont = 0;
    while(godel_e.canPickThing()){
      godel_e.pickThing();
      cont++;
    }
    return cont;
  }
  public static void crea_subbarra(int numero_Things_parcial){
    godel_e.putThing();
    for(int ii=0; ii<=numero_Things_parcial-2; ii++){
      mover_n_espacios(1);
      godel_e.putThing();
    }
    girar_izquierda(1);
    mover_n_espacios(numero_Things_parcial-1);
  }
  public static void mover_n_espacios(int n){
    for(int ii=1; ii<=n; ii++){
      godel_e.move();
    }
  }
  public static void girar_abajo(int n){ //1=derecha, 2=izquierda, 3=arriba
    if(n == 1){
      for(int ii=1; ii<=3; ii++){
        godel_e.turnLeft();
      }
    }
    else if(n == 2){
      godel_e.turnLeft();
    }
    else if(n == 3){
      for(int ii=0; ii<=2; ii++){
        godel_e.turnLeft();
      }
    }
  }
  public static void girar_derecha(int n){ //2=izquierda, 3=arriba, 4=abajo
    if(n == 2){
      for(int ii=1; ii<=2; ii++){
        godel_e.turnLeft();
      }
    }
    else if(n == 3){
      for(int ii=1; ii<=3; ii++){
        godel_e.turnLeft();
      }
    }
    else if(n == 4){
      godel_e.turnLeft();
    }
  }
  public static void girar_arriba(int n){ //1=derecha, 2=izquierda, 4=abajo
    if(n == 1){
        godel_e.turnLeft();
    }
    else if(n == 2){
      for(int ii=1; ii<=3; ii++){
        godel_e.turnLeft();
      }
    }
    else if(n == 4){
      for(int ii=1; ii<=2; ii++){
        godel_e.turnLeft();
      }
    }
  }
  public static void girar_izquierda(int n){ //1=derecha, 3=abajo, 4=izquierda
    if(n == 1){
      for(int ii=1; ii<=2; ii++){
        godel_e.turnLeft();
      }
    }
    else if(n == 3){
        godel_e.turnLeft();
    }
    else if(n == 4){
      for(int ii=1; ii<=3; ii++){
        godel_e.turnLeft();
      }
    }
  }
  public static void girar_derechas(){
    for(int ii=1; ii<=3; ii++){
      godel_e.turnLeft();
    }
  }
  public static int[] mover_dentro_caja1(int[] arr_Things){
    for(int ii=0; ii<=arr_Things.length-1; ii++){
      if(ii == 4 || ii == 8 || ii == 12 || ii == 15 || ii == 18 || ii == 20 || ii == 22 || ii == 23){
        girar_derechas();
      }
      if(ii<24){
        godel_e.move();
      }
      while(godel_e.canPickThing()){
        godel_e.pickThing();
        arr_Things[ii]++;
      }
    }
    return arr_Things;
  }
  public static void mover_dentro_caja2(int[] arr_Things){
    for(int ii=0; ii<=arr_Things.length-1; ii++){
      if(ii == 4 || ii == 8 || ii == 12 || ii == 15 || ii == 18 || ii == 20 || ii == 22 || ii == 23){
        girar_derechas();
      }
      if(ii<24){
        godel_e.move();
      }
      while(arr_Things[ii]>0){
        godel_e.putThing();
        arr_Things[ii]--;
      }
    }
  }
  public static void mover_entre_cajas(){
    girar_izquierda(3);
    mover_n_espacios(2);
    girar_abajo(2);
    mover_n_espacios(10);
    girar_derecha(4);
    mover_n_espacios(10);
    girar_arriba(1);
    mover_n_espacios(1);
  }
  public static void mover_final(){
    girar_izquierda(3);
    mover_n_espacios(2);
    girar_abajo(2);
    mover_n_espacios(3);
  }
}
