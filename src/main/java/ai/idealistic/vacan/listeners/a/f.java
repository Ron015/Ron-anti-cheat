package ai.idealistic.vacan.listeners.a;

import me.coley.recaf.metadata.InsnComment;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRiptideEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class f implements Listener {
   @EventHandler
   private void a(PlayerRiptideEvent var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var1.getPlayer());
      a(new ai.idealistic.vacan.abstraction.d.b(var2, var1.getItem(), var1.getPlayer().getVelocity()), false);
   }

   @InsnComment(
      At_0 = "MlRmFDOypHUxgWW2RGMiF1UZRVTzJEbaJjTHVGR4dkYqR3VVlkW2VGa1B1YxlEb2NUYmhHO"
   )
   public static void a(ai.idealistic.vacan.abstraction.d.b var0, boolean var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = var0.ac;
      if (var2.bW() == var1) {
         var2.b(false, var0);
         PlayerInventory var3 = var0.ac.cd();
         ItemStack[] var4 = new ItemStack[]{var3.getItemInHand(), var3.getItemInOffHand()};
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            ItemStack var7 = var4[var6];
            if (var7.getType() == Material.TRIDENT) {
               int var8 = var7.getEnchantmentLevel(Enchantment.RIPTIDE);
               if (var8 > 0) {
                  var2.gV = System.currentTimeMillis();
                  break;
               }
            }
         }
      }

   }
}
