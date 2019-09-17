package com.avatar.diesgut.controller.usuario;

import com.avatar.diesgut.dao.UsuarioDAO;
import com.avatar.diesgut.dao.UsuarioRepository;
import com.avatar.diesgut.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public void createUsers() {
        Usuario usuario1 = new Usuario();
        usuario1.setPassword("diesgut");
        usuario1.setUserName("diesgut");
        usuario1.setPersona(null);

        Usuario usuarioFound = usuarioRepository.findByUserName(usuario1.getUserName());
        if (usuarioFound == null) {
            usuarioDAO.saveUsuario(usuario1);
        }
    }

}
