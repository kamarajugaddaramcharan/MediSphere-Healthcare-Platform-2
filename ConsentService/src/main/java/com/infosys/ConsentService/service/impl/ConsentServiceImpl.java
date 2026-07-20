package com.infosys.ConsentService.service.impl;

import com.infosys.ConsentService.model.Consent;
import com.infosys.ConsentService.repository.ConsentRepository;
import com.infosys.ConsentService.service.ConsentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsentServiceImpl implements ConsentService {

    @Autowired
    private ConsentRepository repository;

    @Override
    public Consent saveConsent(Consent consent) {
        return repository.save(consent);
    }

    @Override
    public List<Consent> getAllConsents() {
        return repository.findAll();
    }

    @Override
    public Consent getConsentById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Consent updateConsent(String id, Consent consent) {

        Consent existing = repository.findById(id).orElse(null);

        if (existing != null) {
            existing.setPatientId(consent.getPatientId());
            existing.setDoctorId(consent.getDoctorId());
            existing.setResourceType(consent.getResourceType());
            existing.setPermission(consent.getPermission());
            existing.setStatus(consent.getStatus());

            return repository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteConsent(String id) {
        repository.deleteById(id);
    }
}
