package com.sip.ams_rest.services;

import com.sip.ams_rest.repositories.ProviderRepository;
import com.sip.ams_rest.entities.Provider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImp implements ProviderService  {

    private final ProviderRepository providerRepository;

    public ProviderServiceImp(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public List<Provider> listProviders() {
        return (List<Provider>)this.providerRepository.findAll();
    }

    @Override
    public Provider getProvider(long id) {
        return this.providerRepository.findById(id).get();
    }

    @Override
    public Provider saveProvider(Provider provider) {
        return this.providerRepository.save(provider);
    }
/*
    @Override
    public Provider deleteProvider(long id) {
        // TODO Auto-generated method stub
        return null;
    }
*/
    @Override
    public void deleteProvider(long id) {
        this.providerRepository.deleteById(id);
    }



}
