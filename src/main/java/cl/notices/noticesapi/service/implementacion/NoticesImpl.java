package cl.notices.noticesapi.service.implementacion;

import cl.notices.noticesapi.model.entities.Notices;
import cl.notices.noticesapi.model.entities.ResponseNotices;
import cl.notices.noticesapi.model.repositories.INoticesRepository;
import cl.notices.noticesapi.service.servicios.INoticesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class NoticesImpl implements INoticesService {

    @Value("${endpointNotices}")
    String endpointNotices;

    @Autowired
    RestTemplate restTemplate;

    private final INoticesRepository iNoticesRepository;

    public NoticesImpl(INoticesRepository iNoticesRepository) {
        this.iNoticesRepository = iNoticesRepository;
    }

    @Override
    public ResponseNotices getAllNotices() {

        final ResponseNotices response = restTemplate.getForObject(endpointNotices, ResponseNotices.class);

        if (response.getCount().isEmpty()){
            log.error("Error al traer datos!!");
        }

        return response;

    }

    @Override
    public Notices getByIdNotices(Long id) {

        ResponseNotices response = restTemplate.getForObject(endpointNotices, ResponseNotices.class);

        try {
            if (response.getNotices().contains(response)){
                response.getNotices();
            }
            return iNoticesRepository.findById(id).orElse(null);

        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se pudo encontrar datos!", ex);
        }
    }

    @Override
    public Notices saveNotice(Notices notices) {
        return iNoticesRepository.save(notices);
    }
}
