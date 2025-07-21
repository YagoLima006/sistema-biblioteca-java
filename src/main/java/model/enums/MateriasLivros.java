package model.enums;

public enum MateriasLivros
{
    humanas("Humanas"),
    exatas("Exatas"),
    tecnologia("Tecnologia"),
    medicina("Medicina"),
    agronomia("Agronomia "),
    veterinaria("Veterinaria"),
    social("Social");

    private final String descricao;

    MateriasLivros(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
