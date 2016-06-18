/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.db;

import br.unisc.model.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author simon
 */
public class ProdutoJPA {

    EntityManager em;

    public ProdutoJPA() {
        em = Persistence.createEntityManagerFactory("ExemploDecorationJSFPU").createEntityManager();
    }

    public void inserir(Produto produto) {
        em.persist(produto);
    }

    public void atualizar(Produto produto) {
        em.merge(produto);
    }

    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }

    public void deletar(Long id) {
        em.remove(buscarPorId(id));
    }

    public List<Produto> buscarTodos() {
        Query query = em.createQuery("select p from Produto p");
        return query.getResultList();
    }

    public void begin() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }

}
