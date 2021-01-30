package com.cybertek.entity;

import com.cybertek.controller.HomeController;
import com.cybertek.enums.AddressType;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "address")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","teacher"},ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class Address extends BaseEntity{


    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    private Integer currentTemperature;

    public Integer getCurrentTemperature(){

        return consumeTemp(this.city);
    }
    public Integer consumeTemp(String city){
        RestTemplate restTemplate = new RestTemplate();

        String baseURL= "http://api.weatherstack.com/current?access_key=02a009b8e3922c395677a1e85406aca6&query=";
        String url= baseURL+city;
        Object currentWeather=restTemplate.getForObject(url,Object.class);
        Map<String,Object>getWeather= (Map<String, Object>)currentWeather;
        Map<String,Object>getTemperature=(Map<String, Object>)getWeather.get("current");
        return Integer.parseInt(getTemperature.get("temperature").toString());

    }
    private String city;
    private String country;
    @Column(name="postal_code")
    private String postalCode;
    private String state;
    private String street;
    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Student student;
    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Parent parent;
    @OneToOne(mappedBy = "address")
    private Teacher teacher;





}
