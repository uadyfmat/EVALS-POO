package Controller;

import DAO.Conexion;
import Model.Cuenta;
import Model.Transaccion;
import Service.Query;
import java.io.IOException;
import java.util.List;
public class CuentaController {
    public boolean validarDatosCuenta(Cuenta cuenta) {
        if (cuenta.getIdCliente().isEmpty() || cuenta.getIdCuenta().isEmpty() || Double.valueOf(cuenta.getSaldo()).equals(0.0) || cuenta.getClabe().isEmpty())  {
            return false;
        }
        if (!cuenta.getIdCliente().matches("^C\\d{3}$")){
            return false;
        }
        if (!cuenta.getIdCuenta().matches("^CC\\d{2}$")) {
            return false;
        }
        if (!String.valueOf(cuenta.getSaldo()).matches("^(?:0|[1-9]\\d*)(?:\\.\\d+|\\.0+)?$")) {
            return false;
        }
        if (!cuenta.getClabe().matches("^0*[1-9][0-9]*$")){
            return false;
        }
        return true;
    }
    public void crearCuenta(Cuenta cuenta) throws IOException {
        Query query = new Query(new Conexion());
        String saldoCuenta = String.valueOf(cuenta.getSaldo());
        String[] datosCuentas = {
                cuenta.getIdCliente(),
                cuenta.getIdCuenta(),
                saldoCuenta,
                cuenta.getClabe()
        };
        if (validarDatosCuenta(cuenta)) {
            query.escribirRegistroCuenta(datosCuentas);
            System.out.println("Cuenta creada exitosamente.");
        }
        else {
            System.out.println("Datos de cuenta no válidos. No se ha creado la cuenta.");
        }
    }
    public void eliminarCuenta(Cuenta cuenta) throws IOException {
        Query query = new Query(new Conexion());
        List<String[]> registrosCuentas = query.obtenerRegistrosCuentas();
        int i = 0;
        for (String[] registro : registrosCuentas) {
            if (registro[0].equals(cuenta.getIdCliente()) && registro[1].equals(cuenta.getIdCuenta())) {
                query.eliminarRegistroCuenta(i);
                System.out.println("Cuenta eliminada exitosamente.");
                return;
            }
            i++;
        }
    }
    public double validarSaldoCuenta(String cuentaClabe) {
        Query query = new Query(new Conexion());
        try {
            String saldo = query.obtenerSaldoCuentas(cuentaClabe);
            return Double.parseDouble(saldo);
        }
        catch (IOException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
    public void crearEstadoDeCuenta(Cuenta cuenta) throws IOException {
        System.out.println("Estado de cuenta de la cuenta " + cuenta.getIdCuenta());
        System.out.println("Saldo actual: " + validarSaldoCuenta(cuenta.getClabe()));
        System.out.println("Transacciones realizadas:");
        if (cuenta.estadoDeCuenta()!=null){
            System.out.println(cuenta.estadoDeCuenta());
        } else
            System.out.println("No hay operaciones realizadas");
    }
}