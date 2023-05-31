package com.xinthe.pms.service.impl;

import com.xinthe.pms.model.PmsCollection;
import com.xinthe.pms.repository.PMSRepository;
import com.xinthe.pms.service.PmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsServiceImpl implements PmsService {

    private final PMSRepository pmsRepository;

    @Autowired
    public PmsServiceImpl(PMSRepository pmsRepository) {
        this.pmsRepository = pmsRepository;
    }

    @Override
    public List<PmsCollection> getAllCollections() {
        return pmsRepository.findAll();
    }

    @Override
    public PmsCollection getCollectionById(String id) {
        return pmsRepository.findById(id).orElse(null);
    }

    @Override
    public PmsCollection createCollection(PmsCollection collection) {
        return pmsRepository.save(collection);
    }

    @Override
    public PmsCollection updateCollection(String id, PmsCollection collection) {
        PmsCollection existingCollection = pmsRepository.findById(id).orElse(null);
        if (existingCollection != null) {
            collection.setId(existingCollection.getId());
            return pmsRepository.save(collection);
        }
        return null;
    }

    @Override
    public void deleteCollection(String id) {
        pmsRepository.deleteById(id);
    }
}
