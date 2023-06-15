package com.xinthe.pms.controller;

import com.xinthe.pms.service.GenericService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GenericControllerTest {

    @Mock
    private GenericService<Object, Long> mockService;

    private GenericController<Object, Long> genericController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        genericController = new GenericController<>(mockService);
    }

    @Test
    public void getAllObjects_ShouldReturnListOfObjects() {
        // Arrange
        Object object1 = new Object();
        Object object2 = new Object();
        List<Object> objects = Arrays.asList(object1, object2);

        when(mockService.getAll()).thenReturn(objects);

        // Act
        ResponseEntity<List<Object>> response = genericController.getAllObjects();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(objects, response.getBody());
        verify(mockService, times(1)).getAll();
    }

    @Test
    public void getObjectById_WithValidId_ShouldReturnObject() {
        // Arrange
        Long objectId = 1L;
        Object object = new Object();

        when(mockService.getById(objectId)).thenReturn(object);

        // Act
        ResponseEntity<Object> response = genericController.getObjectById(objectId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(object, response.getBody());
        verify(mockService, times(1)).getById(objectId);
    }

    @Test
    public void getObjectById_WithInvalidId_ShouldReturnNotFound() {
        // Arrange
        Long invalidId = 100L;

        when(mockService.getById(invalidId)).thenReturn(null);

        // Act
        ResponseEntity<Object> response = genericController.getObjectById(invalidId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(mockService, times(1)).getById(invalidId);
    }

    @Test
    public void createObject_ShouldReturnCreatedObject() {
        // Arrange
        Object object = new Object();
        Object createdObject = new Object();

        when(mockService.create(object)).thenReturn(createdObject);

        // Act
        ResponseEntity<Object> response = genericController.createObject(object);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdObject, response.getBody());
        verify(mockService, times(1)).create(object);
    }

    @Test
    public void updateObject_WithValidId_ShouldReturnUpdatedObject() {
        // Arrange
        Long objectId = 1L;
        Object object = new Object();
        Object updatedObject = new Object();

        when(mockService.update(objectId, object)).thenReturn(updatedObject);

        // Act
        ResponseEntity<Object> response = genericController.updateObject(objectId, object);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedObject, response.getBody());
        verify(mockService, times(1)).update(objectId, object);
    }

    @Test
    public void updateObject_WithInvalidId_ShouldReturnNotFound() {
        // Arrange
        Long invalidId = 100L;
        Object object = new Object();

        when(mockService.update(invalidId, object)).thenReturn(null);

        // Act
        ResponseEntity<Object> response = genericController.updateObject(invalidId, object);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(mockService, times(1)).update(invalidId, object);
    }

    @Test
    public void deleteObject_ShouldReturnSuccessMessage() {
        // Arrange
        Long objectId = 1L;

        // Act
        ResponseEntity<String> response = genericController.deleteObject(objectId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Object deleted successfully", response.getBody());
        verify(mockService, times(1)).delete(objectId);
    }

    @Test
    public void getObjectByIdFallback_ShouldReturnErrorResponse() {
        // Arrange
        Long objectId = 1L;
        ResponseEntity<String> expectedResponse = ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to retrieve object with ID: " + objectId);

        // Act
        ResponseEntity<String> response = genericController.getObjectByIdFallback(objectId);

        // Assert
        assertEquals(expectedResponse, response);
    }

    @Test
    public void updateObjectFallback_ShouldReturnErrorResponse() {
        // Arrange
        Long objectId = 1L;
        Object object = new Object();
        ResponseEntity<String> expectedResponse = ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to update object with ID: " + objectId);

        // Act
        ResponseEntity<String> response = genericController.updateObjectFallback(objectId, object);

        // Assert
        assertEquals(expectedResponse, response);
    }
}