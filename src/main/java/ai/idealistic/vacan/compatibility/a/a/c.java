package ai.idealistic.vacan.compatibility.a.a;

import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.compatibility.Compatibility;
import com.snowgears.grapplinghook.api.HookAPI;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.inventory.ItemStack;

public class c implements Listener {
   private static final String name = "grapplinghook";

   private static boolean e(ItemStack var0) {
      if (Compatibility.CompatibilityType.GRAPPLING_HOOK.isFunctional()) {
         try {
            return ai.idealistic.vacan.utils.minecraft.c.b.h("grapplinghook") ? HookAPI.isGrapplingHook(var0) : var0.getType() == Material.FISHING_ROD;
         } catch (Exception var2) {
         }
      }

      return false;
   }

   @EventHandler(
      priority = EventPriority.HIGHEST,
      ignoreCancelled = true
   )
   private void a(PlayerFishEvent var1) {
      if (Compatibility.CompatibilityType.GRAPPLING_HOOK.isFunctional() && var1.getState() == State.CAUGHT_ENTITY) {
         Entity var2 = var1.getCaught();
         if (var2 instanceof Player) {
            ai.idealistic.vacan.abstraction.f.c var3 = ai.idealistic.vacan.functionality.server.c.i((Player)var2);
            ai.idealistic.vacan.abstraction.f.c var4 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
            if (!var3.equals(var4) && e(var4.getItemInHand())) {
               if (ai.idealistic.vacan.utils.minecraft.c.b.h("grapplinghook")) {
                  ai.idealistic.vacan.functionality.server.a.jc.a(var3, Compatibility.CompatibilityType.GRAPPLING_HOOK, (CheckEnums.HackCategoryType[])(new CheckEnums.HackCategoryType[]{CheckEnums.HackCategoryType.MOVEMENT, CheckEnums.HackCategoryType.COMBAT}), 40);
               } else {
                  ai.idealistic.vacan.functionality.server.a.jc.a(var3, Compatibility.CompatibilityType.GRAPPLING_HOOK, (CheckEnums.HackCategoryType[])(new CheckEnums.HackCategoryType[]{CheckEnums.HackCategoryType.MOVEMENT, CheckEnums.HackCategoryType.COMBAT}), 10);
               }
            }
         }
      }

   }
}
