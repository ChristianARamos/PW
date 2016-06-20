/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.db;

import br.unisc.model.Cadastro;
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

    public void inserir(Cadastro usuario) {
        em.persist(usuario);
    }

    public void atualizar(Cadastro usuario) {
        em.merge(usuario);
    }

    public List<Cadastro> buscarTodos(){
        Query query = em.createQuery("select u from Usuario u");
        return query.getResultList();
    }
    
    public Cadastro buscarPorId(Long id) {
        return em.find(Cadastro.class, id);
    }
    
    public Cadastro buscarPorEmail(String email){
        return em.find(Cadastro.class, email);
    }

    public void begin() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }
}
