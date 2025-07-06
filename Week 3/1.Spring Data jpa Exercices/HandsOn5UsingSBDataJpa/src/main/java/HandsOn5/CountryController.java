
package HandsOn5;

import HandsOn5.Country;
import HandsOn5.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public Country getByCode(@PathVariable String code) {
        return countryService.getCountryByCode(code);
    }

    
    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

}
