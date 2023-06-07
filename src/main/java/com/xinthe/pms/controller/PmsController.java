package com.xinthe.pms.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xinthe.pms.model.PmsCollection;
import com.xinthe.pms.service.PmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/pms")
@Api(tags = "PMS Collection API")
@EnableHystrix
public class PmsController {

    private static final Logger logger = LoggerFactory.getLogger(PmsController.class);

    private final PmsService pmsService;

    @Autowired
    public PmsController(PmsService pmsService) {
        this.pmsService = pmsService;
    }

    @GetMapping("/collections")
    @ApiOperation("Get all collections")
    @HystrixCommand(fallbackMethod = "getAllCollectionsFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000")
    })
    public ResponseEntity<List<PmsCollection>> getAllCollections() {
        logger.info("Getting all collections");
        List<PmsCollection> collections = pmsService.getAllCollections();
        return new ResponseEntity<>(collections, HttpStatus.OK);
    }

    @GetMapping("/collections/{id}")
    @ApiOperation("Get collection by ID")
    @HystrixCommand(fallbackMethod = "getCollectionByIdFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000")
    })
    public ResponseEntity<PmsCollection> getCollectionById(@PathVariable("id") String id) {
        logger.info("Getting collection by ID: {}", id);
        PmsCollection collection = pmsService.getCollectionById(id);
        return new ResponseEntity<>(collection, HttpStatus.OK);
    }

    @PostMapping("/collections")
    @ApiOperation("Create a new collection")
    @HystrixCommand(fallbackMethod = "createCollectionFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000")
    })
    public ResponseEntity<PmsCollection> createCollection(@RequestBody PmsCollection collection) {
        logger.info("Creating a new collection");
        PmsCollection createdCollection = pmsService.createCollection(collection);
        return new ResponseEntity<>(createdCollection, HttpStatus.CREATED);
    }

    @PutMapping("/collections/{id}")
    @ApiOperation("Update collection by ID")
    @HystrixCommand(fallbackMethod = "updateCollectionFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000")
    })
    public ResponseEntity<PmsCollection> updateCollection(@PathVariable("id") String id, @RequestBody PmsCollection collection) {
        logger.info("Updating collection with ID: {}", id);
        PmsCollection updatedCollection = pmsService.updateCollection(id, collection);
        return new ResponseEntity<>(updatedCollection, HttpStatus.OK);
    }

    @DeleteMapping("/collections/{id}")
    @ApiOperation("Delete collection by ID")
    @HystrixCommand(fallbackMethod = "deleteCollectionFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000")
    })
    public ResponseEntity<Void> deleteCollection(@PathVariable("id") String id) {
        logger.info("Deleting collection with ID: {}", id);
        pmsService.deleteCollection(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Fallback methods
    public ResponseEntity<List<PmsCollection>> getAllCollectionsFallback() {
        logger.error("Fallback method called: getAllCollectionsFallback");
        // Return an empty list or default response as needed
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<PmsCollection> getCollectionByIdFallback(String id) {
        logger.error("Fallback method called: getCollectionByIdFallback");
        // Return a fallback collection or default response as needed
        return new ResponseEntity<>(new PmsCollection(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<PmsCollection> createCollectionFallback(PmsCollection collection) {
        logger.error("Fallback method called: createCollectionFallback");
        // Return a fallback collection or default response as needed
        return new ResponseEntity<>(new PmsCollection(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<PmsCollection> updateCollectionFallback(String id, PmsCollection collection) {
        logger.error("Fallback method called: updateCollectionFallback");
        // Return a fallback collection or default response as needed
        return new ResponseEntity<>(new PmsCollection(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Void> deleteCollectionFallback(String id) {
        logger.error("Fallback method called: deleteCollectionFallback");
        // Return a default response as needed
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
