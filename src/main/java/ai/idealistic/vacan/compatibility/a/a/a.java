package ai.idealistic.vacan.compatibility.a.a;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import be.anybody.api.advancedabilities.ability.event.AbilityCallEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class a implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(AbilityCallEvent var1) {
      if (Compatibility.CompatibilityType.ADVANCED_ABILITIES.isFunctional()) {
         ai.idealistic.vacan.functionality.server.a.jc.a(ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer()), Compatibility.CompatibilityType.ADVANCED_ABILITIES, (CheckEnums.HackCategoryType[])(new CheckEnums.HackCategoryType[]{CheckEnums.HackCategoryType.MOVEMENT, CheckEnums.HackCategoryType.COMBAT}), 60);
      }

   }
}
