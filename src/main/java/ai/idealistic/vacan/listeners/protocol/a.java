package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.entity.Player;

public class a extends PacketAdapter {
   public a() {
      super(Register.plugin, ListenerPriority.NORMAL, new PacketType[]{Client.ABILITIES});
   }

   public void onPacketReceiving(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      if (var2.getAllowFlight()) {
         ai.idealistic.vacan.functionality.server.c.i(var2).gn = 2;
      }

   }
}
