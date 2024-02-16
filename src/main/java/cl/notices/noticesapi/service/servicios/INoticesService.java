package cl.notices.noticesapi.service.servicios;

import cl.notices.noticesapi.model.entities.Notices;
import cl.notices.noticesapi.model.entities.ResponseNotices;

import java.util.List;

public interface INoticesService {

    ResponseNotices getAllNotices();
    Notices getByIdNotices(Long id);
    Notices saveNotice(Notices notices);
}
