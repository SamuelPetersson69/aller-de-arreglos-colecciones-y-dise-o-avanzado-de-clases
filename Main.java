import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero(40, 5.0);

        Carro carro1 = new Carro("ABC123", 10);
        Carro carro2 = new Carro("XYZ456", 12);
        Carro carro3 = new Carro("PB7890", 15);

        // Ingresar carros
        parqueadero.ingresarCarro(carro1);
        parqueadero.ingresarCarro(carro2);
        parqueadero.ingresarCarro(carro3);

        // Dar salida a un carro
        parqueadero.darSalidaCarro("ABC123");

        // Consultar tiempo promedio
        System.out.println("Tiempo promedio: " + parqueadero.darTiempoPromedio());

        // Consultar carro con más horas parqueado
        Carro carroMasHoras = parqueadero.carroMasHorasParqueado();
        System.out.println("Carro con más horas parqueado: " + (carroMasHoras != null ? carroMasHoras.getPlaca() : "Ninguno"));

        // Consultar si hay carro con más de 8 horas
        System.out.println("Hay carro con más de 8 horas: " + parqueadero.hayCarroMasDeOchoHoras());

        // Consultar carros parqueados por más de tres horas
        ArrayList<Carro> carrosMasDeTresHoras = parqueadero.darCarrosMasDeTresHorasParqueados();
        System.out.println("Carros parqueados por más de tres horas: " + carrosMasDeTresHoras.size());

        // Consultar si hay carros con placa igual
        System.out.println("Hay carros con placa igual: " + parqueadero.hayCarrosPlacaIgual());

        // Requerimientos Funcionales
        // Contar carros que comienzan con PB
        System.out.println("Cantidad de carros con placa PB: " + parqueadero.contarCarrosQueComienzanConPlacaPB());

        // Consultar si hay carro con 24 o más horas
        System.out.println("Hay carro con 24 o más horas: " + parqueadero.hayCarroCon24Horas());

        // Método 1
        System.out.println(parqueadero.metodo1());

        // Método 2
        System.out.println(parqueadero.metodo2());
    }
}
