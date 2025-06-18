package ai.idealistic.vacan.compatibility.a.a;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import de.flo56958.minetinker.events.MTPlayerInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class f implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(MTPlayerInteractEvent var1) {
      Compatibility.CompatibilityType var2 = Compatibility.CompatibilityType.MINE_TINKER;
      if (var2.isFunctional()) {
         ai.idealistic.vacan.functionality.server.a.jc.a(ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer()), var2, (CheckEnums.HackType[])(new CheckEnums.HackType[]{CheckEnums.HackType.KILL_AURA, CheckEnums.HackType.FAST_CLICKS, CheckEnums.HackType.HIT_REACH, CheckEnums.HackType.FAST_PLACE}), 40);
      }

   }
}
