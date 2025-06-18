package ai.idealistic.vacan.compatibility.a.a;

import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import dev.lone.itemsadder.api.CustomBlock;
import dev.lone.itemsadder.api.CustomMob;
import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class d {
   private static final boolean hu = ai.idealistic.vacan.utils.a.e.aa("me.libraryaddict.disguise.DisguiseAPI");

   public static boolean j(ai.idealistic.vacan.abstraction.f.c var0) {
      if (hu && Compatibility.CompatibilityType.ITEMS_ADDER.isFunctional()) {
         PlayerInventory var1 = var0.cd();
         ItemStack[] var2 = var1.getArmorContents();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            ItemStack var5 = var2[var4];
            if (var5 != null && f(var5)) {
               return true;
            }
         }

         return f(var1.getItemInHand()) || MultiVersion.c(MultiVersion.MCVersion.V1_9) && f(var1.getItemInOffHand());
      } else {
         return false;
      }
   }

   public static boolean e(Block var0) {
      return hu && Compatibility.CompatibilityType.ITEMS_ADDER.isFunctional() && CustomBlock.byAlreadyPlaced(var0) != null;
   }

   private static boolean f(ItemStack var0) {
      return hu && Compatibility.CompatibilityType.ITEMS_ADDER.isFunctional() && CustomStack.getInstance(var0.getType().toString()) != null;
   }

   public static boolean c(Entity var0) {
      return hu && Compatibility.CompatibilityType.ITEMS_ADDER.isFunctional() && CustomMob.byAlreadySpawned(var0) != null;
   }
}
