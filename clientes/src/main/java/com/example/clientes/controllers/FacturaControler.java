package com.example.clientes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.clientes.repository.FacturaRepository;

@CrossOrigin(origins = "http://localhost:8081")
@Controller
@RequestMapping(path = "practica")
public class FacturaControler<Factura> {

	@Autowired
	FacturaRepository FacturaRepository;

	@GetMapping(path = "deleteFactura")
	public String delete(Model model, @RequestParam long idFactura) {

		Optional<Factura> FacturaOptional = FacturaRepository.findById(idFactura);
		if (FacturaOptional.isPresent()) {
			FacturaRepository.deleteById(idFactura);
			return "redirect:/practica/updateFactura?idFactura=" + FacturaOptional.get().getClass().getName();

		}

		return "error";
	}

	@GetMapping(path = "updateFactura")
	public String updateTutorial(Model model, @RequestParam long idFactura) {
		model.addAttribute("update", true);
		model.addAttribute("intupdate", 0);
		Optional<Factura> Factura = FacturaRepository.findById(idFactura);
		if (Factura.isPresent()) {
			model.addAttribute("Factura", Factura.get());
		}
		return "updateFactura";
	}

}
