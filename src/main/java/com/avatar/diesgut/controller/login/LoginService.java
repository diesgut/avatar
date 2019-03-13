package com.avatar.diesgut.controller.login;

import com.avatar.diesgut.model.Usuario;

public interface LoginService {

    Usuario findUsuario(String userName, String password);

}
