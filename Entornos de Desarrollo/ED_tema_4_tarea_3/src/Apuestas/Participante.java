/** @author Lucía González Rosas */

/** En esta parte del programa se creará la compilación necesaria para crear
  * la clase "Partcipante", la cual tendrá de atributos el nombre, el NIF, el
  * teléfono, el email, la edad, el número de la tarjeta, el "nickname" y la
  * contraseña del participante.
  * 
  * Además, con dicha clase se podrá implementar por teclado todos esos aspectos
  * de forma manual.
  *
  * Dicha clase se empleará en la clase "Apuesta".
  */

package Apuestas;

import java.util.Scanner;

public class Participante {
    
    private String nombre;
    private String nif;
    private String telefono;
    private String email;
    private int edad;
    private String numeroTarjeta;
    private String nick;
    private String password;
    private double saldo;

    public Participante(String nombre, String nif, String telefono, String email, int edad, String numeroTarjeta, String nick, String password) {
        
        this.nombre = nombre;
        this.nif = nif;
        this.telefono = telefono;
        this.email = email;
        this.edad = edad;
        this.numeroTarjeta = numeroTarjeta;
        this.nick = nick;
        this.password = password;
        this.saldo = 0;
        
    }
    
    private boolean validarEmail(String email) {
        
        return email.matches("^(.+)@(.+)$");
        
    }
    
    private boolean validarTelefono(String telefono) {
        return telefono.matches("\\d{9}");
        
    }
    
    private boolean verificarEdad(int edad) {
        
        return edad >= 18;
        
    }
    
    private boolean validarTarjeta(String tarjeta) {

        return tarjeta.matches("\\d{16}");
        
    }
    
    public boolean validarRegistro() {
        
        if (!validarEmail(email)) {
            System.out.println("El email proporcionado no es válido.");
            return false;
            
        }
        
        if (!validarTelefono(telefono)) {
            System.out.println("El teléfono proporcionado no es válido.");
            return false;
            
        }
        
        if (!verificarEdad(edad)) {
            System.out.println("Debes de ser mayor de 18 años.");
            return false;
            
        }
        
        if (!validarTarjeta(numeroTarjeta)) {
            System.out.println("El número de tarjeta proporcionado no es válido.");
            return false;
            
        }
        
        return true;
        
    }
    
    public double getSaldo() {
        
        return saldo;
        
    }
    
    public void aumentarSaldo(double cantidad) {
        
        saldo += cantidad;
        
        System.out.println("Se ha añadido " + cantidad + "€ a tu saldo. Tu saldo actual es de " + saldo + "€");
        
    }
}