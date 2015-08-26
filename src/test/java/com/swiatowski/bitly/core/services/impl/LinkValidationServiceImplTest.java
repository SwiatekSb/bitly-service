package com.swiatowski.bitly.core.services.impl;

import com.swiatowski.bitly.core.services.exceptions.LinkBadUrlException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Piotrek on 8/26/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class LinkValidationServiceImplTest {

    @InjectMocks
    private LinkValidationServiceImpl linkValidationService;

    @Test
    public void validateUrlAcceptHttp() throws Exception {
        linkValidationService.validateUrl("http://www.google.com");
        linkValidationService.validateUrl("https://www.google.com");
    }

    @Test(expected = LinkBadUrlException.class)
    public void validateUrlThrowException() throws Exception {
        linkValidationService.validateUrl("htp://");
    }
}