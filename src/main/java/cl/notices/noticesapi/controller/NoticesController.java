package cl.notices.noticesapi.controller;

import cl.notices.noticesapi.config.SwaggerConfig;
import cl.notices.noticesapi.model.entities.Notices;
import cl.notices.noticesapi.model.entities.ResponseNotices;
import cl.notices.noticesapi.service.servicios.INoticesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.server.ResponseStatusException;


@Api(value = "Controller Manager New Clients")
@Import(SwaggerConfig.class)
@RestController
@RequestMapping("/api/v1")
public class NoticesController {

    private static final Logger log = LoggerFactory.getLogger(NoticesController.class);

    @Autowired
    private INoticesService noticesService;

    @ApiOperation(value = "Endpoint para listar las noticias", response = NoticesController.class)
    @GetMapping("/getAllNotices")
    public ResponseNotices getAllNoticies() {
        return noticesService.getAllNotices();
    }

    @ApiOperation(value = "Endpoint para guardar las noticias", response = NoticesController.class)
    @GetMapping("/saveNotices")
    public Notices saveNotices (@RequestBody Notices notices){

        try {
            return noticesService.saveNotice(notices);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se pudo guardar datos!", ex);
        }

    }


}
