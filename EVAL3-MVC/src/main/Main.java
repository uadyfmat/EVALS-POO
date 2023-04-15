package src.main;

import src.main.Controller.ClienteController;
import src.main.Controller.ConexionController;
import src.main.Controller.CuentaController;
import src.main.Controller.TransaccionController;
import src.main.Model.*;
import src.main.View.Vista;
import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        Vista vista = new Vista();
        vista.setSize(800, 600); // establece el tamaño de la ventana a 800x600 píxeles
        vista.setLocationRelativeTo(null); // centra la ventana en la pantalla
        vista.setVisible(true);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */

        ClienteController clienteController = new ClienteController();
        CuentaController cuentaController = new CuentaController();
        TransaccionController transaccionController = new TransaccionController();
        ConexionController conexionController = new ConexionController();

        //Se valida la conexion al DB
        conexionController.validarConexion();

        // Creamos un cliente
        Cliente cliente1 = new Cliente("C003","Juan Perez", "+1-555-123-4567","jperez@mail.com");

        // Validamos los datos del cliente
        clienteController.validarDatosCliente(cliente1);

        // Creamos un nuevo registro de cliente
        clienteController.crearCliente(cliente1);

        // Obtenemos los registros de cuentas
        clienteController.obtenerCuentasCliente(cliente1);

        // Creamos una cuenta para el cliente
        Cuenta cuenta1 = new Cuenta(cliente1.getIdCliente(), "CC01", 500.0, "00301");

        // Validamos los datos de la cuenta
        cuentaController.validarDatosCuenta(cuenta1);

        // Creamos un nuevo registro de cuenta
        cuentaController.crearCuenta(cuenta1);

        Cuenta cuenta2 = new Cuenta("C002", "CC01", 500.0,"00201");

        // Validamos los datos de la cuenta
        cuentaController.validarDatosCuenta(cuenta2);

        // Creamos un nuevo registro de cuenta
        cuentaController.crearCuenta(cuenta2);

        // Realizamos un depósito en la cuenta
        Deposito deposito1 = new Deposito(200.0, cuenta2.getClabe());

        // Validamos los datos del depósito
        transaccionController.validarDatosDeposito(deposito1);

        // Realizamos el depósito
        transaccionController.hacerDeposito(deposito1,cuenta1);

        // Realizamos un retiro de la cuenta
        Retiro retiro1 = new Retiro(50.00);

        // Validamos los datos del retiro
        transaccionController.validarDatosRetiro(retiro1);

        // Realizamos el retiro
        transaccionController.hacerRetiro(retiro1,cuenta1);

        //Estado de cuenta
        cuentaController.crearEstadoDeCuenta(cuenta1);
        cuentaController.crearEstadoDeCuenta(cuenta2);

        // Eliminamos la cuenta
        cuentaController.eliminarCuenta(cuenta1);

        // Eliminamos la cuenta
        cuentaController.eliminarCuenta(cuenta2);

        //Eliminamos cliente
        clienteController.eliminarCliente(cliente1);
    }
}