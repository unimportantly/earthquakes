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

    EarthquakeRepository earthquakeRepository;
    ModelMapper modelMapper;

    public EarthquakeService(EarthquakeRepository earthquakeRepository, ModelMapper modelMapper) {
        this.earthquakeRepository = earthquakeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EarthquakeDTO> findAll() {
        List<EarthquakeDTO> earthquakeDTOList = new ArrayList<>();
        this.earthquakeRepository.findAll().forEach(earthquake -> {
            earthquakeDTOList.add(this.modelMapper.map(earthquake, EarthquakeDTO.class));
        });
        return earthquakeDTOList;
    }

    @Override
    public EarthquakeDTO find(String id) {
        EarthquakeDTO earthquakeDTO = null;
        Optional<Earthquake> earthquake = this.earthquakeRepository.findById(id);
        if(earthquake.isPresent()){
            earthquakeDTO = this.modelMapper.map(earthquake.get(), EarthquakeDTO.class);
        }
        return earthquakeDTO;
    }

    @Override
    public EarthquakeDTO save(EarthquakeSaveDTO obj) {
        this.earthquakeRepository.save(this.modelMapper.map(obj, Earthquake.class));
        return this.modelMapper.map(obj, EarthquakeDTO.class);
    }

    @Override
    public EarthquakeDTO update(EarthquakeUpdateDTO obj) {
        this.earthquakeRepository.save(this.modelMapper.map(obj, Earthquake.class));
        return this.modelMapper.map(obj, EarthquakeDTO.class);
    }

    @Override
    public void delete(EarthquakeDeleteDTO earthquakeDeleteDTO) {
        earthquakeRepository.delete(this.modelMapper.map(earthquakeDeleteDTO, Earthquake.class));
    }
}
