package ai.idealistic.vacan.listeners.a;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class b implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(PlayerDeathEvent var1) {
      a(var1.getEntity(), false, var1);
   }

   public static void a(Player var0, boolean var1, Object var2) {
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.a(var0, true);
      var3.gH.c(50L);
      if (var3.bW() == var1) {
         var3.b((Object)null, var2);
      }

   }
}
