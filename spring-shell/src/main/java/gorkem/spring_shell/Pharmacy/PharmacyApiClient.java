package gorkem.spring_shell.Pharmacy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        configuration = FeignClientConfig.class,
        url = "https://api.collectapi.com/health/dutyPharmacy",
        name = "pharmacy"
)
public interface PharmacyApiClient {

    @GetMapping
    ResponseEntity<PharmacyResponse>getPharmacies(
            @RequestParam(name = "il") String city,
            @RequestParam(name = "ilce",required = false) String district);




}
