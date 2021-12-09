package project.service;

import org.modelmapper.ModelMapper;
import project.dto.country.CountryDTO;
import project.dto.country.CountryDeleteDTO;
import project.dto.country.CountrySaveDTO;
import project.dto.country.CountryUpdateDTO;
import project.entities.Country;
import project.repository.CountryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryService implements CRUDService<CountryDTO, CountrySaveDTO, CountryUpdateDTO, CountryDeleteDTO> {

    CountryRepository countryRepository;
    ModelMapper modelMapper;

    public CountryService(CountryRepository countryRepository, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CountryDTO> findAll() {
        List<CountryDTO> countryDTOList = new ArrayList<>();
        this.countryRepository.findAll().forEach(country -> {
            countryDTOList.add(this.modelMapper.map(country, CountryDTO.class));
        });
        return countryDTOList;
    }

    @Override
    public CountryDTO find(String id) {
        CountryDTO countryDTO = null;
        Optional<Country> country = countryRepository.findById(id);
        if(country.isPresent()){
            countryDTO = modelMapper.map(country.get(), CountryDTO.class);
        }
        return countryDTO;
    }

    @Override
    public CountryDTO save(CountrySaveDTO obj) {
        this.countryRepository.save(this.modelMapper.map(obj, Country.class));
        return this.modelMapper.map(obj, CountryDTO.class);
    }

    @Override
    public CountryDTO update(CountryUpdateDTO obj) {
        this.countryRepository.save(this.modelMapper.map(obj, Country.class));
        return this.modelMapper.map(obj, CountryDTO.class);
    }

    @Override
    public void delete(CountryDeleteDTO countryDeleteDTO) {
        this.countryRepository.delete(this.modelMapper.map(countryDeleteDTO, Country.class));
    }
}
