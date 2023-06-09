    package com.xinthe.pms.controller;

    import com.xinthe.pms.service.GenericService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

    import java.util.List;

    @RestController
    @RequestMapping("/api/generic")
    public class GenericController<T, ID> {

        private final GenericService<T, ID> service;

        @Autowired
        public GenericController(GenericService<T, ID> service) {
            this.service = service;
        }

        @GetMapping("/objects")
        public ResponseEntity<List<T>> getAllObjects() {
            List<T> objects = service.getAll();
            return ResponseEntity.ok(objects);
        }

        @GetMapping("/objects/{id}")
        public ResponseEntity<T> getObjectById(@PathVariable ID id) {
            T object = service.getById(id);
            if (object != null) {
                return ResponseEntity.ok(object);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping("/objects")
        public ResponseEntity<T> createObject(@RequestBody T object) {
            T createdObject = service.create(object);
            return new ResponseEntity<>(createdObject, HttpStatus.CREATED);
        }

        @PutMapping("/objects/{id}")
        public ResponseEntity<T> updateObject(@PathVariable ID id, @RequestBody T object) {
            T updatedObject = service.update(id, object);
            if (updatedObject != null) {
                return ResponseEntity.ok(updatedObject);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/objects/{id}")
        public ResponseEntity<String> deleteObject(@PathVariable ID id) {
            service.delete(id);
            return ResponseEntity.ok("Object deleted successfully");
        }

        // Hystrix fallback method for getObjectById
        @GetMapping("/objects/fallback/{id}")
        @HystrixCommand(fallbackMethod = "getObjectByIdFallback")
        public ResponseEntity<String> getObjectByIdFallback(@PathVariable ID id) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve object with ID: " + id);
        }

        // Hystrix fallback method for updateObject
        @PutMapping("/objects/fallback/{id}")
        @HystrixCommand(fallbackMethod = "updateObjectFallback")
        public ResponseEntity<String> updateObjectFallback(@PathVariable ID id, @RequestBody T object) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update object with ID: " + id);
        }
    }
