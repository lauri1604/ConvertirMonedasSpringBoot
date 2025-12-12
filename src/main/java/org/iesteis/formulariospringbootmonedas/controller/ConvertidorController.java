package org.iesteis.formulariospringbootmonedas.controller;

import org.iesteis.formulariospringbootmonedas.service.CambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class ConvertidorController {

    @Autowired
    private CambioService cambioService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/convertir")
    public String mostrarFormulario() {
        return "index";
    }

    @PostMapping("/conversion")
    public String convertir(
            @RequestParam float importe,
            @RequestParam String origen,
            @RequestParam String destino,
            Model model) {

        float resultado = cambioService.convertir(origen, destino, importe);

        model.addAttribute("importe", importe);
        model.addAttribute("origen", origen);
        model.addAttribute("destino", destino);
        model.addAttribute("resultado", resultado);

        return "result";
    }

}
