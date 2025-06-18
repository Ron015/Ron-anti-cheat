package ai.idealistic.vacan.listeners.a;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class e implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(PlayerTeleportEvent var1) {
      b(var1.getPlayer(), false, var1);
   }

   public static void b(Player var0, boolean var1, Object var2) {
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.a(var0, true);
      if (var3.bW() == var1 || var2 instanceof PlayerTeleportEvent) {
         var3.b((Object)null, var2);
      }

   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(PlayerRespawnEvent var1) {
      c(var1.getPlayer(), false, var1);
   }

   public static void c(Player var0, boolean var1, Object var2) {
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.a(var0, true);
      if (var3.bW() == var1) {
         var3.b((Object)null, var2);
      }

   }
}
