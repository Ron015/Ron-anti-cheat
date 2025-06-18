package ai.idealistic.vacan.listeners.a.a;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class j implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(EntityDeathEvent var1) {
      LivingEntity var2 = var1.getEntity();
      if (var2 instanceof Vehicle) {
         Entity[] var3 = MultiVersion.c(MultiVersion.MCVersion.V1_13) ? (Entity[])var2.getPassengers().toArray(new Entity[0]) : new Entity[]{var2.getPassenger()};
         if (var3.length > 0) {
            Entity[] var4 = var3;
            int var5 = var3.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               Entity var7 = var4[var6];
               if (var7 instanceof Player) {
                  ai.idealistic.vacan.abstraction.f.c var8 = ai.idealistic.vacan.functionality.server.c.a((Player)var7, true);
                  var8.b(false, new VehicleExitEvent((Vehicle)var2, (Player)var7, false));
               }
            }
         }
      }

   }
}
