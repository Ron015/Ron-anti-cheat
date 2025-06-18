package ai.idealistic.vacan.listeners.protocol;

import ai.idealistic.vacan.Register;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class p extends PacketAdapter {
   public p() {
      super(Register.plugin, ListenerPriority.HIGHEST, new PacketType[]{Client.STEER_VEHICLE, Client.POSITION, Client.POSITION_LOOK, Client.LOOK});
   }

   public void onPacketReceiving(PacketEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      if (!var3.bX()) {
         if (ai.idealistic.vacan.utils.minecraft.b.a.a(var1.getPacket().getType()) && var3.gZ) {
            var3.gZ = false;
         }

         boolean[] var4 = new boolean[]{false};
         ai.idealistic.vacan.functionality.b.a.b(() -> {
            Iterator var4x = var3.u(4.5D).iterator();

            while(var4x.hasNext()) {
               Entity var5 = (Entity)var4x.next();
               if (var5.getUniqueId() != var3.bT()) {
                  var4[0] = true;
                  break;
               }
            }

            if (var4[0]) {
               if (ai.idealistic.vacan.utils.minecraft.b.a.a(var1.getPacket().getType()) && var3.gZ) {
                  var3.gH.c(50L);
                  VehicleExitEvent var7 = new VehicleExitEvent((Vehicle)null, var3.bC());
                  var7.setCancelled(var1.isCancelled());
                  ai.idealistic.vacan.listeners.a.g.a(var7);
               } else if (var1.getPacket().getType().equals(Client.STEER_VEHICLE) && !var3.gZ) {
                  var3.gH.c(50L);
                  VehicleEnterEvent var6 = new VehicleEnterEvent((Vehicle)null, var3.bC());
                  var6.setCancelled(var1.isCancelled());
                  ai.idealistic.vacan.listeners.a.g.a(var6);
                  var3.gZ = true;
               }
            }

            if (var1.getPacket().getType().equals(Client.STEER_VEHICLE) && var3.cg() != null) {
               Entity var8 = var3.cg();
               Location var9 = var8.getLocation();
               var3.o(var9);
               ai.idealistic.vacan.listeners.a.c.a(new PlayerMoveEvent(var2, var3.bM(), var3.getLocation()), true);
            }

         });
      }
   }
}
