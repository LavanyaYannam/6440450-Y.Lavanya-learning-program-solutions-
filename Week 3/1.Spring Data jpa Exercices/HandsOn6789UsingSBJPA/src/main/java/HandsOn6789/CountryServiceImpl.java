package HandsOn6789;

import HandsOn6789.CountryNotFoundException;
import HandsOn6789.Country;
import HandsOn6789.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country findCountryByCode(String code) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (result.isEmpty()) {
            throw new CountryNotFoundException("Country not found with code: " + code);
        }
        return result.get();
    }

    @Override
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Country country = findCountryByCode(code);
        country.setName(name);
        countryRepository.save(country);
    }

    @Override
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public List<Country> searchCountriesByName(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }
}
