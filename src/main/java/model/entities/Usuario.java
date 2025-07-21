package model.entities;

import model.enums.MateriasLivros;

import java.util.Objects;

public abstract class Usuario
{
    private String name;
    private int codigo;
    protected MateriasLivros materiasLivros;

    public Usuario(String name, int codigo, MateriasLivros materiasLivros)
    {
        this.name = name;
        this.codigo = codigo;
        this.materiasLivros = materiasLivros;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public MateriasLivros getMateriasLivros() {
        return materiasLivros;
    }

    public void setMateriasLivros(MateriasLivros materiasLivros) {
        this.materiasLivros = materiasLivros;
    }

    public abstract void exibirUsuario();

    @Override
    public String toString() {
        return "Usuario{" +
                "name='" + name + '\'' +
                ", codigo='" + codigo + '\'' +
                ", materiasLivros=" + materiasLivros +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return Objects.equals(codigo, usuario.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }



}
