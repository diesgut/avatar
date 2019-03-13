package com.avatar.diesgut.controller.login;

import com.avatar.diesgut.model.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.albatross.zelpers.miscelanea.JsonResponse;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping()
    public String index(Model model, HttpSession session) {
        return "index";
    }

    @ResponseBody
    @RequestMapping("login")
    public JsonResponse login(@RequestBody Usuario usuario, HttpSession session) {
        JsonResponse response = new JsonResponse();
        response.setSuccess(Boolean.TRUE);
        try {
            usuario = loginService.findUsuario(usuario.getUserName(), usuario.getPassword());
            if (usuario == null) {
                response.setMessage("correcto");
            } else {
                response.setMessage("error");
            }
        } catch (Exception e) {
            response.setSuccess(Boolean.FALSE);
        }
        return response;
    }

}
