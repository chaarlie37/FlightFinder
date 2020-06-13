package sd.a2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sd.a2.model.Aeropuerto;
import sd.a2.repositories.AeropuertoRepository;
import sd.a2.services.AeropuertoService;
import javax.annotation.PostConstruct;
import java.util.List;


@RestController
// Controller para gestionar el servicio web y devolver datos sobre las aerolineas
// Solo se han hecho metodos que se utilizan / necesitan en la pagina. Los que no se necesitan
// no se han implementado (por ejemplo, devolver un aeropuerto por su nombre)
public class AeropuertoController {
    @Autowired
    // Servicio que gestiona el repositorio
    private AeropuertoService aeropuertoService;

    @Autowired
    // Repositorio de aeropuertos. Se declara aqui solo para inicializarlo con init()
    private AeropuertoRepository aeropuertoRepository;

    @PostConstruct
    // Metodo para introducir vuelos en la base de datos
    public void init(){

    }

    // Devolver todos los aeropuertos
    @RequestMapping(value = "/aeropuertos/", method = RequestMethod.GET)
    public List<Aeropuerto> getAeropuertos(){
        return aeropuertoService.getAeropuertos();
    }

}
