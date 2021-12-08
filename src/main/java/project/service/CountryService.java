package project.service;

import org.modelmapper.ModelMapper;
import project.dto.country.CountryDTO;
import project.dto.country.CountryDeleteDTO;
import project.dto.country.CountrySaveDTO;
import project.dto.country.CountryUpdateDTO;
import project.repository.CountryRepository;

import java.util.List;

public class CountryService implements CRUDService<CountryDTO, CountrySaveDTO, CountryUpdateDTO, CountryDeleteDTO> {

    CountryRepository countryRepository;
    ModelMapper modelMapper;

    public CountryService(CountryRepository countryRepository, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CountryDTO> findAll() {
        return null;
    }

    @Override
    public CountryDTO findById(String id) {
        return null;
    }

    @Override
    public CountryDTO save(CountrySaveDTO obj) {
        return null;
    }

    @Override
    public CountryDTO update(CountryUpdateDTO obj) {
        return null;
    }

    @Override
    public void delete(CountryDeleteDTO obj) {

    }
}
