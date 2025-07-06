package HandsOn5;
import HandsOn5.Country;
import HandsOn5.CountryRepository;
import HandsOn5.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country getCountryByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();  // ✅ Implementation goes here
    }
}
