
package com.barbearia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbearia.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCpfAndSenha(String cpf, String senha);
    Optional<Usuario> findByCpf(String cpf);
    List<Usuario> findByCpfContainingIgnoreCaseOrNomeContainingIgnoreCase(String cpf, String nome);

}
