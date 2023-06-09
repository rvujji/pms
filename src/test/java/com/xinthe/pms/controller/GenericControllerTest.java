package com.xinthe.pms.controller;

import com.xinthe.pms.controller.GenericController;
import com.xinthe.pms.model.Project;
import com.xinthe.pms.service.GenericService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class GenericControllerTest {

    @Mock
    private GenericService<Project, String> service;

    @InjectMocks
    private GenericController<Project, String> controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllObjects() {
        // Prepare test data
        List<Project> projects = new ArrayList<>();
        projects.add(new Project());
        projects.add(new Project());

        // Mock service method
        Mockito.when(service.getAll()).thenReturn(projects);

        // Call the controller method
        ResponseEntity<List<Project>> response = controller.getAllObjects();

        // Verify the response
        Mockito.verify(service, Mockito.times(1)).getAll();
        Mockito.verifyNoMoreInteractions(service);
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == projects;
    }

    @Test
    public void testGetObjectById() {
        // Prepare test data
        String projectId = "123";
        Project project = new Project();
        project.setId(projectId);

        // Mock service method
        Mockito.when(service.getById(projectId)).thenReturn(project);

        // Call the controller method
        ResponseEntity<Project> response = controller.getObjectById(projectId);

        // Verify the response
        Mockito.verify(service, Mockito.times(1)).getById(projectId);
        Mockito.verifyNoMoreInteractions(service);
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == project;
    }

}
