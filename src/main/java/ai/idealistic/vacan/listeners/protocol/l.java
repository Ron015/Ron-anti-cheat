package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class l extends PacketAdapter {
   public static final PacketType[] jQ;

   public l() {
      super(Register.plugin, ListenerPriority.HIGHEST, jQ);
   }

   public void onPacketSending(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      if (!var3.bX()) {
         PacketType var4 = var1.getPacket().getType();
         if (var4.equals(Server.POSITION)) {
            ai.idealistic.vacan.listeners.a.e.b(var2, true, var1);
         } else if (var4.equals(Server.RESPAWN)) {
            ai.idealistic.vacan.listeners.a.e.c(var2, true, var1);
         }

      }
   }

   public static Location e(Location var0, Location var1) {
      return new Location(var1.getWorld(), var0.getX() + var1.getX(), var0.getY() + var1.getY(), var0.getZ() + var1.getZ());
   }

   static {
      jQ = new PacketType[]{Server.POSITION, Server.RESPAWN};
   }
}
