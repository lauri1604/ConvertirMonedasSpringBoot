package org.iesteis.formulariospringbootmonedas.service;

import org.iesteis.formulariospringbootmonedas.dto.CambioData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CambioService {

    private final RestTemplate restTemplate = new RestTemplate();

    public float convertir(String from, String to, float importe) {

        String url = "https://api.frankfurter.app/latest?amount="
                + importe + "&from=" + from + "&to=" + to;

        CambioData data = restTemplate.getForObject(url, CambioData.class);

        return data.getRates().get(to);
    }
}