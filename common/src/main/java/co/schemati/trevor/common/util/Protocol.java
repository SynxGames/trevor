package co.schemati.trevor.common.util;

import com.google.gson.Gson;
import co.schemati.trevor.api.network.payload.NetworkPayload;

import java.util.Optional;

public class Protocol {

  public static String serialize(NetworkPayload<?> payload, Gson gson) {
    return payload.getClass().getCanonicalName() + "\0" + gson.toJson(payload);
  }

  public static Optional<NetworkPayload<?>> deserialize(String message, Gson gson) {
    try {
      String[] data = message.split("\0");

      Class<?> clazz = Class.forName(data[0]);
      if (clazz.isAssignableFrom(NetworkPayload.class)) {
        throw new IllegalStateException("Payload header is not a NetworkPayload: " + message);
      }

      return Optional.of((NetworkPayload<?>) gson.fromJson(data[1], clazz));
    } catch (ClassNotFoundException exception) {
      exception.printStackTrace();
    }
    return Optional.empty();
  }
}
