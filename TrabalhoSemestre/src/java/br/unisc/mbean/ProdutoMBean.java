/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.mbean;

import br.unisc.db.ProdutoJPA;
import br.unisc.model.Produto;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author simon
 */
@ManagedBean
@SessionScoped
public class ProdutoMBean {

    private Produto produto;
    ProdutoJPA produtoJPA;
    private List<Produto> produtos;

    public ProdutoMBean() {
        produto = new Produto();
        produtoJPA = new ProdutoJPA();
        produtos = new LinkedList<Produto>();
        carregarProdutos();
    }

    public void carregarProdutos() {
        produtos = produtoJPA.buscarTodos();
    }

    public void salvar() {
        produtoJPA.begin();
        if (produto.getId() != null) {
            produtoJPA.atualizar(produto);
        } else {
            produtoJPA.inserir(produto);
        }

        produtoJPA.commit();
        produto = new Produto();
        carregarProdutos();
    }

    public void deletar(Long id) {
        produtoJPA.begin();
        produtoJPA.deletar(id);
        produtoJPA.commit();
        carregarProdutos();
    }

    public void editar(Produto produtoSel) {
        this.produto = produtoSel;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
