package com.example.lutalivre.dominio;

public class Golpe {

    // Atributos
    private Integer idLutadorBate;
    private Integer idLutadorApanha;

    public Golpe(Lutador lutadorBatedor, Lutador lutadorAgredido) {
        this.idLutadorBate = lutadorBatedor.getId();
        this.idLutadorApanha = lutadorAgredido.getId();
    }

    public Integer getIdLutadorBate() {
        return idLutadorBate;
    }

    public void setIdLutadorBate(Integer idLutadorBate) {
        this.idLutadorBate = idLutadorBate;
    }

    public Integer getIdLutadorApanha() {
        return idLutadorApanha;
    }

    public void setIdLutadorApanha(Integer idLutadorApanha) {
        this.idLutadorApanha = idLutadorApanha;
    }
}
