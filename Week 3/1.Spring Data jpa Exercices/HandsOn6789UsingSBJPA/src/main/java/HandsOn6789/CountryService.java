package HandsOn6789;
import HandsOn6789.CountryNotFoundException;
import HandsOn6789.Country;

import java.util.List;

public interface CountryService {
    Country findCountryByCode(String code) throws CountryNotFoundException;
    void addCountry(Country country);
    void updateCountry(String code, String name) throws CountryNotFoundException;
    void deleteCountry(String code);
    List<Country> getAllCountries();
    List<Country> searchCountriesByName(String name);
}
