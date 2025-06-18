package ai.idealistic.vacan.compatibility.a.d;

import ai.idealistic.vacan.abstraction.f.c;
import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import com.willfp.ecoenchants.enchants.EcoEnchant;
import java.util.Iterator;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class b {
   public static boolean m(c var0) {
      if (!Compatibility.CompatibilityType.ECO_ENCHANTS.isFunctional()) {
         return false;
      } else {
         PlayerInventory var1 = var0.cd();
         ItemStack[] var2 = var1.getArmorContents();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            ItemStack var5 = var2[var4];
            if (var5 != null && g(var5)) {
               return true;
            }
         }

         return g(var1.getItemInHand()) || MultiVersion.c(MultiVersion.MCVersion.V1_9) && g(var1.getItemInOffHand());
      }
   }

   private static boolean g(ItemStack var0) {
      if (var0.hasItemMeta()) {
         Iterator var1 = var0.getItemMeta().getEnchants().keySet().iterator();

         while(var1.hasNext()) {
            Enchantment var2 = (Enchantment)var1.next();
            if (var2 instanceof EcoEnchant) {
               return true;
            }
         }
      }

      return false;
   }
}
