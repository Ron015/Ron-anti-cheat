package ai.idealistic.vacan.listeners.protocol.b;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class c extends PacketAdapter {
   public c() {
      super(Register.plugin, ListenerPriority.HIGHEST, new PacketType[]{Server.LOGIN});
   }

   public void onPacketSending(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      if (!var3.bX()) {
         d.m(var3.ci());
         var3.gt = true;
         Bukkit.getScheduler().runTaskLater(Register.plugin, () -> {
            if (var3.cg() != null) {
               var3.gZ = true;
            }

         }, 1L);
      }
   }
}
