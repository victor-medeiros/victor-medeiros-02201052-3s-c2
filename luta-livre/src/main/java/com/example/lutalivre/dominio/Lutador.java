package com.example.lutalivre.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Lutador {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 3, max = 12)
    private String nome;

    @PositiveOrZero
    private Double forcaGolpe;

    private Double vida;
    private Integer concentracoesRealizadas;

    // Construtor

    public Lutador() {
        this.vida = 100.0;
        this.concentracoesRealizadas = 0;
    }


    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getForcaGolpe() {
        return forcaGolpe;
    }

    public void setForcaGolpe(Double forcaGolpe) {
        this.forcaGolpe = forcaGolpe;
    }

    public Double getVida() {
        return vida;
    }

    public void setVida(Double forcaGolpe) {
        if ((this.vida - forcaGolpe) <= 0) {
            this.vida = 0.0;
        } else {
            this.vida = vida;
        }
    }

    public Integer getConcentracoesRealizadas() {
        return concentracoesRealizadas;
    }

    public void setConcentracoesRealizadas() {
        if (concentracoesRealizadas < 3) {
            this.concentracoesRealizadas = this.concentracoesRealizadas + 1;
            System.out.println("incrementou");
        }
    }

    public Boolean isVivo() {
        if (this.vida > 0) {
            return true;
        }
        return false;
    }
}
