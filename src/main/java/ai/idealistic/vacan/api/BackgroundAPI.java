package ai.idealistic.vacan.api;

import ai.idealistic.vacan.Register;
import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.check.e;
import ai.idealistic.vacan.abstraction.f.c;
import ai.idealistic.vacan.functionality.c.d;
import ai.idealistic.vacan.functionality.connection.IDs;
import ai.idealistic.vacan.functionality.server.a;
import ai.idealistic.vacan.functionality.server.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BackgroundAPI {
   public static String licenseID() {
      return IDs.user();
   }

   public static String getVersion() {
      return Register.plugin != null ? Register.plugin.getDescription().getVersion() : "Unknown";
   }

   public static String getMessage(String var0) {
      return a.jb.m(var0);
   }

   public static boolean getSetting(String var0) {
      return a.iZ.i(var0);
   }

   /** @deprecated */
   @Deprecated
   public static String getCategory(Player var0, CheckEnums.HackType var1) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getCategory' has been removed.");
      return null;
   }

   public static boolean hasVerboseEnabled(Player var0) {
      c var1 = ai.idealistic.vacan.functionality.server.c.i(var0);
      return ai.idealistic.vacan.functionality.c.c.r(var1);
   }

   public static boolean hasNotificationsEnabled(Player var0) {
      c var1 = ai.idealistic.vacan.functionality.server.c.i(var0);
      return ai.idealistic.vacan.functionality.c.c.q(var1);
   }

   /** @deprecated */
   @Deprecated
   public static int getViolationResetTime() {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getViolationResetTime' has been removed.");
      return 0;
   }

   public static void setVerbose(Player var0, boolean var1) {
      c var2 = ai.idealistic.vacan.functionality.server.c.i(var0);
      if (var1) {
         ai.idealistic.vacan.functionality.c.c.w(var2);
      } else {
         ai.idealistic.vacan.functionality.c.c.v(var2);
      }

   }

   public static void setNotifications(Player var0, boolean var1) {
      c var2 = ai.idealistic.vacan.functionality.server.c.i(var0);
      if (var1) {
         ai.idealistic.vacan.functionality.c.c.c(var2, Integer.MIN_VALUE);
      } else {
         ai.idealistic.vacan.functionality.c.c.u(var2);
      }

   }

   /** @deprecated */
   @Deprecated
   public static void setVerbose(Player var0, boolean var1, int var2) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'setVerbose' has been removed.");
   }

   public static void setNotifications(Player var0, int var1) {
      if (a.iZ.i("Important.enable_developer_api")) {
         c var2 = ai.idealistic.vacan.functionality.server.c.i(var0);
         ai.idealistic.vacan.functionality.c.c.c(var2, Math.abs(var1));
      }

   }

   public static int getPing(Player var0) {
      return ai.idealistic.vacan.functionality.server.c.i(var0).bS();
   }

   /** @deprecated */
   @Deprecated
   public static double getTPS() {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getTPS' has been removed.");
      return 0.0D;
   }

   public static boolean hasPermission(Player var0, Permission var1) {
      return b.a(var0, var1);
   }

   public static boolean isEnabled(CheckEnums.HackType var0) {
      return var0.getCheck().a((Check.DataType)null, (String)null);
   }

   public static boolean isSilent(CheckEnums.HackType var0) {
      return var0.getCheck().b((Check.DataType)null, (String)null);
   }

   public static int getVL(Player var0, CheckEnums.HackType var1) {
      return ai.idealistic.vacan.utils.b.a.A(getDecimalVL(var0, var1));
   }

   public static double getCertainty(Player var0, CheckEnums.HackType var1) {
      c var2 = ai.idealistic.vacan.functionality.server.c.i(var0);
      Collection var3 = var2.a(var1).getDetections();
      double var4 = 0.0D;
      double var6 = 0.0D;

      ai.idealistic.vacan.abstraction.check.b var9;
      for(Iterator var8 = var3.iterator(); var8.hasNext(); var6 += (double)var9.g(var2.dr())) {
         var9 = (ai.idealistic.vacan.abstraction.check.b)var8.next();
         var4 += (double)var9.d(var2.dr());
      }

      return (double)ai.idealistic.vacan.utils.b.a.A(var4 / (double)var3.size() / (var6 / (double)var3.size()));
   }

   public static double getDecimalVL(Player var0, CheckEnums.HackType var1) {
      c var2 = ai.idealistic.vacan.functionality.server.c.i(var0);
      Collection var3 = var2.a(var1).getDetections();
      double var4 = 0.0D;

      ai.idealistic.vacan.abstraction.check.b var7;
      for(Iterator var6 = var3.iterator(); var6.hasNext(); var4 += (double)var7.d(var2.dr())) {
         var7 = (ai.idealistic.vacan.abstraction.check.b)var6.next();
      }

      return var4 / (double)var3.size();
   }

   public static int getVL(Player var0) {
      return ai.idealistic.vacan.utils.b.a.A(getDecimalVL(var0));
   }

   public static double getDecimalVL(Player var0) {
      c var1 = ai.idealistic.vacan.functionality.server.c.i(var0);
      double var2 = 0.0D;
      double var4 = 0.0D;
      e[] var6 = var1.ds();
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         e var9 = var6[var8];
         Collection var10 = var9.getDetections();

         ai.idealistic.vacan.abstraction.check.b var12;
         for(Iterator var11 = var10.iterator(); var11.hasNext(); var2 += (double)var12.d(var1.dr())) {
            var12 = (ai.idealistic.vacan.abstraction.check.b)var11.next();
         }

         var4 += (double)var10.size();
      }

      return var2 / var4;
   }

   /** @deprecated */
   @Deprecated
   public static void setVL(Player var0, CheckEnums.HackType var1, int var2) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'setVL' has been removed.");
   }

   /** @deprecated */
   @Deprecated
   public static int getCancelViolation(CheckEnums.HackType var0, String var1) {
      return getCancelViolation(var0);
   }

   /** @deprecated */
   @Deprecated
   public static int getCancelViolation(CheckEnums.HackType var0) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getCancelViolation' has been removed.");
      return 0;
   }

   /** @deprecated */
   @Deprecated
   public static int getViolationDivisor(Player var0, CheckEnums.HackType var1) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getViolationDivisor' has been removed.");
      return 0;
   }

   public static void reloadConfig() {
      if (a.iZ.i("Important.enable_developer_api")) {
         a.a((CommandSender)null);
      }

   }

   /** @deprecated */
   @Deprecated
   public static void reloadPermissions() {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'reloadPermissions' has been removed.");
   }

   /** @deprecated */
   @Deprecated
   public static void reloadPermissions(Player var0) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'reloadPermissions' has been removed.");
   }

   public static void enableCheck(CheckEnums.HackType var0) {
      if (a.iZ.i("Important.enable_developer_api")) {
         var0.getCheck().a((Check.DataType)null, true);
      }

   }

   public static void disableCheck(CheckEnums.HackType var0) {
      if (a.iZ.i("Important.enable_developer_api")) {
         var0.getCheck().a((Check.DataType)null, false);
      }

   }

   public static void cancelCheck(Player var0, CheckEnums.HackType var1, int var2) {
      if (a.iZ.i("Important.enable_developer_api")) {
         c var3 = ai.idealistic.vacan.functionality.server.c.i(var0);
         var3.a(var1).a("Developer-API", (String)null, var2);
      }

   }

   public static void cancelCheckPerVerbose(Player var0, String var1, int var2) {
      if (a.iZ.i("Important.enable_developer_api")) {
         c var3 = ai.idealistic.vacan.functionality.server.c.i(var0);
         CheckEnums.HackType[] var4 = CheckEnums.HackType.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            CheckEnums.HackType var7 = var4[var6];
            var3.a(var7).a("Developer-API", var1, var2);
         }
      }

   }

   public static void enableSilentChecking(CheckEnums.HackType var0) {
      if (a.iZ.i("Important.enable_developer_api")) {
         var0.getCheck().b((Check.DataType)null, true);
      }

   }

   public static void disableSilentChecking(CheckEnums.HackType var0) {
      if (a.iZ.i("Important.enable_developer_api")) {
         var0.getCheck().b((Check.DataType)null, false);
      }

   }

   public static void enableSilentChecking(Player var0, CheckEnums.HackType var1) {
      if (a.iZ.i("Important.enable_developer_api")) {
         c var2 = ai.idealistic.vacan.functionality.server.c.i(var0);
         var2.a(var1).b("Developer-API", (String)null, 0);
      }

   }

   public static void disableSilentChecking(Player var0, CheckEnums.HackType var1) {
      if (a.iZ.i("Important.enable_developer_api")) {
         c var2 = ai.idealistic.vacan.functionality.server.c.i(var0);
         var2.a(var1).s();
      }

   }

   public static void startCheck(Player var0, CheckEnums.HackType var1) {
      if (a.iZ.i("Important.enable_developer_api")) {
         c var2 = ai.idealistic.vacan.functionality.server.c.i(var0);
         var2.a(var1).r();
      }

   }

   public static void stopCheck(Player var0, CheckEnums.HackType var1) {
      if (a.iZ.i("Important.enable_developer_api")) {
         c var2 = ai.idealistic.vacan.functionality.server.c.i(var0);
         var2.a(var1).a("Developer-API", (String)null, 0);
      }

   }

   public static void resetVL() {
      Collection var0 = ai.idealistic.vacan.functionality.server.c.fc();
      if (!var0.isEmpty()) {
         Iterator var1 = var0.iterator();

         while(var1.hasNext()) {
            c var2 = (c)var1.next();
            e[] var3 = var2.ds();
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               e var6 = var3[var5];
               Iterator var7 = var6.getDetections().iterator();

               while(var7.hasNext()) {
                  ai.idealistic.vacan.abstraction.check.b var8 = (ai.idealistic.vacan.abstraction.check.b)var7.next();
                  var8.b(var2.dr());
               }
            }
         }
      }

   }

   public static void resetVL(Player var0) {
      c var1 = ai.idealistic.vacan.functionality.server.c.i(var0);
      e[] var2 = var1.ds();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         e var5 = var2[var4];
         Iterator var6 = var5.getDetections().iterator();

         while(var6.hasNext()) {
            ai.idealistic.vacan.abstraction.check.b var7 = (ai.idealistic.vacan.abstraction.check.b)var6.next();
            var7.b(var1.dr());
         }
      }

   }

   public static boolean isBypassing(Player var0) {
      return b.isBypassing(var0, (CheckEnums.HackType)null);
   }

   public static boolean isBypassing(Player var0, CheckEnums.HackType var1) {
      return b.isBypassing(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static void banPlayer(UUID var0, String var1) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'banPlayer' has been removed.");
   }

   /** @deprecated */
   @Deprecated
   public static boolean isBanned(UUID var0) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'isBanned' has been removed.");
      return false;
   }

   /** @deprecated */
   @Deprecated
   public static void unbanPlayer(UUID var0) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'unbanPlayer' has been removed.");
   }

   /** @deprecated */
   @Deprecated
   public static String getBanReason(UUID var0) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getBanReason' has been removed.");
      return null;
   }

   /** @deprecated */
   @Deprecated
   public static String getBanPunisher(UUID var0) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getBanPunisher' has been removed.");
      return null;
   }

   /** @deprecated */
   @Deprecated
   public static boolean isHacker(Player var0) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'isHacker' has been removed.");
      return false;
   }

   /** @deprecated */
   @Deprecated
   public static boolean isLegitimate(Player var0) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'isLegitimate' has been removed.");
      return false;
   }

   /** @deprecated */
   @Deprecated
   public static boolean hasMiningNotificationsEnabled(Player var0) {
      return hasNotificationsEnabled(var0);
   }

   /** @deprecated */
   @Deprecated
   public static void setMiningNotifications(Player var0, boolean var1) {
      setNotifications(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static int getCPS(Player var0) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getCPS' has been removed.");
      return 0;
   }

   /** @deprecated */
   @Deprecated
   public static UUID[] getBanList() {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getBanList' has been removed.");
      return new UUID[0];
   }

   public static boolean addToWave(UUID var0, String var1) {
      if (a.iZ.i("Important.enable_developer_api")) {
         d.b(var0, var1);
         return true;
      } else {
         return false;
      }
   }

   public static void removeFromWave(UUID var0) {
      if (a.iZ.i("Important.enable_developer_api")) {
         d.b(var0);
      }

   }

   public static void clearWave() {
      if (a.iZ.i("Important.enable_developer_api")) {
         d.clear();
      }

   }

   public static void runWave() {
      if (a.iZ.i("Important.enable_developer_api")) {
         d.eT();
      }

   }

   public static UUID[] getWaveList() {
      return d.getWaveList();
   }

   public static int getWaveSize() {
      return d.getWaveList().length;
   }

   public static boolean isAddedToTheWave(UUID var0) {
      return d.a(var0) != null;
   }

   public static void warnPlayer(Player var0, String var1) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'warnPlayer' has been removed.");
   }

   /** @deprecated */
   @Deprecated
   public static void addPermission(Player var0, Permission var1) {
      if (a.iZ.i("Important.enable_developer_api")) {
         ai.idealistic.vacan.functionality.c.a.M("The API method 'addPermission' has been removed.");
      }

   }

   /** @deprecated */
   @Deprecated
   public static void sendClientSidedBlock(Player var0, Location var1, Material var2, byte var3) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'sendClientSidedBlock' has been removed.");
   }

   /** @deprecated */
   @Deprecated
   public static void destroyClientSidedBlock(Player var0, Location var1) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'destroyClientSidedBlock' has been removed.");
   }

   /** @deprecated */
   @Deprecated
   public static void removeClientSidedBlocks(Player var0) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'removeClientSidedBlocks' has been removed.");
   }

   /** @deprecated */
   @Deprecated
   public static boolean containsClientSidedBlock(Player var0, Location var1) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'containsClientSidedBlock' has been removed.");
      return false;
   }

   /** @deprecated */
   @Deprecated
   public static Material getClientSidedBlockMaterial(Player var0, Location var1) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getClientSidedBlockMaterial' has been removed.");
      return null;
   }

   /** @deprecated */
   @Deprecated
   public static byte getClientSidedBlockData(Player var0, Location var1) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getClientSidedBlockData' has been removed.");
      return 0;
   }

   public static String getConfiguredCheckName(CheckEnums.HackType var0) {
      return var0.getCheck().getName();
   }

   public static void setConfiguredCheckName(CheckEnums.HackType var0, String var1) {
      if (a.iZ.i("Important.enable_developer_api")) {
         var0.getCheck().a(var1);
      }

   }

   /** @deprecated */
   @Deprecated
   public static void disableVelocityProtection(Player var0, int var1) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'disableVelocityProtection' has been removed.");
   }

   /** @deprecated */
   @Deprecated
   public static void setOnGround(Player var0, int var1) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'setOnGround' has been removed.");
   }

   /** @deprecated */
   @Deprecated
   public static int getMaxPunishmentViolation(CheckEnums.HackType var0) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getMaxPunishmentViolation' has been removed.");
      return 0;
   }

   /** @deprecated */
   @Deprecated
   public static int getMinPunishmentViolation(CheckEnums.HackType var0) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'getMinPunishmentViolation' has been removed.");
      return 0;
   }

   /** @deprecated */
   @Deprecated
   public static boolean mayPunishPlayer(Player var0, CheckEnums.HackType var1) {
      ai.idealistic.vacan.functionality.c.a.M("The API method 'mayPunishPlayer' has been removed.");
      return false;
   }
}
