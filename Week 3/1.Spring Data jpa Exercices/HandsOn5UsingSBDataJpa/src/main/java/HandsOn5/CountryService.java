package HandsOn5;

import java.util.List;

public interface CountryService {
    Country getCountryByCode(String code);
    
    List<Country> getAllCountries();  // ✅ only declare here
}
