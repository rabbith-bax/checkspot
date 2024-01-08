package com.checkspot.checkspot;

import com.checkspot.checkspot.model.Spot;
import com.checkspot.checkspot.resource.SpotResource;
import com.checkspot.checkspot.service.SpotService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SpotResourceTest {

    @Mock
    private SpotService spotService;

    @InjectMocks
    private SpotResource spotResource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllSpots_shouldReturnListOfSpots() {
        // Arrange
        List<Spot> spots = Arrays.asList(new Spot(), new Spot());
        when(spotService.findAllSpots()).thenReturn(spots);

        // Act
        ResponseEntity<List<Spot>> responseEntity = spotResource.getAllSpots();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(spots, responseEntity.getBody());
        verify(spotService, times(1)).findAllSpots();
    }

    @Test
    void getSpotById_shouldReturnSpotIfExists() {
        // Arrange
        Long spotId = 1L;
        Spot spot = new Spot();
        Optional<Spot> optionalSpot = Optional.of(spot);
        when(spotService.findSpotById(spotId)).thenReturn(optionalSpot);

        // Act
        ResponseEntity<Optional<Spot>> responseEntity = spotResource.getSpotById(spotId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(optionalSpot, responseEntity.getBody());
        verify(spotService, times(1)).findSpotById(spotId);
    }

    @Test
    void addSpot_shouldReturnCreatedAndSpot() {
        // Arrange
        Spot spot = new Spot();
        when(spotService.addSpot(spot)).thenReturn(spot);

        // Act
        ResponseEntity<Spot> responseEntity = spotResource.addSpot(spot);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(spot, responseEntity.getBody());
        verify(spotService, times(1)).addSpot(spot);
    }

    @Test
    void updateSpot_shouldReturnUpdatedSpot() {
        // Arrange
        Spot spot = new Spot();
        when(spotService.updateSpot(spot)).thenReturn(spot);

        // Act
        ResponseEntity<Spot> responseEntity = spotResource.updateSpot(spot);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(spot, responseEntity.getBody());
        verify(spotService, times(1)).updateSpot(spot);
    }

    @Test
    void deleteSpotById_shouldReturnOk() {
        // Arrange
        Long spotId = 1L;

        // Act
        ResponseEntity<?> responseEntity = spotResource.deleteSpotById(spotId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(spotService, times(1)).deleteSpotById(spotId);
    }
}

