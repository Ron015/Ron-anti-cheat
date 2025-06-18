package ai.idealistic.vacan.utils.minecraft.a;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.utils.a.e;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

public class a {
   private static final boolean lG = e.aa("com.destroystokyo.paper.profile.PlayerProfile");

   static ItemStack a(OfflinePlayer var0, String var1, boolean var2) {
      ItemStack var3 = new ItemStack(Material.PLAYER_HEAD);
      if (var0 != null) {
         SkullMeta var4 = (SkullMeta)var3.getItemMeta();
         if (var2 && !var0.hasPlayedBefore() && MultiVersion.c(MultiVersion.MCVersion.V1_18)) {
            String var5 = var0.getName();
            if (var5 == null) {
               Object var6;
               if (lG) {
                  if (var1 == null) {
                     var6 = Bukkit.createProfile(var0.getUniqueId());
                  } else {
                     var6 = Bukkit.createProfileExact(var0.getUniqueId(), var1);
                  }
               } else if (var1 == null) {
                  var6 = Bukkit.createPlayerProfile(var0.getUniqueId());
               } else {
                  var6 = Bukkit.createPlayerProfile(var0.getUniqueId(), var1);
               }

               var4.setOwnerProfile((PlayerProfile)var6);
            }
         } else {
            var4.setOwningPlayer(var0);
         }

         var3.setItemMeta(var4);
      }

      return var3;
   }
}
