package com.infosys.VitalsService.controller;

import com.infosys.VitalsService.model.Vital;
import com.infosys.VitalsService.service.VitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vitals")
@CrossOrigin(origins = "*")
public class VitalController {

    @Autowired
    private VitalService vitalService;

    // Save Vital (Saves to MongoDB + Sends to Kafka)
    @PostMapping
    public Vital saveVital(@RequestBody Vital vital) {
        return vitalService.saveVital(vital);
    }

    // Get All Vitals
    @GetMapping
    public List<Vital> getAllVitals() {
        return vitalService.getAllVitals();
    }

    // Get Vital By Id
    @GetMapping("/{id}")
    public Vital getVitalById(@PathVariable String id) {
        return vitalService.getVitalById(id);
    }

    // Update Vital
    @PutMapping("/{id}")
    public Vital updateVital(@PathVariable String id,
                             @RequestBody Vital vital) {
        return vitalService.updateVital(id, vital);
    }

    // Delete Vital
    @DeleteMapping("/{id}")
    public void deleteVital(@PathVariable String id) {
        vitalService.deleteVital(id);
    }
}