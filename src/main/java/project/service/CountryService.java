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
    public CountryDTO findById(String id) {
        return this.modelMapper.map(this.countryRepository.findById(id), CountryDTO.class);
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
    public void delete(CountryDeleteDTO obj) {
        this.countryRepository.delete(this.modelMapper.map(obj, Country.class));
    }
}
