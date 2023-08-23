package com.soulcode.goserviceapp.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import org.hibernate.annotations.ManyToAny;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Prestador extends Usuario{

    private String descricao;

    private float taxaPorHora;

    @ManyToAny
    @JoinTable(
            name = "prestadores_servicos",
            joinColumns = @JoinColumn(name = "prestador_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id")
    )

    private List<Servico> especialidades;

    public Prestador(){
        super();

        setPerfil(Perfil.PRESTADOR);
    }

    public Prestador(Long id, String nome, String email, String senha, Perfil perfil, Boolean habilitado) {
        super(id, nome, email, senha, perfil, habilitado);
    }

    public Prestador(Long id, String nome, String email, String senha, Perfil perfil, Boolean habilitado, String descricao, float taxaPorHora, List<Servico> especialidades) {
        super(id, nome, email, senha, perfil, habilitado);
        this.descricao = descricao;
        this.taxaPorHora = taxaPorHora;
        this.especialidades = especialidades;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getTaxaPorHora() {
        return taxaPorHora;
    }

    public void setTaxaPorHora(float taxaPorHora) {
        this.taxaPorHora = taxaPorHora;
    }

    public List<Servico> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Servico> especialidades) {
        this.especialidades = especialidades;
    }

    public void addEspecialidade(Servico servico){
        if(especialidades == null){
            especialidades = new ArrayList<>();
        }
        especialidades.add(servico);
    }

    public boolean removeEspecialidade(Servico servico){
        if(especialidades != null){
            return especialidades.remove(servico);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestador that = (Prestador) o;
        return Objects.equals(descricao, that.descricao ) &&
                Objects.equals(taxaPorHora, that.taxaPorHora) &&
                Objects.equals(especialidades, that.especialidades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, taxaPorHora, especialidades);
    }
}
