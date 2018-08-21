/*El robot crea un histograma a partir del número de Things que haya en cada puesto de una columna principal*/

package unal.poo.practica;

import becker.robots.*;

public class Ejercicio5{

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
    godel_e = new Robot(ciudad,0, 1, Direction.SOUTH, 0);

    //Se ejecuta el movimiento principal del problema
    mov_principal();
  }
  public static void mov_principal(){
    int histograma_large = 11; //El número de barras que tendrá el histograma
    mover_n_espacios(1);
    for(int ii=1; ii<=histograma_large; ii++){

      int numero_Things_parcial = cuenta_Things();
      if(numero_Things_parcial>1){
        girar_derecha(4);
        crea_subbarra(numero_Things_parcial);
        girar_abajo(2);
      }
      else if(numero_Things_parcial == 1){
        godel_e.putThing();
      }
    mover_n_espacios(1);
    }
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
}
