package ai.idealistic.vacan.utils.minecraft.c;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.api.VacanAPI;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class a {
   public static String b(String var0, String var1, String var2) {
      return var0.replace(var1, var2);
   }

   public static String a(String var0, CheckEnums.HackType var1) {
      var0 = b(var0, "{space}", " ");
      var0 = b(var0, "{online}", String.valueOf(ai.idealistic.vacan.functionality.server.c.fa()));
      var0 = b(var0, "{motd}", Bukkit.getMotd());
      var0 = b(var0, "{server:name}", ai.idealistic.vacan.functionality.c.b.eP());
      var0 = b(var0, "{plugin:version}", VacanAPI.getVersion());
      var0 = b(var0, "{server:version}", MultiVersion.jf.toString());
      var0 = b(var0, "{line}", "\n");
      LocalDateTime var2 = LocalDateTime.now();
      var0 = b(var0, "{date:time}", DateTimeFormatter.ofPattern("HH:mm:ss").format(var2));
      var0 = b(var0, "{date:d-m-y}", DateTimeFormatter.ofPattern("dd/MM/yyyy").format(var2));
      var0 = b(var0, "{date:m-d-y}", DateTimeFormatter.ofPattern("MM/dd/yyyy").format(var2));
      var0 = b(var0, "{date:y-m-d}", DateTimeFormatter.ofPattern("yyyy/MM/dd").format(var2));
      if (var1 != null) {
         Check var3 = var1.getCheck();
         var0 = b(var0, "{detection}", var3.getName());
         var0 = b(var0, "{detection:real}", var1.toString());
      }

      return var0;
   }

   public static String a(ai.idealistic.vacan.abstraction.f.c var0, String var1, CheckEnums.HackType var2) {
      Location var3 = var0.bO();
      String var4 = var0.bV().getName();
      var1 = b(var1, "{player}", var0.bC().getName());
      var1 = b(var1, "{player:type}", var0.dr().toString().toLowerCase());
      var1 = b(var1, "{uuid}", var0.bT().toString());
      var1 = b(var1, "{ping}", String.valueOf(var0.bS()));
      var1 = b(var1, "{world}", var4);
      var1 = b(var1, "{health}", String.valueOf(var0.ch()));
      var1 = b(var1, "{gamemode}", var0.cl().toString().toLowerCase());
      var1 = b(var1, "{x}", String.valueOf(var3.getBlockX()));
      var1 = b(var1, "{y}", String.valueOf(var3.getBlockY()));
      var1 = b(var1, "{z}", String.valueOf(var3.getBlockZ()));
      var1 = b(var1, "{yaw}", String.valueOf(ai.idealistic.vacan.utils.b.a.A((double)var3.getYaw())));
      var1 = b(var1, "{pitch}", String.valueOf(ai.idealistic.vacan.utils.b.a.A((double)var3.getPitch())));
      if (var2 != null) {
         var1 = b(var1, "{detection:silent}", String.valueOf(var2.getCheck().b(var0.dr(), var4)));
         var1 = b(var1, "{detection:punish}", String.valueOf(var2.getCheck().a(var0.dr())));
      }

      return ChatColor.translateAlternateColorCodes('&', a(var1, var2));
   }

   public static String a(OfflinePlayer var0, String var1, CheckEnums.HackType var2) {
      boolean var3 = var2 != null;
      if (var0.isOnline()) {
         ai.idealistic.vacan.abstraction.f.c var6 = ai.idealistic.vacan.functionality.server.c.i((Player)var0);
         return a(var6, var1, var2);
      } else {
         UUID var4 = var0.getUniqueId();
         String var5 = var0.getName();
         if (var5 != null) {
            var1 = b(var1, "{player}", var5);
         }

         var1 = b(var1, "{uuid}", var4.toString());
         if (var3) {
            var1 = b(var1, "{detection:silent}", String.valueOf(var2.getCheck().b((Check.DataType)null, (String)null)));
            var1 = b(var1, "{detection:punish}", String.valueOf(var2.getCheck().a((Check.DataType)null)));
         }

         return ChatColor.translateAlternateColorCodes('&', a(var1, var2));
      }
   }

   public static void a(File var0, String var1, Object var2) {
      YamlConfiguration var3 = YamlConfiguration.loadConfiguration(var0);
      if (!var0.exists()) {
         try {
            var0.createNewFile();
         } catch (Exception var5) {
         }
      }

      if (!var3.contains(var1)) {
         b(var0, var1, var2);
      }

   }

   public static boolean a(File var0, String var1) {
      return YamlConfiguration.loadConfiguration(var0).contains(var1);
   }

   public static void b(File var0, String var1, Object var2) {
      if (!var0.exists()) {
         try {
            var0.createNewFile();
         } catch (Exception var6) {
         }
      }

      YamlConfiguration var3 = YamlConfiguration.loadConfiguration(var0);
      var3.set(var1, var2);

      try {
         var3.save(var0);
      } catch (Exception var5) {
      }

   }

   public static void c(String var0, Object var1) {
      if (!Register.plugin.getConfig().contains(var0)) {
         d(var0, var1);
      }

   }

   public static void d(String var0, Object var1) {
      Register.plugin.getConfig().set(var0, var1);
      Register.plugin.saveConfig();
      Register.plugin.reloadConfig();
   }
}
