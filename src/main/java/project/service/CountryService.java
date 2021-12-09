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

    // repo & mapper to be used throughout => singleton
    CountryRepository countryRepository;
    ModelMapper modelMapper;

    // link them through the constructor
    public CountryService(CountryRepository countryRepository, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CountryDTO> findAll() {
        // create a list to populate then return
        List<CountryDTO> countryDTOList = new ArrayList<>();
        // queries the db for all entities, map them to DTO, add them to the list
        this.countryRepository.findAll().forEach(country -> {
            countryDTOList.add(this.modelMapper.map(country, CountryDTO.class));
        });
        return countryDTOList;
    }

    @Override
    public CountryDTO find(String id) {
        // create empty husk
        CountryDTO countryDTO = null;
        // asks the db to find an entity through its id; if it exists, map it, store it.
        // Either way, return it
        Optional<Country> country = countryRepository.findById(id);
        if(country.isPresent()){
            countryDTO = modelMapper.map(country.get(), CountryDTO.class);
        }
        return countryDTO;
    }

    @Override
    public CountryDTO save(CountrySaveDTO obj) {
        // map a DTO into an entity, save it, return a mapped DTO
        this.countryRepository.save(this.modelMapper.map(obj, Country.class));
        return this.modelMapper.map(obj, CountryDTO.class);
    }

    @Override
    public CountryDTO update(CountryUpdateDTO obj) {
        // map a DTO into an entity, save it, return a mapped DTO
        this.countryRepository.save(this.modelMapper.map(obj, Country.class));
        return this.modelMapper.map(obj, CountryDTO.class);
    }

    @Override
    public void delete(CountryDeleteDTO countryDeleteDTO) {
        // map DTO into an entity, delete it from the db
        this.countryRepository.delete(this.modelMapper.map(countryDeleteDTO, Country.class));
    }
}
