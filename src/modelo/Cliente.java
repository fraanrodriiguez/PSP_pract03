package modelo;

import java.time.LocalDate;

public class Cliente {
    //Atributos
    private int numero;
    private String nombre;
    private LocalDate fechaNac;
    private float puntos;

    //Constructor
    public Cliente(int numero, String nombre,LocalDate fechaNac, float puntos) {
        this.numero = numero;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.puntos = puntos;
    }
    
    //Métodos
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public float getPuntos() {
        return puntos;
    }

    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "numero=" + numero + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", puntos=" + puntos + '}';
    }
}