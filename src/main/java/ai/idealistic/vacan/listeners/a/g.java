package ai.idealistic.vacan.listeners.a;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class g implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public static void a(VehicleEnterEvent var0) {
      if (!var0.isCancelled()) {
         Entity var1 = var0.getEntered();
         if (var1 instanceof Player) {
            ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.a((Player)var1, true);
            var2.b(var0.isCancelled(), var0);
         }
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   public static void a(VehicleExitEvent var0) {
      if (!var0.isCancelled()) {
         LivingEntity var1 = var0.getExited();
         if (var1 instanceof Player) {
            ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.a((Player)var1, true);
            var2.b(var0.isCancelled(), var0);
         }
      }

   }
}
