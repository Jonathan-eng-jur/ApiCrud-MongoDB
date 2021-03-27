package br.com.jhon.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.jhon.Model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Long> {

}
