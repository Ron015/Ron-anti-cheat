package ai.idealistic.vacan.functionality.server;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.api.VacanReloadEvent;
import ai.idealistic.vacan.compatibility.Compatibility;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class a {
   public static final ai.idealistic.vacan.abstraction.a.a.c iZ = new ai.idealistic.vacan.abstraction.a.a.c();
   public static final ai.idealistic.vacan.abstraction.a.a.b ja = new ai.idealistic.vacan.abstraction.a.a.b();
   public static final ai.idealistic.vacan.abstraction.a.a.a jb = new ai.idealistic.vacan.abstraction.a.a.a();
   public static final Compatibility jc = new Compatibility();
   public static final ai.idealistic.vacan.abstraction.a.a[] jd;

   public static Check O(String var0) {
      CheckEnums.HackType[] var1 = CheckEnums.HackType.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         CheckEnums.HackType var4 = var1[var3];
         Check var5 = var4.getCheck();
         String var6 = var5.getName();
         if (var6 != null && var6.equals(var0)) {
            return var5;
         }
      }

      return null;
   }

   public static void ay() {
      boolean var0 = Register.isPluginEnabled();
      CheckEnums.HackType[] var1 = CheckEnums.HackType.values();
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         CheckEnums.HackType var4 = var1[var3];
         var4.resetCheck();
      }

      ai.idealistic.vacan.abstraction.a.a[] var5;
      ai.idealistic.vacan.abstraction.a.a var6;
      if (var0) {
         var5 = jd;
         var2 = var5.length;

         for(var3 = 0; var3 < var2; ++var3) {
            var6 = var5[var3];
            var6.ay();
         }

         Compatibility.ay();
         ai.idealistic.vacan.functionality.c.d.ay();
         ai.idealistic.vacan.functionality.c.a.eI();
      } else {
         var5 = jd;
         var2 = var5.length;

         for(var3 = 0; var3 < var2; ++var3) {
            var6 = var5[var3];
            var6.clear();
         }

         jc.dY();
         ai.idealistic.vacan.functionality.c.d.dY();
         ai.idealistic.vacan.functionality.c.a.clear();
      }

      ai.idealistic.vacan.functionality.d.d.refresh(var0);
   }

   public static void a(CommandSender var0) {
      if (iZ.i("Important.enable_developer_api")) {
         VacanReloadEvent var1 = new VacanReloadEvent();
         Bukkit.getPluginManager().callEvent(var1);
         if (var1.isCancelled()) {
            return;
         }
      }

      if (var0 != null) {
         var0.sendMessage(jb.m("config_reload"));
      }

      ay();
   }

   public static void eU() {
      CheckEnums.HackType[] var0 = CheckEnums.HackType.values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         CheckEnums.HackType var3 = var0[var2];
         var3.getCheck().a((Check.DataType)null, true);
      }

   }

   public static void eV() {
      CheckEnums.HackType[] var0 = CheckEnums.HackType.values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         CheckEnums.HackType var3 = var0[var2];
         var3.getCheck().a((Check.DataType)null, false);
      }

   }

   public static void eW() {
      CheckEnums.HackType[] var0 = CheckEnums.HackType.values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         CheckEnums.HackType var3 = var0[var2];
         var3.getCheck().b((Check.DataType)null, true);
      }

   }

   public static void eX() {
      CheckEnums.HackType[] var0 = CheckEnums.HackType.values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         CheckEnums.HackType var3 = var0[var2];
         var3.getCheck().b((Check.DataType)null, false);
      }

   }

   public static boolean k(Check.DataType var0) {
      CheckEnums.HackType[] var1 = CheckEnums.HackType.values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         CheckEnums.HackType var4 = var1[var3];
         if (var4.getCheck().a((Check.DataType)var0, (String)null)) {
            return true;
         }
      }

      return false;
   }

   static {
      jd = new ai.idealistic.vacan.abstraction.a.a[]{iZ, ja, jb};
   }
}
