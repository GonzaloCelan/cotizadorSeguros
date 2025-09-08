package com.cotizador.cotizadorSeguros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/cotizador")
	public class HomeController {

	    @GetMapping("/inicio")
	    public String home() {
	        return "index"; // busca templates/index.html (sin la extensión)
	    }
	}

