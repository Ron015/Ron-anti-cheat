package ai.idealistic.vacan.listeners.protocol.b;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.entity.Player;

public class a extends PacketAdapter {
   public a() {
      super(Register.plugin, ListenerPriority.HIGHEST, fp());
   }

   public void onPacketReceiving(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      var3.gH.c(50L);
   }

   private static PacketType[] fp() {
      return MultiVersion.c(MultiVersion.MCVersion.V1_9) ? new PacketType[]{Client.USE_ITEM, ai.idealistic.vacan.compatibility.b.a.b.F("USE_ITEM_ON") ? Client.USE_ITEM_ON : Client.BLOCK_PLACE} : new PacketType[]{ai.idealistic.vacan.compatibility.b.a.b.F("USE_ITEM_ON") ? Client.USE_ITEM_ON : Client.BLOCK_PLACE};
   }
}
