package ai.idealistic.vacan.functionality.d;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import java.io.File;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

public class a {
   private static final String jv = "yyyyMMdd";
   public static final String jw = "yyyy/MM/dd HH:mm:ss:SSSXXX";
   public static final String jx;
   public static final String jy = "Player:";
   private static File jz;
   private static YamlConfiguration jA;
   private static final Object jB;
   private static boolean jC;

   public static String a(String var0, long var1) {
      return DateTimeFormatter.ofPattern(var0).format(Instant.ofEpochMilli(var1).atZone(ZoneId.systemDefault()));
   }

   private static String ff() {
      return "log" + ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + ".yml";
   }

   private static File ax() {
      return new File(jx + "/" + ff());
   }

   private static void fg() {
      try {
         jA.save(jz);
      } catch (Exception var1) {
      }

   }

   private static void fh() {
      if (!jC) {
         synchronized(jB) {
            jC = true;
            fg();
            jC = false;
         }
      }

   }

   public static void a(long var0, String var2, boolean var3, boolean var4, boolean var5) {
      if (var3 && ai.idealistic.vacan.functionality.server.a.iZ.i("Logs.log_console")) {
         Bukkit.getConsoleSender().sendMessage(var2);
      }

      if (ai.idealistic.vacan.functionality.server.a.iZ.i("Logs.log_file") && var4 && jA != null) {
         String var6 = ff();
         if (!var6.equals(jz.getName())) {
            fg();
            jz = ax();
            jA = YamlConfiguration.loadConfiguration(jz);
         }

         ai.idealistic.vacan.functionality.server.c.jk.g(() -> {
            jA.set(a("yyyy/MM/dd HH:mm:ss:SSSXXX", var0), var2);
            fh();
         });
      }

      if (var5) {
         ai.idealistic.vacan.functionality.server.a.ja.a((ai.idealistic.vacan.abstraction.f.c)null, (String)null, var2, (Material)null, (CheckEnums.HackType)null, System.currentTimeMillis());
      }

   }

   public static void a(ai.idealistic.vacan.abstraction.f.c var0, String var1, String var2, boolean var3, Material var4, CheckEnums.HackType var5, long var6) {
      a(var6, var2, var3, true, false);
      ai.idealistic.vacan.functionality.server.a.ja.a(var0, var1, var2, var4, var5, var6);
   }

   static {
      jx = Register.plugin.getDataFolder() + "/logs";
      jz = ax();
      jA = YamlConfiguration.loadConfiguration(jz);
      jB = new Object();
      jC = false;
   }
}
