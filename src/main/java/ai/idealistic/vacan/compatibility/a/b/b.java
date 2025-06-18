package ai.idealistic.vacan.compatibility.a.b;

import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import io.lumine.mythic.bukkit.BukkitAPIHelper;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class b {
   private static final HashSet<ItemStack> hx = new HashSet();

   public static void eq() {
      hx.clear();
      File[] var0 = (new File("/plugins/MythicMobs/Items/")).listFiles();
      if (var0 != null) {
         File[] var1 = var0;
         int var2 = var0.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            File var4 = var1[var3];
            if (var4.isFile() && var4.getName().endsWith(".yml")) {
               YamlConfiguration var5 = YamlConfiguration.loadConfiguration(var4);
               Iterator var6 = var5.getKeys(false).iterator();

               while(var6.hasNext()) {
                  String var7 = (String)var6.next();
                  if (var5.contains(var7 + ".Id") && var5.contains(var7 + ".Display")) {
                     String var8 = var5.getString(var7 + ".Id");
                     Material var9 = Material.getMaterial(var8.toUpperCase());
                     if (var9 != null) {
                        ItemStack var10 = new ItemStack(var9);
                        ItemMeta var11 = var10.getItemMeta();
                        var11.setDisplayName(ai.idealistic.vacan.utils.a.g.ag(ai.idealistic.vacan.utils.a.g.ah(var5.getString(var7 + ".Display"))));
                        var10.setItemMeta(var11);
                        hx.add(var10);
                     }
                  }
               }
            }
         }
      }

   }

   public static boolean c(Entity var0) {
      return Compatibility.CompatibilityType.MYTHIC_MOBS.isFunctional() && (new BukkitAPIHelper()).isMythicMob(var0);
   }

   public static boolean j(ai.idealistic.vacan.abstraction.f.c var0) {
      if (!Compatibility.CompatibilityType.MYTHIC_MOBS.isFunctional()) {
         return false;
      } else {
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
      }
   }

   private static boolean f(ItemStack var0) {
      Iterator var1 = hx.iterator();

      ItemStack var2;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         var2 = (ItemStack)var1.next();
      } while(var2.getType() != var0.getType() || var0.getItemMeta() == null || !ai.idealistic.vacan.utils.a.g.ag(var0.getItemMeta().getDisplayName()).equals(var2.getItemMeta().getDisplayName()));

      return true;
   }
}
