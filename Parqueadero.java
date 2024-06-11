import java.util.ArrayList;

public class Parqueadero {
    private Puesto[] puestos;
    private double tarifa;

    public Parqueadero(int numPuestos, double tarifa) {
        puestos = new Puesto[numPuestos];
        for (int i = 0; i < numPuestos; i++) {
            puestos[i] = new Puesto(i + 1);
        }
        this.tarifa = tarifa;
    }

    public boolean ingresarCarro(Carro carro) {
        for (Puesto puesto : puestos) {
            if (puesto.getCarro() == null) {
                puesto.asignarCarro(carro);
                return true;
            }
        }
        return false; // No hay puestos disponibles
    }

    public boolean darSalidaCarro(String placa) {
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null && carro.getPlaca().equals(placa)) {
                puesto.liberarPuesto();
                return true;
            }
        }
        return false; // El carro no está en el parqueadero
    }

    public double darTiempoPromedio() {
        int totalHoras = 0;
        int carrosParqueados = 0;
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null) {
                totalHoras += carro.getHoraEntrada();
                carrosParqueados++;
            }
        }
        return carrosParqueados == 0 ? 0 : (double) totalHoras / carrosParqueados;
    }

    public Carro carroMasHorasParqueado() {
        Carro carroMasHoras = null;
        int maxHoras = -1;
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null && carro.getHoraEntrada() > maxHoras) {
                maxHoras = carro.getHoraEntrada();
                carroMasHoras = carro;
            }
        }
        return carroMasHoras;
    }

    public boolean hayCarroMasDeOchoHoras() {
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null && carro.getHoraEntrada() >= 8) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Carro> darCarrosMasDeTresHorasParqueados() {
        ArrayList<Carro> carrosMasDeTresHoras = new ArrayList<>();
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null && carro.getHoraEntrada() > 3) {
                carrosMasDeTresHoras.add(carro);
            }
        }
        return carrosMasDeTresHoras;
    }

    public boolean hayCarrosPlacaIgual() {
        ArrayList<String> placas = new ArrayList<>();
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null) {
                String placa = carro.getPlaca();
                if (placas.contains(placa)) {
                    return true;
                }
                placas.add(placa);
            }
        }
        return false;
    }

    public int contarCarrosQueComienzanConPlacaPB() {
        int contador = 0;
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null && carro.getPlaca().startsWith("PB")) {
                contador++;
            }
        }
        return contador;
    }

    public boolean hayCarroCon24Horas() {
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null && carro.getHoraEntrada() >= 24) {
                return true;
            }
        }
        return false;
    }

    public int desocuparParqueadero() {
        int contador = 0;
        for (Puesto puesto : puestos) {
            if (puesto.getCarro() != null) {
                puesto.liberarPuesto();
                contador++;
            }
        }
        return contador;
    }

    public String metodo1() {
        int carrosConPB = contarCarrosQueComienzanConPlacaPB();
        boolean carro24Horas = hayCarroCon24Horas();
        return "Cantidad de carros con placa PB: " + carrosConPB + " - Hay carro parqueado por 24 o más horas: " + (carro24Horas ? "Sí" : "No");
    }

    public String metodo2() {
        int carrosSacados = desocuparParqueadero();
        return "Cantidad de carros sacados: " + carrosSacados;
    }
}
