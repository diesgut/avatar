package com.avatar.diesgut.dao;

import com.avatar.diesgut.model.Usuario;

public interface UsuarioDAO {

    void saveUsuario(Usuario usuario);

    Usuario findUsuarioByUsernameAndPassword(String userName, String password);

}
