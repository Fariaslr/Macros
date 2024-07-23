/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.models.Treino;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

/**
 *
 * @author Lucas
 */
public class TreinoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void create(Treino treino) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(treino);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Treino read(UUID id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Treino.class, id);
        } finally {
            em.close();
        }
    }

    public List<Treino> readAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Treino t", Treino.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Treino treino) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(treino);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(UUID id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Treino treino = em.find(Treino.class, id);
            if (treino != null) {
                em.remove(treino);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
