/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.mbean;

import br.unisc.db.UsuarioJPA;
import br.unisc.model.Cadastro;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Trio
 */
@ManagedBean
@SessionScoped
public class UsuarioMBean {

    private Cadastro usuario;
    UsuarioJPA usuarioJPA;
    private List<Cadastro> usuarios;

    /**
     * Construtor
     */
    public UsuarioMBean() {
        usuario = new Cadastro();
        usuarioJPA = new UsuarioJPA();
        usuarios = new LinkedList<Cadastro>();
    }

    public void carregarUsuarios(){
        usuarios = usuarioJPA.buscarTodos();
    }
    
    public List<Cadastro> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Cadastro> usuarios) {
        this.usuarios = usuarios;
    }

    public void salvar() {
        usuarioJPA.begin();
        usuarioJPA.inserir(usuario);
        usuarioJPA.commit();
        usuario = new Cadastro();
    }
    
    public Cadastro getUsuario(){
        return usuario;
    }
}
