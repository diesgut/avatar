package com.avatar.diesgut.controller.login;

import com.avatar.diesgut.dao.UsuarioRepository;
import com.avatar.diesgut.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LoginServiceImp implements LoginService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario findUsuario(String userName, String password) {
        return usuarioRepository.findByUserName(userName);
    }

}
