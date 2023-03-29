package src.Model;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Transaccion {
    protected double monto;
    public static class Fecha {
        public static String getCurrentTimestamp() {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return now.format(formatter);
        }
    }
    public Transaccion(double monto) {
        this.monto = monto;
    }
}
