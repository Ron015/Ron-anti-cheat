package ai.idealistic.vacan.compatibility.a.b;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import com.bgsoftware.wildtools.api.events.ToolUseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class h implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(ToolUseEvent var1) {
      Compatibility.CompatibilityType var2 = Compatibility.CompatibilityType.WILD_TOOLS;
      if (var2.isFunctional()) {
         ai.idealistic.vacan.functionality.server.a.jc.a(ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer()), var2, (CheckEnums.HackType[])(new CheckEnums.HackType[]{CheckEnums.HackType.FAST_BREAK, CheckEnums.HackType.BLOCK_REACH, CheckEnums.HackType.GHOST_HAND}), 40);
      }

   }
}
