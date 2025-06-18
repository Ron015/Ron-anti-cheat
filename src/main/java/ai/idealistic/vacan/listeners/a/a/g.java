package ai.idealistic.vacan.listeners.a.a;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class g implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(PlayerJoinEvent var1) {
      Player var2 = var1.getPlayer();
      ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i(var2);
      if (ai.idealistic.vacan.functionality.server.a.iZ.i("Important.enable_watermark") && !ai.idealistic.vacan.functionality.server.b.h(var2)) {
         var2.sendMessage("");
         ai.idealistic.vacan.functionality.c.a.a(var3, "\nThis server is protected by the Vacan AntiCheat", false);
         var2.sendMessage("");
      }

      ai.idealistic.vacan.functionality.server.c.a(var3, () -> {
         ai.idealistic.vacan.functionality.server.a.iZ.c(var3);
         ai.idealistic.vacan.functionality.connection.a.n(var3);
      }, 10L);
   }
}
