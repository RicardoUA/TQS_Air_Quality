package tqs.airquality.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tqs.airquality.entities.Aqi;

@Service
public class AqiService {
    private String url = "https://api.waqi.info/feed/newyork/?token=edf6a84b2d511e8c0e91963a00d8240e62302733";

    public ResponseEntity<Aqi> search(){
        RestTemplate template = new RestTemplate();
        ResponseEntity<Aqi> response = template.exchange(this.url, HttpMethod.GET, null, new ParameterizedTypeReference<Aqi>() {});
        System.out.println( response.getBody() );
        return response;
    }

    public ResponseEntity<Aqi> search(String city){
        url = "https://api.waqi.info/feed/" + city + "/?token=edf6a84b2d511e8c0e91963a00d8240e62302733";
        RestTemplate template = new RestTemplate();
        ResponseEntity<Aqi> response = template.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Aqi>() {});
        System.out.println( response.getBody() );
        return response;
    }
}
