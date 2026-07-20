package com.infosys.ConsentService.service;

import com.infosys.ConsentService.model.Consent;

import java.util.List;

public interface ConsentService {

    Consent saveConsent(Consent consent);

    List<Consent> getAllConsents();

    Consent getConsentById(String id);

    Consent updateConsent(String id, Consent consent);

    void deleteConsent(String id);
}