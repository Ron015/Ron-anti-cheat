package ai.idealistic.vacan.listeners.a.a;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;

public class i implements Listener {
   @EventHandler
   private void a(PluginEnableEvent var1) {
      ai.idealistic.vacan.functionality.server.a.jc.dZ();
   }

   @EventHandler
   private void a(PluginDisableEvent var1) {
      ai.idealistic.vacan.functionality.server.a.jc.dZ();
   }
}
