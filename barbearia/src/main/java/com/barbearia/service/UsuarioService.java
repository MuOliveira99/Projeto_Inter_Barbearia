
package com.barbearia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.barbearia.model.Usuario;
import com.barbearia.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public boolean existeCpf(String cpf) {
        return repo.findByCpf(cpf).isPresent();
    }

    public Usuario salvar(Usuario u) {
        return repo.save(u);
    }

    public Optional<Usuario> autenticar(String cpf, String senha) {
        return repo.findByCpfAndSenha(cpf, senha);
    }

    public List<Usuario> listarTodos() {
    return repo.findAll();
}

public void atualizarTipoAcesso(Integer id, Usuario.TipoAcesso tipo) {
    repo.findById(id).ifPresent(usuario -> {
        usuario.setTipoAcesso(tipo);
        repo.save(usuario);
    });
}

public List<Usuario> buscarPorCpfOuNome(String termo) {
    return repo.findByCpfContainingIgnoreCaseOrNomeContainingIgnoreCase(termo, termo);
}



}
