package com.barbearia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.barbearia.model.Profissional;
import com.barbearia.repository.ProfissionalRepository;
import com.barbearia.service.ProfissionaisAtivosService;

@Controller
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private ProfissionaisAtivosService profissionaisAtivosService;

    // Listar todos os profissionais
    @GetMapping("/profissionais")
    public String listarProfissionais(Model model) {
        model.addAttribute("profissional", new Profissional());
        model.addAttribute("profissionais", profissionalRepository.findAll());
        return "profissionais"; // Página HTML para listar profissionais
    }

    // Salvar um novo profissional
    @PostMapping("/profissionais")
    public String salvarProfissional(@ModelAttribute Profissional profissional) {
        profissionalRepository.save(profissional);
        return "redirect:/profissionais";
    }

    // Alterar o status de um profissional (ativo/inativo)
    @PostMapping("/profissionais/{id}/status")
    public String alterarStatus(@PathVariable Integer id, @RequestParam("ativo") Boolean ativo) {
        Profissional profissional = profissionalRepository.findById(id).orElse(null);
        if (profissional != null) {
            profissional.setAtivo(ativo);
            profissionalRepository.save(profissional);
        }
        return "redirect:/profissionais";
    }

    // Excluir um profissional
    @PostMapping("/profissionais/{id}/excluir")
    public String excluirProfissional(@PathVariable Integer id) {
        if (profissionalRepository.existsById(id)) {
            profissionalRepository.deleteById(id);
        }
        return "redirect:/profissionais";
    }

    // Listar profissionais ativos e redirecionar para a página HTML
    @GetMapping("/profissionais-ativos")
    public String listarProfissionaisAtivos(Model model) {
        model.addAttribute("profissionaisAtivos", profissionaisAtivosService.listarProfissionaisAtivos());
        return "profissionaisAtivos"; // Página HTML em /templates/profissionaisAtivos.html
    }
}
