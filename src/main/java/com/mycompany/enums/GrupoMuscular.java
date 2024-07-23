package com.mycompany.enums;

public enum GrupoMuscular {
    ABDOMEN("Abdômen"),
    BICEPS("Bíceps"),    
    COSTAS("Costas"),
    GLUTEOS("Glúteos"), 
    OMBROS("Ombros"),   
    PEITO("Peito"),    
    PERNAS("Pernas"),
    PANTURRILHAS("Panturrilhas"),    
    TRICEPS("Tríceps");

    private final String nome;

    // Construtor do enum
    GrupoMuscular(String nome) {
        this.nome = nome;
    }

    // Método para obter o nome do enum
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return name(); // Retorna o nome do enum como string
    }
}
