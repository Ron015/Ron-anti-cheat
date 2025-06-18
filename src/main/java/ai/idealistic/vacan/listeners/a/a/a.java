package ai.idealistic.vacan.listeners.a.a;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class a implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void e(EntityShootBowEvent var1) {
      LivingEntity var2 = var1.getEntity();
      if (var2 instanceof Player) {
         ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.a((Player)var2, true);
         var3.b(var1.isCancelled(), var1);
      }

   }
}
