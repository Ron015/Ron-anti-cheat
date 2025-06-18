package ai.idealistic.vacan.compatibility.a.a;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import com.nisovin.magicspells.events.SpellCastEvent;
import com.nisovin.magicspells.events.SpellCastedEvent;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class e implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(SpellCastEvent var1) {
      if (Compatibility.CompatibilityType.MAGIC_SPELLS.isFunctional()) {
         LivingEntity var2 = var1.getCaster();
         if (var2 instanceof Player) {
            ai.idealistic.vacan.functionality.server.a.jc.a(ai.idealistic.vacan.functionality.server.c.i((Player)var2), Compatibility.CompatibilityType.MAGIC_SPELLS, (CheckEnums.HackCategoryType[])(new CheckEnums.HackCategoryType[]{CheckEnums.HackCategoryType.MOVEMENT, CheckEnums.HackCategoryType.COMBAT}), 40);
         }
      }

   }

   @EventHandler
   private void a(SpellCastedEvent var1) {
      if (Compatibility.CompatibilityType.MAGIC_SPELLS.isFunctional()) {
         LivingEntity var2 = var1.getCaster();
         if (var2 instanceof Player) {
            ai.idealistic.vacan.functionality.server.a.jc.a(ai.idealistic.vacan.functionality.server.c.i((Player)var2), Compatibility.CompatibilityType.MAGIC_SPELLS, (CheckEnums.HackCategoryType[])(new CheckEnums.HackCategoryType[]{CheckEnums.HackCategoryType.MOVEMENT, CheckEnums.HackCategoryType.COMBAT}), 40);
         }
      }

   }
}
