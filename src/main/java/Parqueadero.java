import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Parqueadero {
    Scanner lectura = new Scanner(System.in);

    public static void main(String[] args) {
        int filas;
        int columnas;
        Scanner lectura = new Scanner(System.in);
        List<Ingreso> registroIngreso;

        /*
        Solicitar el tamaño del parqueadero segun las filas y las columnas
         */

        System.out.println("\t\n Bienvenido al parqueadero UniPark");
        System.out.print("Ingresa el numero de filas >> ");
        filas = lectura.nextInt();

        lectura.nextLine();
        System.out.print("Ingresa el numero de columnas >> ");
        columnas = lectura.nextInt();

        // se crea el estacionamiento con los lugares dados en un metodo
        String [][] estacionamientos = new String[filas][columnas];
        crearPuestos(estacionamientos);

        // Se ingresa al menu para el usuario

        menu(estacionamientos);

    }

    public static void menu (String [][] lugares){

        Scanner lectura = new Scanner(System.in);
        int opcionMenu;

        do{
            System.out.println("\n\tIngrese la opcion requerida:\n");
            System.out.print(
                    "1 Ingresar vehiculo\n" +
                            "2 Consultar lugares disponibles\n" +
                            "3 Retirar vehiculon\n" +
                            "4 salir\n" +
                            ">> ");
            opcionMenu = lectura.nextInt();
            lectura.nextLine();
            
            switch (opcionMenu){
                case 1:
                    System.out.println("\tIngresar un vehiculo");
                    ingresoVehiculo();
                    break;
                    
                case 2:
                    System.out.println("\tConsultar lugares disponibles\n");
                    mostrarLugaresLibres(lugares);
                    break;
                case 3:
                    System.out.println("\tRetirar vehiculo");
                    retirarVehiculo();
                    break;
                case 4:
                    System.out.println("\tGracias por usar nuestros servicios\n" +
                            "Vuelve pronto!!!! ;)");
                    break;
                default:
                    System.out.println("Error\nIngresa una opcion correcta.");
            }
        }while (opcionMenu != 4);
    }

    private static Vehiculo ingresoVehiculo() {
        Scanner lectura = new Scanner(System.in);

        System.out.print("Ingrese la placa del vehiculo >> ");
        String placa = lectura.nextLine();
        System.out.print("Ingrese la marca del vehiculo >> ");
        String marca = lectura.nextLine();
        System.out.print("Ingrese el modelo >> ");
        String modelo = lectura.nextLine();

        Vehiculo vehiculo = new Vehiculo(placa,marca,modelo);

        System.out.println("\n\tIngrese los datos del dueño");
        System.out.print("Nombre >> ");
        String nombre = lectura.nextLine();
        System.out.print("Ingresa la cedula");
        String cedula = lectura.nextLine();
        System.out.print("Ingresa el celular >>");
        String celular = lectura.nextLine();

        Propietario propietario = new Propietario(nombre, cedula, celular);

        System.out.println("\t\nDigite el lugar donde va a aparcar ");
        System.out.print("Fila >> ");
        int poscicionFila = lectura.nextInt();
        lectura.nextLine();
        System.out.print("Columna >> ");
        int poscicionColumna = lectura.nextInt();


        long tMinTotal = System.currentTimeMillis() / (60 * 1000);
        int tMinCurrent = (int) (tMinTotal % (24 * 60));
        int hours = tMinCurrent / 60;
        int minutes = tMinCurrent % 60;

        System.out.println("Hora: "+ hours);
        System.out.println("Minutos "+ minutes);



        return vehiculo;

    }

    private static void retirarVehiculo() {
    }

    /**
     * Consulta y muestra los lugares diponibles en el parqueadero
     * @param lugaresEstacionamiento
     */
    private static void mostrarLugaresLibres(String[][] lugaresEstacionamiento) {

        for (int i = 0; i < lugaresEstacionamiento.length; i++) {
            for (int j = 0; j < lugaresEstacionamiento[0].length; j++) {
                System.out.print(lugaresEstacionamiento[i][j]);
            }
            System.out.println();
        }


    }

    /**
     * Metodo que crea las posiciones de la matriz del parqueadero
     * @param lugares es una matriz con los tamaños dados pero vacios
     * @return Una matriz con los espacios creados
     */
    public static String[][] crearPuestos(String [][] lugares) {
        for (int i = 0; i < lugares.length; i++) {
            for (int j = 0; j < lugares[0].length; j++){
                lugares[i][j] = " |_|";
            }
            //System.out.println("");
        }

        return lugares;
    }


}
