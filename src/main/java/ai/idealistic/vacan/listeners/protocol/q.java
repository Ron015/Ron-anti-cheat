package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class q extends PacketAdapter {
   public q() {
      super(Register.plugin, ListenerPriority.MONITOR, new PacketType[]{Server.ENTITY_VELOCITY});
   }

   public void onPacketSending(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      if (!var3.bX()) {
         PacketContainer var4 = var1.getPacket();
         if (!var4.getIntegers().getValues().isEmpty()) {
            int var5 = (Integer)var4.getIntegers().getValues().get(0);
            if (var3.ci() == var5) {
               ai.idealistic.vacan.functionality.b.a.b(() -> {
                  double var3 = ((Integer)var4.getIntegers().read(1)).doubleValue() / 8000.0D;
                  double var5 = ((Integer)var4.getIntegers().read(2)).doubleValue() / 8000.0D;
                  double var7 = ((Integer)var4.getIntegers().read(3)).doubleValue() / 8000.0D;
                  ai.idealistic.vacan.abstraction.d.c var9 = new ai.idealistic.vacan.abstraction.d.c(var2, new Vector(var3, var5, var7));
                  var9.setCancelled(var1.isCancelled());
                  ai.idealistic.vacan.listeners.a.h.a(var9, true);
               });
            }
         }

      }
   }
}
