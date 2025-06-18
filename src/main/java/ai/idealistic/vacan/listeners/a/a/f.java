package ai.idealistic.vacan.listeners.a.a;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class f implements Listener {
   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(PlayerDropItemEvent var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.a(var1.getPlayer(), true);
      var2.b(var1.isCancelled(), var1);
   }

   @EventHandler(
      priority = EventPriority.HIGHEST
   )
   private void a(InventoryClickEvent var1) {
      ItemStack var2 = var1.getCurrentItem();
      if (ai.idealistic.vacan.utils.minecraft.world.c.h(var2)) {
         Player var3 = (Player)var1.getWhoClicked();
         ai.idealistic.vacan.abstraction.f.c var4 = ai.idealistic.vacan.functionality.server.c.a(var3, true);
         var4.b(false, var1);
         if (var2.hasItemMeta() && var2.getItemMeta().hasDisplayName()) {
            ClickType var5 = var1.getClick();
            String var6 = MultiVersion.c(MultiVersion.MCVersion.V1_13) ? ai.idealistic.vacan.utils.a.g.ag(var3.getOpenInventory().getTitle()) : var3.getOpenInventory().getTitle();
            int var7 = var1.getSlot();
            ai.idealistic.vacan.abstraction.e.a[] var8 = ai.idealistic.vacan.functionality.server.c.jn;
            int var9 = var8.length;

            for(int var10 = 0; var10 < var9; ++var10) {
               ai.idealistic.vacan.abstraction.e.a var11 = var8[var10];
               if (var11.a(var4, var6, var2, var5, var7)) {
                  var1.setCancelled(true);
                  break;
               }
            }
         }
      }

   }
}
