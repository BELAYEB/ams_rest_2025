package com.sip.ams_rest.services;
import com.sip.ams_rest.entities.Provider;

import java.util.List;



public interface ProviderService {

    List<Provider> listProviders();
    Provider getProvider(long id);
    Provider saveProvider(Provider provider);
    //Provider deleteProvider(long id);
    void deleteProvider(long id);
}
