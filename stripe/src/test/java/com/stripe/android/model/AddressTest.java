package com.stripe.android.model;

import android.support.annotation.NonNull;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.stripe.android.testharness.JsonTestUtils.assertMapEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Address}.
 */
public class AddressTest {

    static final String JSON_ADDRESS = "{" +
            "\"city\": \"San Francisco\"," +
            "\"country\": \"US\",\n" +
            "\"line1\": \"123 Market St\"," +
            "\"line2\": \"#345\"," +
            "\"postal_code\": \"94107\"," +
            "\"state\": \"CA\"" +
            "}";

    private static final Map<String, Object> MAP_ADDRESS = new HashMap<String, Object>() {{
        put("city", "San Francisco");
        put("country", "US");
        put("line1", "123 Market St");
        put("line2", "#345");
        put("postal_code", "94107");
        put("state", "CA");
    }};

    @NonNull private static final Address ADDRESS =
            Objects.requireNonNull(Address.fromString(JSON_ADDRESS));

    @Test
    public void fromJsonString_toParamMap_createsExpectedParamMap() {
        assertMapEquals(MAP_ADDRESS, ADDRESS.toParamMap());
    }

    @Test
    public void builderConstructor_whenCalled_createsExpectedAddress() {
        final Address address = new Address.Builder()
                .setCity("San Francisco")
                .setCountry("US")
                .setLine1("123 Market St")
                .setLine2("#345")
                .setPostalCode("94107")
                .setState("CA")
                .build();
        assertEquals(address, ADDRESS);
    }
}
