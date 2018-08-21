/*El robot recoje las cajas de cada fila y las ordena de derecha a izquierda*/

package unal.poo.practica;

import becker.robots.*;
import java.lang.*;
import java.util.*;

public class Ejercicio7{

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
    godel_e = new Robot(ciudad, 10, 1, Direction.NORTH, 0);

    //Se ejecuta el movimiento principal del problema
    int[] arr_Pos = new int[10];
    arr_Pos = inicializaArrint(arr_Pos);
    mover_n_espacios(1);
    arr_Pos = mover_en_columna1(arr_Pos);
    mover_entre_columnas();
    mover_en_columna2(arr_Pos);
  }
  public static int[] inicializaArrint(int[] arr_Pos){
    for(int ii=0; ii<=arr_Pos.length-1; ii++){
      arr_Pos[ii] = 0;
    }
    return arr_Pos;
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
  public static int contar_en_fila(){
    int parcial = 0;
    for(int ii=1; ii<=10; ii++){
      if(godel_e.canPickThing()){
        godel_e.pickThing();
        parcial++;
      }
      if(ii < 10){
        godel_e.move();
      }else if(ii == 10){
        girar_izquierda(1);
        mover_n_espacios(9);
      }
    }
    return parcial;
  }
  public static int[] mover_en_columna1(int[] arr_Pos){
    for(int ii=0; ii<=9; ii++){
      girar_derecha(3);
      arr_Pos[ii] = contar_en_fila();
      girar_arriba(2);
      mover_n_espacios(1);
    }
    return arr_Pos;
  }
  public static void mover_entre_columnas(){
    girar_derecha(3);
    mover_n_espacios(9);
    girar_abajo(1);
    mover_n_espacios(1);
  }
  public static void mover_en_columna2(int[] arr_Pos){
    for(int ii=0; ii<=9; ii++){
      int temp = arr_Pos[9-ii];
      girar_izquierda(4);
      while(arr_Pos[9-ii] > 0){
        godel_e.putThing();
        arr_Pos[9-ii]--;
        if(arr_Pos[9-ii] > 0){
          godel_e.move();
        }
      }
      girar_derecha(2);
      mover_n_espacios(temp-1);
      girar_abajo(1);
      mover_n_espacios(1);
    }
  }
}
