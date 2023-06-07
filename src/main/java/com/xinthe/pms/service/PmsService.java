package com.xinthe.pms.service;

import com.xinthe.pms.model.PmsCollection;

import java.util.List;

public interface PmsService {
    List<PmsCollection> getAllCollections();
    PmsCollection getCollectionById(String id);
    PmsCollection createCollection(PmsCollection collection);
    PmsCollection updateCollection(String id, PmsCollection collection);
    void deleteCollection(String id);
}
