package gc._4.pr2.grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gc._4.pr2.grupo3.entity.Evento;

public interface EventoRepository extends JpaRepository <Evento, Long> {

}
