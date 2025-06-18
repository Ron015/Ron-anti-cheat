package ai.idealistic.vacan.utils.minecraft.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class b {
   public static List<Plugin> ax(String var0) {
      Plugin[] var1 = Bukkit.getPluginManager().getPlugins();
      ArrayList var2 = new ArrayList(var1.length);
      Plugin[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Plugin var6 = var3[var5];
         if (!var6.getName().equals(var0)) {
            PluginDescriptionFile var7 = var6.getDescription();
            ArrayList var8 = new ArrayList(var7.getDepend());
            var8.addAll(var7.getSoftDepend());
            if (!var8.isEmpty()) {
               Iterator var9 = var8.iterator();

               while(var9.hasNext()) {
                  String var10 = (String)var9.next();
                  if (var0.equals(var10)) {
                     var2.add(var6);
                     break;
                  }
               }
            }
         }
      }

      return var2;
   }

   public static boolean ay(String var0) {
      String[] var1 = var0.toLowerCase().split(" ");
      Plugin[] var2 = Bukkit.getPluginManager().getPlugins();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Plugin var5 = var2[var4];
         if (var5.isEnabled()) {
            String var6 = var5.getName().toLowerCase();
            String[] var7 = var1;
            int var8 = var1.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               String var10 = var7[var9];
               if (var6.contains(var10)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean h(String var0) {
      Plugin[] var1 = Bukkit.getPluginManager().getPlugins();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Plugin var4 = var1[var3];
         if (var4.isEnabled() && var4.getName().equalsIgnoreCase(var0)) {
            return true;
         }
      }

      return false;
   }

   public static Plugin az(String var0) {
      Plugin[] var1 = Bukkit.getPluginManager().getPlugins();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         Plugin var4 = var1[var3];
         if (var4.isEnabled() && var4.getName().equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return null;
   }
}
