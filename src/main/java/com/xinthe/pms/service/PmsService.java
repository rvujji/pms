package com.xinthe.pms.service;

import com.xinthe.pms.model.Project;

import java.util.List;

public interface PmsService {
    List<Project> getAllCollections();
    Project getCollectionById(String id);
    Project createCollection(Project collection);
    Project updateCollection(String id, Project collection);
    void deleteCollection(String id);
}
