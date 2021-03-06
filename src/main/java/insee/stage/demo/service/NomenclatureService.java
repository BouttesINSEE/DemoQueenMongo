package insee.stage.demo.service;

import insee.stage.demo.model.Metadata;
import insee.stage.demo.model.Nomenclature;
import insee.stage.demo.repository.NomenclatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NomenclatureService {
    private final NomenclatureRepository nomenclatureRepository;

    public NomenclatureService(NomenclatureRepository nomenclatureRepository){
        this.nomenclatureRepository = nomenclatureRepository;
    }

    public void addNomenclature(Nomenclature nomenclature) {
        nomenclatureRepository.insert(nomenclature);
    }

    public List<Nomenclature> getAllNomenclature() {
        return nomenclatureRepository.findAll();
    }

    public Nomenclature getNomenclatureById(String id){
        return nomenclatureRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find nomenclature by Id %s", id)));
    }
}

