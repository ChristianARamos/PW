/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.db;

import br.unisc.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Trio
 */
public class UsuarioJPA {

    EntityManager em;

    public UsuarioJPA() {
        em = Persistence.createEntityManagerFactory("ExemploDecorationJSFPU").createEntityManager();
    }

    public void inserir(Usuario usuario) {
        em.persist(usuario);
    }

    public void atualizar(Usuario usuario) {
        em.merge(usuario);
    }

    public Usuario buscarPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    public void begin() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }
}
