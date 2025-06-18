package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class d extends PacketAdapter {
   public static final PacketType[] jQ;

   public d() {
      super(Register.plugin, ListenerPriority.HIGHEST, jQ);
   }

   public void onPacketSending(PacketEvent var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
      if (!var2.bX()) {
         PacketContainer var3 = var1.getPacket();
         if (var3.getType().equals(Server.UPDATE_HEALTH) && (Float)var3.getFloat().read(0) <= 0.0F) {
            ai.idealistic.vacan.listeners.a.b.a(var1.getPlayer(), true, var1);
            var2.gw = false;
         }

      }
   }

   static {
      jQ = new PacketType[]{Server.UPDATE_HEALTH};
   }
}
