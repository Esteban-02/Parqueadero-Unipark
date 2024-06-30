import java.util.Scanner;

public class moto extends Vehiculo{
    public moto(String placa, String marca, String modelo) {
        super(placa, marca, modelo);
    }

    public static int tipoMotocicleta(){
        Scanner lectura = new Scanner(System.in);
        System.out.println("\t\nSeleccione el tipo de motocicleta:");
        System.out.print("\n1 Clasica" +
                "\n2 Hibrida" +
                "\n>> ");
        int numTipo = lectura.nextInt();

        if (numTipo == 1){
            numTipo = 1500;
        }else{
            numTipo = 2000;
        }

      return numTipo;

    }
}
