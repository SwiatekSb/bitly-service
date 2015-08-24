package com.swiatowski.bitly.core.services.impl;

import com.swiatowski.bitly.core.repositories.LinkRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by Piotrek on 8/24/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class LinkServiceImplTest {

    private static final String LINK = "link";
    @Mock
    private LinkRepo linkRepo;

    @InjectMocks
    private LinkServiceImpl service;

    @Test
    public void createLink() throws Exception {
        service.createLink(LINK);

        verify(linkRepo).createLink(LINK);
    }

    @Test
    public void findAllLinks() throws Exception {
        service.findAllLinks();

        verify(linkRepo).findAllLinks();
    }

    @Test
    public void findLink() throws Exception {
        service.findLink(1L);

        verify(linkRepo).findLink(1L);
    }

    @Test
    public void deleteLink() throws Exception {
        service.deleteLink(1L);

        verify(linkRepo).deleteLink(1L);
    }

    @Test
    public void findByEncodeName() throws Exception {
        service.findByEncodeName(LINK);

        verify(linkRepo).findByEncodeName(LINK);
    }
}