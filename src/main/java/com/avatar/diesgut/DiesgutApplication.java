package com.avatar.diesgut;

import com.avatar.diesgut.controller.usuario.UsuarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DiesgutApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DiesgutApplication.class, args);
        context.getBean(UsuarioService.class).createUsers();
        /*
        SpringApplication.run(DiesgutApplication.class, args);*/
    }

}
