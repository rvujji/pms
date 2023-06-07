package com.xinthe.pms.service.impl;

import com.xinthe.pms.model.Project;
import com.xinthe.pms.repository.ProjectRepository;
import com.xinthe.pms.service.PmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsServiceImpl implements PmsService {

    private final ProjectRepository projectRepository;

    @Autowired
    public PmsServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllCollections() {
        return projectRepository.findAll();
    }

    @Override
    public Project getCollectionById(String id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project createCollection(Project collection) {
        return projectRepository.save(collection);
    }

    @Override
    public Project updateCollection(String id, Project collection) {
        Project existingCollection = projectRepository.findById(id).orElse(null);
        if (existingCollection != null) {
            collection.setId(existingCollection.getId());
            return projectRepository.save(collection);
        }
        return null;
    }

    @Override
    public void deleteCollection(String id) {
        projectRepository.deleteById(id);
    }
}
