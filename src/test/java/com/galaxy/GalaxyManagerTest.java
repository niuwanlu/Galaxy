package com.galaxy;

import com.galaxy.processor.UnitStateProcessor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class GalaxyManagerTest {

    private GalaxyManager galaxyManager;

    @Mock
    UnitStateProcessor unitStateProcessor;

    @Before
    public void setUp() {
        initMocks(this);
        galaxyManager = new GalaxyManager(unitStateProcessor);
    }

    @Test
    public void shouldCheckInputType() throws Exception {
        galaxyManager.processInput("glob is I");
        verify(unitStateProcessor).process("glob is I");
    }
}