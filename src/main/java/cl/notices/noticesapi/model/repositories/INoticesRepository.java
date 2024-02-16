package cl.notices.noticesapi.model.repositories;

import cl.notices.noticesapi.model.entities.Notices;
import org.springframework.data.repository.CrudRepository;

public interface INoticesRepository extends CrudRepository<Notices, Long> {
}
