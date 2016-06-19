/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisc.mbean;

import br.unisc.db.UsuarioJPA;
import br.unisc.model.Usuario;
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

    private Usuario usuario;
    UsuarioJPA usuarioJPA;
    private List<Usuario> usuarios;

    /**
     * Construtor
     */
    public UsuarioMBean() {
        usuario = new Usuario();
        usuarioJPA = new UsuarioJPA();
        usuarios = new LinkedList<Usuario>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void salvar() {
        usuarioJPA.begin();
        usuarioJPA.inserir(usuario);
        usuarioJPA.commit();
        usuario = new Usuario();
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
}
