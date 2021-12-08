package project.service;

import org.modelmapper.ModelMapper;
import project.dto.earthquake.EarthquakeDTO;
import project.dto.earthquake.EarthquakeDeleteDTO;
import project.dto.earthquake.EarthquakeSaveDTO;
import project.dto.earthquake.EarthquakeUpdateDTO;
import project.repository.EarthquakeRepository;

import java.util.List;

public class EarthquakeService implements CRUDService<EarthquakeDTO, EarthquakeSaveDTO, EarthquakeUpdateDTO, EarthquakeDeleteDTO> {

    EarthquakeRepository earthquakeRepository;
    ModelMapper modelMapper;

    public EarthquakeService(EarthquakeRepository earthquakeRepository, ModelMapper modelMapper) {
        this.earthquakeRepository = earthquakeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EarthquakeDTO> findAll() {
        return null;
    }

    @Override
    public EarthquakeDTO findById(String id) {
        return null;
    }

    @Override
    public EarthquakeDTO save(EarthquakeSaveDTO obj) {
        return null;
    }

    @Override
    public EarthquakeDTO update(EarthquakeUpdateDTO obj) {
        return null;
    }

    @Override
    public void delete(EarthquakeDeleteDTO obj) {

    }
}
