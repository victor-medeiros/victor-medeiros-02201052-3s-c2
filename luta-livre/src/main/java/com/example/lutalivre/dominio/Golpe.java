package com.example.lutalivre.dominio;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Golpe {

    // Atributos
    @NotNull
    private Integer idLutadorBate;

    @NotNull
    private Integer idLutadorApanha;

//    public Golpe(Lutador lutadorBatedor, Lutador lutadorAgredido) {
//        this.idLutadorBate = lutadorBatedor.getId();
//        this.idLutadorApanha = lutadorAgredido.getId();
//    }

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
