package org.iesteis.formulariospringbootmonedas.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.HashMap;

@Getter
@Setter
public class CambioData {
    private float amount;
    private String base;
    private String date;
    private HashMap<String, Float> rates;
}
