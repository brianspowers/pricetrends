package net.brianpowers.blsviewer.wsclient;

import com.google.common.collect.Lists;
import net.brianpowers.blsviewer.model.BlsDataResponse;
import net.brianpowers.blsviewer.model.Series;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BlsDataServiceClientImplTest {

    private BlsDataServiceClient client;
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        Environment env = mock(Environment.class);
        restTemplate = mock(RestTemplate.class);

        client = new BlsDataServiceClientImpl(env, restTemplate);
    }

    @Test
    public void testGetBlsData() throws Exception {
        Series series = mock(Series.class);
        when(series.getSeriesId()).thenReturn("TESTSERIES");
        List<Series> seriesList = Lists.newArrayList(series);

        BlsDataResponse response = mock(BlsDataResponse.class);
        when(response.getStatus()).thenReturn("REQUEST_SUCCEEDED");
        when(response.getSeries()).thenReturn(seriesList);
        when(restTemplate.postForObject(Mockito.anyString(), Mockito.any(BlsDataRequest.class), Mockito.any())).thenReturn(response);

        assertThat(series, is(client.getBlsData("12345")));
    }

    @Test
    public void testGetBlsDataFailure() throws Exception {
        Series series = mock(Series.class);
        when(series.getSeriesId()).thenReturn("TESTSERIES");
        List<Series> seriesList = Lists.newArrayList(series);

        BlsDataResponse response = mock(BlsDataResponse.class);
        when(response.getStatus()).thenReturn("REQUEST_NOT_PROCESSED");
        when(response.getSeries()).thenReturn(seriesList);
        when(restTemplate.postForObject(Mockito.anyString(), Mockito.any(BlsDataRequest.class), Mockito.any())).thenReturn(response);

        assertThat(client.getBlsData("12345"), is(nullValue()));
    }

}