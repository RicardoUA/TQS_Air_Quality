package tqs.airquality.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tqs.airquality.entities.Aqi;
import tqs.airquality.services.AqiService;

@RestController
@RequestMapping("/api")
public class AqiController {
    private AqiService aqiService;

    public AqiController(AqiService aqiService) {
        this.aqiService = aqiService;

    }

    @GetMapping("/aqi")
    public ResponseEntity<Aqi> search(){
        return aqiService.search();
    };

    @GetMapping("/aqi/{city}")
    public ResponseEntity<Aqi> search(@PathVariable("city") String city){
        return aqiService.search(city);
    };

    @PostMapping("/aqi/city")
    public String openPage(String cityName) {
        return "redirect:/aqi/" + cityName;
    }
}
