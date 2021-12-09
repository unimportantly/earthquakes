package project.service;

import org.modelmapper.ModelMapper;
import project.dto.earthquake.EarthquakeDTO;
import project.dto.earthquake.EarthquakeDeleteDTO;
import project.dto.earthquake.EarthquakeSaveDTO;
import project.dto.earthquake.EarthquakeUpdateDTO;
import project.entities.Earthquake;
import project.repository.EarthquakeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EarthquakeService implements CRUDService<EarthquakeDTO, EarthquakeSaveDTO, EarthquakeUpdateDTO, EarthquakeDeleteDTO> {

    // create a repo & mapper to be used throughout
    EarthquakeRepository earthquakeRepository;
    ModelMapper modelMapper;

    // inject them into the controller so that spring can find them
    public EarthquakeService(EarthquakeRepository earthquakeRepository, ModelMapper modelMapper) {
        this.earthquakeRepository = earthquakeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EarthquakeDTO> findAll() {
        // instanciate a list to fill & return
        List<EarthquakeDTO> earthquakeDTOList = new ArrayList<>();
        // run through each entry in the db then map them into DTOs then add them to the list
        this.earthquakeRepository.findAll().forEach(earthquake -> {
            earthquakeDTOList.add(this.modelMapper.map(earthquake, EarthquakeDTO.class));
        });
        return earthquakeDTOList;
    }

    @Override
    public EarthquakeDTO find(String id) {
        // create a husk to be potentially filled later
        EarthquakeDTO earthquakeDTO = null;
        // queries the db through an id, stores the return into an optional
        Optional<Earthquake> earthquake = this.earthquakeRepository.findById(id);
        // if there is an object inside the optional, map it & store it, if not, do nothing
        if(earthquake.isPresent()){
            earthquakeDTO = this.modelMapper.map(earthquake.get(), EarthquakeDTO.class);
        }
        return earthquakeDTO;
    }

    @Override
    public EarthquakeDTO save(EarthquakeSaveDTO obj) {
        // map the DTO into an entity, save it to the db, return a mapped DTO
        this.earthquakeRepository.save(this.modelMapper.map(obj, Earthquake.class));
        return this.modelMapper.map(obj, EarthquakeDTO.class);
    }

    @Override
    public EarthquakeDTO update(EarthquakeUpdateDTO obj) {
        // map the DTO into an entity, save it to the db, return a mapped DTO
        this.earthquakeRepository.save(this.modelMapper.map(obj, Earthquake.class));
        return this.modelMapper.map(obj, EarthquakeDTO.class);
    }

    @Override
    public void delete(EarthquakeDeleteDTO earthquakeDeleteDTO) {
        // map the dto into an entity, delete it
        earthquakeRepository.delete(this.modelMapper.map(earthquakeDeleteDTO, Earthquake.class));
    }
}
