package ai.idealistic.vacan.functionality.c;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class d {
   private static File d;
   private static final String iX = "Wave";
   private static final Map<UUID, String> ie;

   public static void dY() {
      synchronized(ie) {
         ie.clear();
      }
   }

   public static void ay() {
      d = new File(Register.plugin.getDataFolder() + "/storage.yml");
      if (!d.exists()) {
         ai.idealistic.vacan.utils.minecraft.c.a.a((File)d, "Wave." + UUID.randomUUID() + ".command", (Object)"ban {player} wave punishment example");
      }

   }

   public static UUID[] getWaveList() {
      ConfigurationSection var0 = YamlConfiguration.loadConfiguration(d).getConfigurationSection("Wave");
      if (var0 == null) {
         return new UUID[0];
      } else {
         LinkedList var1 = new LinkedList();
         Iterator var2 = var0.getKeys(false).iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();

            try {
               var1.add(UUID.fromString(var3));
            } catch (Exception var5) {
            }
         }

         return (UUID[])var1.toArray(new UUID[0]);
      }
   }

   public static String eS() {
      StringBuilder var0 = new StringBuilder();
      UUID[] var1 = getWaveList();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         UUID var4 = var1[var3];
         OfflinePlayer var5 = Bukkit.getOfflinePlayer(var4);
         if (var5.hasPlayedBefore()) {
            var0.append(ChatColor.RED).append(var5.getName()).append(ChatColor.GRAY).append(", ");
         }
      }

      if (var0.length() >= 2) {
         var0 = new StringBuilder(var0.substring(0, var0.length() - 2));
      } else if (var0.length() == 0) {
         var0 = new StringBuilder(ai.idealistic.vacan.functionality.server.a.jb.m("empty_wave_list"));
      }

      return var0.toString();
   }

   public static String a(UUID var0) {
      return YamlConfiguration.loadConfiguration(d).getString("Wave." + var0 + ".command");
   }

   public static void b(UUID var0, String var1) {
      ai.idealistic.vacan.utils.minecraft.c.a.b((File)d, "Wave." + var0 + ".command", (Object)var1);
      if (getWaveList().length >= Math.max(Math.min(Bukkit.getMaxPlayers(), 500), 20)) {
         eT();
      }

   }

   public static void b(UUID var0) {
      String var1 = "Wave." + var0;
      ai.idealistic.vacan.utils.minecraft.c.a.b((File)d, var1 + ".command", (Object)null);
      ai.idealistic.vacan.utils.minecraft.c.a.b((File)d, var1, (Object)null);
   }

   public static void clear() {
      UUID[] var0 = getWaveList();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         UUID var3 = var0[var2];
         b(var3);
      }

   }

   public static boolean eT() {
      UUID[] var0 = getWaveList();
      if (var0.length > 0) {
         synchronized(ie) {
            Collection var2 = ai.idealistic.vacan.functionality.server.c.fc();
            if (!var2.isEmpty()) {
               String var3 = ai.idealistic.vacan.functionality.server.a.jb.m("wave_start_message");
               Iterator var4 = var2.iterator();

               while(var4.hasNext()) {
                  ai.idealistic.vacan.abstraction.f.c var5 = (ai.idealistic.vacan.abstraction.f.c)var4.next();
                  if (c.s(var5)) {
                     var5.bC().sendMessage(var3);
                  }
               }
            }

            ai.idealistic.vacan.functionality.server.c.jk.d(() -> {
               UUID[] var1 = var0;
               int var2 = var0.length;

               for(int var3 = 0; var3 < var2; ++var3) {
                  UUID var4 = var1[var3];

                  try {
                     String var5 = a(var4);
                     if (var5 != null) {
                        ie.putIfAbsent(var4, ai.idealistic.vacan.utils.minecraft.c.a.a((OfflinePlayer)Bukkit.getOfflinePlayer(var4), var5, (CheckEnums.HackType)null));
                     }
                  } catch (Exception var6) {
                  }
               }

            });
            return true;
         }
      } else {
         return false;
      }
   }

   private static void k(int var0) {
      Collection var1 = ai.idealistic.vacan.functionality.server.c.fc();
      if (!var1.isEmpty()) {
         String var2 = ai.idealistic.vacan.functionality.server.a.jb.m("wave_end_message").replace("{total}", String.valueOf(var0));
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            ai.idealistic.vacan.abstraction.f.c var4 = (ai.idealistic.vacan.abstraction.f.c)var3.next();
            if (c.s(var4)) {
               var4.bC().sendMessage(var2);
            }
         }
      }

   }

   static {
      d = new File(Register.plugin.getDataFolder() + "/storage.yml");
      ie = Collections.synchronizedMap(new LinkedHashMap());
      ai.idealistic.vacan.functionality.server.c.a(() -> {
         synchronized(ie) {
            int var1 = ie.size();
            if (var1 > 0) {
               Iterator var2 = ie.entrySet().iterator();

               while(var2.hasNext()) {
                  Entry var3 = (Entry)var2.next();
                  var2.remove();
                  b((UUID)var3.getKey());
                  ai.idealistic.vacan.functionality.server.c.R((String)var3.getValue());
               }

               k(var1);
            }

         }
      }, 1L, 1L);
   }
}
