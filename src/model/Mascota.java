package model;

public class Mascota {
    // Atributos privados
    private int codigo;
    private String raza;
    private double peso;
    private int numeroVacunas;

    // Constructor explícito
    public Mascota(int codigo, String raza, double peso, int numeroVacunas) {
        this.codigo = codigo;
        this.raza = raza;
        this.peso = peso;
        this.numeroVacunas = numeroVacunas;
    }

    // Métodos get y set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getNumeroVacunas() {
        return numeroVacunas;
    }

    public void setNumeroVacunas(int numeroVacunas) {
        this.numeroVacunas = numeroVacunas;
    }

}
