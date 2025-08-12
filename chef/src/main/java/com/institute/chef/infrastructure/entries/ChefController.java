package com.institute.chef.infrastructure.entries;

import com.institute.chef.domain.model.Chef;
import com.institute.chef.domain.service.ChefService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/institute/chef")
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
                .status(HttpStatus.CREATED)
                .body(chefService.save(chef));
    }

    @PutMapping("/{uid}")
    ResponseEntity<Chef> updateChef(@PathVariable("uid") String uid,
                                    @RequestBody Chef chef) {
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
