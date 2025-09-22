package com.sip.ams_rest.controllers;

import org.springframework.web.bind.annotation.*;
import com.sip.ams_rest.entities.Provider;
import com.sip.ams_rest.services.ProviderService;

import java.util.List;

@RestController
@RequestMapping("/providers")
@CrossOrigin("*")
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        super();
        this.providerService = providerService;
    }

    @GetMapping("/")
    List<Provider> getAllProviders()
    {
        return this.providerService.listProviders();
    }

    @PostMapping("/")
    Provider addProvider(@RequestBody Provider provider)
    {
        return this.providerService.saveProvider(provider);
    }

    @GetMapping("/{id}")
    Provider getProviderById(@PathVariable("id") long id)
    {
        return this.providerService.getProvider(id);
    }

    @DeleteMapping("/{id}")
    synchronized boolean deleteProviderById(@PathVariable("id") long id) {
        boolean deleted = false;
        try {
            Provider provider = this.providerService.getProvider(id);

            if (provider != null) {
                this.providerService.deleteProvider(id);
                deleted = true;
            } else {
                throw new IllegalArgumentException("Provider not found : "+id);
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println(ex.getMessage());
            //logger.log(Level.INFO, "Delete provider problem : "+ LocalDateTime.now()+" "+ ex.getMessage()+" :"+id);
        }
        return deleted;

    }

    @PutMapping("/")
    Provider editProvider(@RequestBody Provider provider) {
        return this.providerService.saveProvider(provider);
    }
}
