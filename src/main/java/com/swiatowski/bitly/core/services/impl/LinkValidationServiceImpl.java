package com.swiatowski.bitly.core.services.impl;

import com.swiatowski.bitly.core.services.LinkValidationService;
import com.swiatowski.bitly.core.services.exceptions.LinkBadUrlException;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

/**
 * Created by Piotrek on 8/26/2015.
 */
@Service
public class LinkValidationServiceImpl implements LinkValidationService {
    @Override
    public void validateUrl(String url) {
        final UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});
        if (!urlValidator.isValid(url)) {
            throw new LinkBadUrlException();
        }
    }
}
