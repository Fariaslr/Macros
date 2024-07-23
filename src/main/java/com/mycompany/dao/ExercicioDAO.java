package com.mycompany.dao;

import com.mycompany.models.Exercicio;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

public class ExercicioDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public ExercicioDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void adicionarExercicio(Exercicio exercicio) {
        entityManager.getTransaction().begin();
        entityManager.persist(exercicio);
        entityManager.getTransaction().commit();
    }

    public List<Exercicio> listarExercicios() {
        return entityManager.createQuery("SELECT e FROM Exercicio e ORDER BY e.grupoMuscular", Exercicio.class).getResultList();
    }

    public Exercicio buscarExercicio(UUID id) {
        return entityManager.find(Exercicio.class, id);
    }

    public void atualizarExercicio(Exercicio exercicio) {
        entityManager.getTransaction().begin();
        entityManager.merge(exercicio);
        entityManager.getTransaction().commit();
    }

    public void removerExercicio(UUID id) {
        entityManager.getTransaction().begin();
        Exercicio exercicio = entityManager.find(Exercicio.class, id);
        if (exercicio != null) {
            entityManager.remove(exercicio);
        }
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
