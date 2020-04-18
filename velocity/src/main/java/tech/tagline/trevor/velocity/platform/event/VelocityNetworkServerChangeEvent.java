package tech.tagline.trevor.velocity.platform.event;

import tech.tagline.trevor.api.network.payload.ServerChangePayload;
import tech.tagline.trevor.api.network.event.NetworkServerChangeEvent;

import java.util.UUID;

public class VelocityNetworkServerChangeEvent extends VelocityNetworkEvent implements NetworkServerChangeEvent {

  private final UUID uuid;
  private final String server;
  private final String previousServer;

  public VelocityNetworkServerChangeEvent(ServerChangePayload payload) {
    this.uuid = payload.getUUID();
    this.server = payload.getServer();
    this.previousServer = payload.getPreviousServer();
  }

  @Override
  public UUID getUUID() {
    return uuid;
  }

  @Override
  public String getServer() {
    return server;
  }

  @Override
  public String getPreviousServer() {
    return previousServer;
  }
}
