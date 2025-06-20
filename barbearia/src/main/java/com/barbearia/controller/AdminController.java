package com.barbearia.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.barbearia.model.Agendamento;
import com.barbearia.model.AgendamentosPorProfissional;

import com.barbearia.model.Usuario;
import com.barbearia.service.AgendamentosPorProfissionalService;

import com.barbearia.service.ProfissionalService;
import com.barbearia.service.UsuarioService;

@Controller
public class AdminController {

    private final UsuarioService usuarioService;
    private final ProfissionalService profissionalService;
    
    private final AgendamentosPorProfissionalService agendamentosPorProfissionalService;

    public AdminController(UsuarioService usuarioService, ProfissionalService profissionalService,
                           
                           AgendamentosPorProfissionalService agendamentosPorProfissionalService) {
        this.usuarioService = usuarioService;
        this.profissionalService = profissionalService;
      
        this.agendamentosPorProfissionalService = agendamentosPorProfissionalService;
    }

    @GetMapping("/admin")
    public String loginPage() {
        return "usuarios";
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(@RequestParam(name = "busca", required = false) String busca, Model model) {
        if (busca != null && !busca.isEmpty()) {
            model.addAttribute("usuarios", usuarioService.buscarPorCpfOuNome(busca));
        } else {
            model.addAttribute("usuarios", usuarioService.listarTodos());
        }
        model.addAttribute("busca", busca);
        return "usuarios";
    }

    @PostMapping("/usuarios/{id}/alterar-acesso")
    public String alterarAcesso(@PathVariable Integer id, @RequestParam String tipo) {
        usuarioService.atualizarTipoAcesso(id, Usuario.TipoAcesso.valueOf(tipo));
        return "redirect:/usuarios";
    }

    @GetMapping("/admin/agendamento")
    public String exibirAgendamento(Model model) {
        model.addAttribute("profissionais", profissionalService.listar());
        model.addAttribute("agendamento", new Agendamento());
        return "agendamento";
    }

    @GetMapping("/admin/agendamentos-por-profissional")
    @ResponseBody
    public List<AgendamentosPorProfissional> listarAgendamentosPorProfissional() {
        return agendamentosPorProfissionalService.listarTodos();
    }
}
