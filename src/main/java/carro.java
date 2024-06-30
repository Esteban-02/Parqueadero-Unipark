import lombok.Getter;

@Getter
public class carro extends Vehiculo{
    int precio = 5000;

    public carro(String placa, String marca, String modelo) {
        super(placa, marca, modelo);
    }
}
