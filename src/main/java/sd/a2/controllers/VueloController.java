package sd.a2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sd.a2.model.Aerolinea;
import sd.a2.model.Aeropuerto;
import sd.a2.model.Vuelo;
import sd.a2.repositories.AerolineaRepository;
import sd.a2.repositories.AeropuertoRepository;
import sd.a2.repositories.VueloRepository;
import sd.a2.services.VuelosService;
import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
// Controller para gestionar el servicio web y devolver datos sobre las aerolineas
// Solo se han hecho metodos que se utilizan / necesitan en la pagina. Los que no se necesitan
// no se han implementado (por ejemplo, devolver todos los vuelos registrados)
public class VueloController {

    @Autowired
    // Servicio que gestiona el repositorio
    private VuelosService vuelosService;

    @Autowired
    // Repositorio de aeropuertos. Se declara aqui solo para inicializarlo con init()
    private AeropuertoRepository aeropuertoRepository;

    @Autowired
    // Repositorio de aeropuertos. Se declara aqui solo para inicializarlo con init()
    private AerolineaRepository aerolineaRepository;

    @Autowired
    // Repositorio de vuelos. Se declara aqui solo para inicializarlo con init()
    private VueloRepository vueloRepository;



    @PostConstruct
    // Metodo para introducir vuelos en la base de datos
    public void init(){

        ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
        ArrayList<String> aerolineas = new ArrayList<>();

        for (Aerolinea a:
             aerolineaRepository.findAll()) {
            aerolineas.add(a.getCodigo());
        }

        Aeropuerto madrid = new Aeropuerto("MAD", "Madrid Adolfo Suárez - Barajas");
        Aeropuerto roma1 = new Aeropuerto("FIU", "Roma Fiumicino");
        Aeropuerto roma2 = new Aeropuerto("CIA", "Roma Ciampino");
        Aeropuerto palma = new Aeropuerto("PMI", "Palma de Mallorca");
        Aeropuerto berlin = new Aeropuerto("SXF", "Berlin Schönefeld");
        Aeropuerto ny = new Aeropuerto("JFK", "Nueva York John F. Kennedy");
        Aeropuerto bcn = new Aeropuerto("BCN", "Barcelona");
        Aeropuerto paris = new Aeropuerto("ORY", "París Orly");
        aeropuertos.add(madrid);
        aeropuertos.add(roma1);
        aeropuertos.add(roma2);
        aeropuertos.add(palma);
        aeropuertos.add(berlin);
        aeropuertos.add(ny);
        aeropuertos.add(bcn);
        aeropuertos.add(paris);
        aeropuertoRepository.save(madrid);
        aeropuertoRepository.save(roma1);
        aeropuertoRepository.save(roma2);
        aeropuertoRepository.save(palma);
        aeropuertoRepository.save(berlin);
        aeropuertoRepository.save(ny);
        aeropuertoRepository.save(bcn);
        aeropuertoRepository.save(paris);
        // Formato de la fecha y hora para crear los vuelos con fechas a partir de un string
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try{
            for (int i = 1; i<=12; i++){
                for (int j = 1; j<=31; j++){
                    for (int k = 0; k<50; k++){
                        for (String a:
                                aerolineas) {
                            System.out.println("Generando vuelo..." + (k * j * i) / 12 * 30 * 100);
                            Aeropuerto a1 = aeropuertos.get((int) (Math.random() * (aeropuertos.size() - 1)));
                            Aeropuerto a2 = aeropuertos.get((int) (Math.random() * (aeropuertos.size() - 1)));
                            Vuelo v = new Vuelo(a + String.format("%04d",((int) (Math.random() * 9999))), simpleDateFormat.parse(String.format("%02d",j) + "-" + String.format("%02d",i) + "-2020 " + String.format("%02d", (int) (Math.random() * 23))  + ":" + String.format("%02d", (int) (Math.random() * 59))), (int) (Math.random() * 300), (int) (Math.random() * 500), a,
                                    a1, a2);
                            System.out.println(v);
                            vueloRepository.save(v);
                        }
                    }
                }
            }

            Vuelo v1 = new Vuelo("IB0001", simpleDateFormat.parse("31-05-2020 12:15"), 120, 150, "IB", madrid, berlin);
            Vuelo v2 = new Vuelo("IB0002", simpleDateFormat.parse("31-05-2020 07:35"), 90, 120, "IB", madrid, roma1);
            Vuelo v3 = new Vuelo("FR0001", simpleDateFormat.parse("02-06-2020 09:30"), 95, 50, "FR", roma1, madrid);
            Vuelo v4 = new Vuelo("BA0001", simpleDateFormat.parse("02-06-2020 17:00"), 450, 500, "BA", madrid, ny);
            Vuelo v5 = new Vuelo("UX0001", simpleDateFormat.parse("01-06-2020 23:30"), 45, 75, "UX", madrid, palma);
            Vuelo v6 = new Vuelo("UX0002", simpleDateFormat.parse("31-05-2020 23:30"), 125, 75, "UX", madrid, berlin);
            Vuelo v7 = new Vuelo("UX0003", simpleDateFormat.parse("02-06-2020 12:15"), 120, 140, "UX", berlin, madrid);
            Vuelo v8 = new Vuelo("IB0003", simpleDateFormat.parse("31-05-2020 11:45"), 55, 80, "IB", madrid, bcn);
            Vuelo v9 = new Vuelo("IB0004", simpleDateFormat.parse("31-05-2020 12:30"), 55, 100, "IB", madrid, bcn);
            Vuelo v10 = new Vuelo("FR0002", simpleDateFormat.parse("31-05-2020 13:55"), 50, 45, "FR", madrid, bcn);
            Vuelo v11 = new Vuelo("IB0006", simpleDateFormat.parse("31-05-2020 15:00"), 55, 60, "IB", bcn, madrid);
            Vuelo v12 = new Vuelo("IB0007", simpleDateFormat.parse("31-05-2020 18:10"), 55, 75, "IB", madrid, bcn);
            Vuelo v13 = new Vuelo("UX0004", simpleDateFormat.parse("31-05-2020 22:25"), 55, 50, "UX", bcn, madrid);
            Vuelo v14 = new Vuelo("AF0001", simpleDateFormat.parse("31-05-2020 07:25"), 100, 120, "AF", madrid, paris);
            Vuelo v15 = new Vuelo("AF0002", simpleDateFormat.parse("02-06-2020 07:25"), 110, 130, "AF", paris, madrid);
            Vuelo v16 = new Vuelo("LH0001", simpleDateFormat.parse("31-05-2020 16:15"), 120, 140, "LH", madrid, berlin);
            Vuelo v17 = new Vuelo("LH0002", simpleDateFormat.parse("02-06-2020 17:30"), 115, 100, "LH", berlin, madrid);
            Vuelo v18 = new Vuelo("IB0005", simpleDateFormat.parse("31-05-2020 07:30"), 65, 65, "IB", madrid, bcn);
            vueloRepository.save(v1);
            vueloRepository.save(v2);
            vueloRepository.save(v3);
            vueloRepository.save(v4);
            vueloRepository.save(v5);
            vueloRepository.save(v6);
            vueloRepository.save(v7);
            vueloRepository.save(v8);
            vueloRepository.save(v9);
            vueloRepository.save(v10);
            vueloRepository.save(v11);
            vueloRepository.save(v12);
            vueloRepository.save(v13);
            vueloRepository.save(v14);
            vueloRepository.save(v15);
            vueloRepository.save(v16);
            vueloRepository.save(v17);
            vueloRepository.save(v18);
        }catch (ParseException e){
            System.err.println("Error al guardar los vuelos en la BBDD. Error al parsear la fecha.");
        }
    }


    // Devolver vuelos dada una fecha, origen y destino
    @RequestMapping(value = "/vuelos/{fecha}/{origen}/{destino}", method = RequestMethod.GET)
    public List<Vuelo> getVuelosFecha(@PathVariable("fecha") String fecha, @PathVariable("origen") String origen, @PathVariable("destino") String destino){
        // Convertir el formato de la fecha al formato dd-MM-yyyy
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try{
            return vuelosService.getVuelosFechaOrigenDestino(simpleDateFormat.parse(fecha), origen.substring(0, origen.length() - 6), destino.substring(0, destino.length() - 6));
        } catch (ParseException e){
            System.err.println("Error al hacer el parse de la fecha.");
            return null;
        }
    }

}
