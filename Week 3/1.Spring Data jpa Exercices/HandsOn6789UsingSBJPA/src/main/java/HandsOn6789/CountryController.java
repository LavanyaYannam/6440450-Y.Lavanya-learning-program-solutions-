package HandsOn6789;

import HandsOn6789.CountryNotFoundException;
import HandsOn6789.Country;
import HandsOn6789.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@CrossOrigin(origins = "*")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAll() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{code}")
    public Country getByCode(@PathVariable String code) throws CountryNotFoundException {
        return countryService.findCountryByCode(code);
    }

    @PostMapping
    public void addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
    }

    @PutMapping
    public void update(@RequestParam String code, @RequestParam String name) throws CountryNotFoundException {
        countryService.updateCountry(code, name);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code) {
        countryService.deleteCountry(code);
    }

    @GetMapping("/search")
    public List<Country> searchByName(@RequestParam String name) {
        return countryService.searchCountriesByName(name);
    }
}
