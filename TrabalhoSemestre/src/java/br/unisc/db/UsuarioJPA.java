/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.db;

import br.unisc.model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

    public List<Usuario> buscarTodos(){
        Query query = em.createQuery("select u from Usuario u");
        return query.getResultList();
    }
    
    public Usuario buscarPorId(Long id) {
        return em.find(Usuario.class, id);
    }
    
    public Usuario buscarPorEmail(String email){
        return em.find(Usuario.class, email);
    }

    public void begin() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }
}
