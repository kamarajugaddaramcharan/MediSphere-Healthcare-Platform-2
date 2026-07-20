package com.infosys.MediSphereApp.controller;

import com.infosys.MediSphereApp.model.Patient;
import com.infosys.MediSphereApp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return service.savePatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable String id) {
        return service.getPatientById(id);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable String id,
                                 @RequestBody Patient patient) {
        return service.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable String id) {
        service.deletePatient(id);
        return "Patient deleted successfully";
    }
}