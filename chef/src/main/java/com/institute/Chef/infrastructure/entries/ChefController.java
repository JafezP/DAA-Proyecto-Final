package com.institute.Chef.infrastructure.entries;


import com.institute.Chef.domain.model.Chef;
import com.institute.Chef.domain.service.ChefService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/instituto/chef/")
public class ChefController {
    private final ChefService chefService;


    @GetMapping
    ResponseEntity<List<Chef>> getAllChef() {
        return ResponseEntity.ok(chefService.findAll());
    }

    @GetMapping("/{uid}")
    ResponseEntity<Chef> getChefByUid(@PathVariable("uid") String uid) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(chefService.findById(uid));
    }
    @PostMapping
    ResponseEntity<Chef> createChef(@RequestBody Chef chef) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(chefService.save(chef));
    }
    @PutMapping("/{uid}")
    ResponseEntity<Chef> updateChef(@PathVariable("uid") String uid, @RequestBody Chef chef) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(chefService.update(uid, chef));
    }
    @DeleteMapping("/{uid}")
    ResponseEntity<Void> deleteChefByUid(@PathVariable("uid") String uid) {
        chefService.deleteById(uid);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
