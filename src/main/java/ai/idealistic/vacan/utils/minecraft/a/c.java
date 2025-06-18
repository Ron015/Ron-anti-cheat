package ai.idealistic.vacan.utils.minecraft.a;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.utils.a.e;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class c {
   private static final boolean lL;

   public static void a(Inventory var0, String var1, List<String> var2, ItemStack var3, int var4) {
      ItemMeta var5 = var3.getItemMeta();
      var5.setDisplayName(var1);
      if (var2 != null) {
         var5.setLore(var2);
      }

      var3.setItemMeta(var5);
      if (var4 != -1) {
         var0.setItem(var4, var3);
      } else {
         var0.addItem(new ItemStack[]{var3});
      }

   }

   public static ItemStack a(String var0, ArrayList<String> var1, ItemStack var2) {
      ItemMeta var3 = var2.getItemMeta();
      var3.setDisplayName(var0);
      if (var1 != null) {
         var3.setLore(var1);
      }

      var2.setItemMeta(var3);
      return var2;
   }

   public static ItemStack fF() {
      return new ItemStack(MultiVersion.c(MultiVersion.MCVersion.V1_13) ? Material.PLAYER_HEAD : Material.getMaterial("SKULL_ITEM"), 1, (short)SkullType.PLAYER.ordinal());
   }

   public static ItemStack b(OfflinePlayer var0, String var1, boolean var2) {
      if (lL) {
         return a.a(var0, var1, var2);
      } else {
         ItemStack var3 = fF();
         SkullMeta var4 = (SkullMeta)var3.getItemMeta();
         String var5 = null;
         if (var0 != null) {
            var5 = var0.getName();
         }

         if (var5 != null) {
            var4.setOwner(var5);
         } else if (var1 != null) {
            var4.setOwner(var1);
         }

         var3.setItemMeta(var4);
         return var3;
      }
   }

   static {
      lL = MultiVersion.c(MultiVersion.MCVersion.V1_13) && e.aa("org.bukkit.profile.PlayerProfile");
   }
}
