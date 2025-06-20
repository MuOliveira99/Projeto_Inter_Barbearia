package com.barbearia.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.barbearia.model.Agendamento;
import com.barbearia.model.Usuario;
import com.barbearia.repository.AgendamentoRepository;
import com.barbearia.repository.ProfissionalRepository;
import com.barbearia.service.AgendamentoService;
import com.barbearia.service.ProfissionalService;
import com.barbearia.service.UsuarioService;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final ProfissionalService profissionalService;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public UsuarioController(UsuarioService usuarioService, ProfissionalService profissionalService) {
        this.usuarioService = usuarioService;
        this.profissionalService = profissionalService;
    }

    @GetMapping("/cadastro")
    public String formCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute Usuario usuario, Model model) {
        if (usuarioService.existeCpf(usuario.getCpf())) {
            model.addAttribute("erro", "CPF já cadastrado.");
            return "cadastro";
        }
        usuarioService.salvar(usuario);
        model.addAttribute("msg", "Cadastro realizado com sucesso!");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String formLogin() {
        return "loginadmin";
    }

    @PostMapping("/login")
    public String login(@RequestParam String cpf, @RequestParam String senha, Model model) {
        return usuarioService.autenticar(cpf, senha)
            .map(usuario -> {
                if (usuario.getTipoAcesso() == Usuario.TipoAcesso.admin) {
                    return "redirect:/usuarios";
                } else {
                    model.addAttribute("profissionais", profissionalRepository.findByAtivoTrue()); // ✅ SOMENTE ATIVOS
                    model.addAttribute("agendamento", new Agendamento());
                    return "agendamento";
                }
            })
            .orElseGet(() -> {
                model.addAttribute("erro", "CPF ou senha inválidos");
                return "loginadmin";
            });
    }

    @GetMapping("/agendamento")
    public String mostrarFormulario(Model model) {
        model.addAttribute("agendamento", new Agendamento());
        model.addAttribute("profissionais", profissionalRepository.findByAtivoTrue()); // ✅ SOMENTE ATIVOS
        return "agendamento";
    }

    @PostMapping("/agendamento")
public String salvarAgendamento(@ModelAttribute Agendamento agendamento, RedirectAttributes redirectAttributes) {
    agendamentoRepository.save(agendamento); // <- faz o insert
    redirectAttributes.addFlashAttribute("mensagem", "✅ Agendamento realizado com sucesso!");
    return "redirect:/agendamento";
}
    @Autowired
private AgendamentoService agendamentoService;

@GetMapping("/horarios-disponiveis")
@ResponseBody
public List<String> horariosDisponiveis(
        @RequestParam("profissionalId") Integer profissionalId,
        @RequestParam("data") String dataStr) {

    LocalDate data = LocalDate.parse(dataStr);
    return agendamentoService.horariosDisponiveis(profissionalId, data);
}

@Autowired
private AgendamentoRepository agendamentoRepository;

@GetMapping("/admin/agendamentos")
public String listarAgendamentos(Model model) {
    model.addAttribute("agendamentos", agendamentoRepository.findAll());
    return "admin-agendamentos";
}

@GetMapping("/admin-agendamentos")
public String exibirAgendamentosAdmin(Model model) {
    model.addAttribute("agendamentos", agendamentoRepository.findAll());
    return "admin-agendamentos";
}
}