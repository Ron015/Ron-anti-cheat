package me.vagdedes.spartan.api;

import java.util.UUID;
import me.vagdedes.spartan.api.system.Enums;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class API {
   public static String licenseID() {
      return BackgroundAPI.licenseID();
   }

   public static String getVersion() {
      return BackgroundAPI.getVersion();
   }

   public static String getMessage(String var0) {
      return BackgroundAPI.getMessage(var0);
   }

   public static boolean getSetting(String var0) {
      return BackgroundAPI.getSetting(var0);
   }

   /** @deprecated */
   @Deprecated
   public static String getCategory(Player var0, Enums.HackType var1) {
      return BackgroundAPI.getCategory(var0, var1);
   }

   public static boolean hasVerboseEnabled(Player var0) {
      return BackgroundAPI.hasVerboseEnabled(var0);
   }

   public static boolean hasNotificationsEnabled(Player var0) {
      return BackgroundAPI.hasNotificationsEnabled(var0);
   }

   /** @deprecated */
   @Deprecated
   public static int getViolationResetTime() {
      return BackgroundAPI.getViolationResetTime();
   }

   public static void setVerbose(Player var0, boolean var1) {
      BackgroundAPI.setVerbose(var0, var1);
   }

   public static void setNotifications(Player var0, boolean var1) {
      BackgroundAPI.setNotifications(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static void setVerbose(Player var0, boolean var1, int var2) {
      BackgroundAPI.setVerbose(var0, var1, var2);
   }

   public static void setNotifications(Player var0, int var1) {
      BackgroundAPI.setNotifications(var0, var1);
   }

   public static int getPing(Player var0) {
      return BackgroundAPI.getPing(var0);
   }

   /** @deprecated */
   @Deprecated
   public static double getTPS() {
      return BackgroundAPI.getTPS();
   }

   public static boolean hasPermission(Player var0, Enums.Permission var1) {
      return BackgroundAPI.hasPermission(var0, var1);
   }

   public static boolean isEnabled(Enums.HackType var0) {
      return BackgroundAPI.isEnabled(var0);
   }

   public static boolean isSilent(Enums.HackType var0) {
      return BackgroundAPI.isSilent(var0);
   }

   public static int getVL(Player var0, Enums.HackType var1) {
      return BackgroundAPI.getVL(var0, var1);
   }

   public static double getCertainty(Player var0, Enums.HackType var1) {
      return BackgroundAPI.getCertainty(var0, var1);
   }

   public static double getDecimalVL(Player var0, Enums.HackType var1) {
      return BackgroundAPI.getDecimalVL(var0, var1);
   }

   public static int getVL(Player var0) {
      return BackgroundAPI.getVL(var0);
   }

   public static double getDecimalVL(Player var0) {
      return BackgroundAPI.getDecimalVL(var0);
   }

   /** @deprecated */
   @Deprecated
   public static void setVL(Player var0, Enums.HackType var1, int var2) {
      BackgroundAPI.setVL(var0, var1, var2);
   }

   /** @deprecated */
   @Deprecated
   public static int getCancelViolation(Enums.HackType var0, String var1) {
      return BackgroundAPI.getCancelViolation(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static int getCancelViolation(Enums.HackType var0) {
      return BackgroundAPI.getCancelViolation(var0);
   }

   /** @deprecated */
   @Deprecated
   public static int getViolationDivisor(Player var0, Enums.HackType var1) {
      return BackgroundAPI.getViolationDivisor(var0, var1);
   }

   public static void reloadConfig() {
      BackgroundAPI.reloadConfig();
   }

   /** @deprecated */
   @Deprecated
   public static void reloadPermissions() {
      BackgroundAPI.reloadPermissions();
   }

   /** @deprecated */
   @Deprecated
   public static void reloadPermissions(Player var0) {
      BackgroundAPI.reloadPermissions(var0);
   }

   public static void enableCheck(Enums.HackType var0) {
      BackgroundAPI.enableCheck(var0);
   }

   public static void disableCheck(Enums.HackType var0) {
      BackgroundAPI.disableCheck(var0);
   }

   public static void enableSilentChecking(Player var0, Enums.HackType var1) {
      BackgroundAPI.enableSilentChecking(var0, var1);
   }

   public static void disableSilentChecking(Player var0, Enums.HackType var1) {
      BackgroundAPI.disableSilentChecking(var0, var1);
   }

   public static void enableSilentChecking(Enums.HackType var0) {
      BackgroundAPI.enableSilentChecking(var0);
   }

   public static void disableSilentChecking(Enums.HackType var0) {
      BackgroundAPI.disableSilentChecking(var0);
   }

   public static void cancelCheck(Player var0, Enums.HackType var1, int var2) {
      BackgroundAPI.cancelCheck(var0, var1, var2);
   }

   public static void cancelCheckPerVerbose(Player var0, String var1, int var2) {
      BackgroundAPI.cancelCheckPerVerbose(var0, var1, var2);
   }

   public static void startCheck(Player var0, Enums.HackType var1) {
      BackgroundAPI.startCheck(var0, var1);
   }

   public static void stopCheck(Player var0, Enums.HackType var1) {
      BackgroundAPI.stopCheck(var0, var1);
   }

   public static void resetVL() {
      BackgroundAPI.resetVL();
   }

   public static void resetVL(Player var0) {
      BackgroundAPI.resetVL(var0);
   }

   public static boolean isBypassing(Player var0) {
      return BackgroundAPI.isBypassing(var0);
   }

   public static boolean isBypassing(Player var0, Enums.HackType var1) {
      return BackgroundAPI.isBypassing(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static void banPlayer(UUID var0, String var1) {
      BackgroundAPI.banPlayer(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static boolean isBanned(UUID var0) {
      return BackgroundAPI.isBanned(var0);
   }

   /** @deprecated */
   @Deprecated
   public static void unbanPlayer(UUID var0) {
      BackgroundAPI.unbanPlayer(var0);
   }

   /** @deprecated */
   @Deprecated
   public static String getBanReason(UUID var0) {
      return BackgroundAPI.getBanReason(var0);
   }

   /** @deprecated */
   @Deprecated
   public static String getBanPunisher(UUID var0) {
      return BackgroundAPI.getBanPunisher(var0);
   }

   /** @deprecated */
   @Deprecated
   public static boolean isHacker(Player var0) {
      return BackgroundAPI.isHacker(var0);
   }

   /** @deprecated */
   @Deprecated
   public static boolean isLegitimate(Player var0) {
      return BackgroundAPI.isLegitimate(var0);
   }

   /** @deprecated */
   @Deprecated
   public static boolean hasMiningNotificationsEnabled(Player var0) {
      return BackgroundAPI.hasMiningNotificationsEnabled(var0);
   }

   /** @deprecated */
   @Deprecated
   public static void setMiningNotifications(Player var0, boolean var1) {
      BackgroundAPI.setMiningNotifications(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static int getCPS(Player var0) {
      return BackgroundAPI.getCPS(var0);
   }

   /** @deprecated */
   @Deprecated
   public static UUID[] getBanList() {
      return BackgroundAPI.getBanList();
   }

   public static boolean addToWave(UUID var0, String var1) {
      return BackgroundAPI.addToWave(var0, var1);
   }

   public static void removeFromWave(UUID var0) {
      BackgroundAPI.removeFromWave(var0);
   }

   public static void clearWave() {
      BackgroundAPI.clearWave();
   }

   public static void runWave() {
      BackgroundAPI.runWave();
   }

   public static UUID[] getWaveList() {
      return BackgroundAPI.getWaveList();
   }

   public static int getWaveSize() {
      return BackgroundAPI.getWaveSize();
   }

   public static boolean isAddedToTheWave(UUID var0) {
      return BackgroundAPI.isAddedToTheWave(var0);
   }

   /** @deprecated */
   @Deprecated
   public static void warnPlayer(Player var0, String var1) {
      BackgroundAPI.warnPlayer(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static void addPermission(Player var0, Enums.Permission var1) {
      BackgroundAPI.addPermission(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static void sendClientSidedBlock(Player var0, Location var1, Material var2, byte var3) {
      BackgroundAPI.sendClientSidedBlock(var0, var1, var2, var3);
   }

   /** @deprecated */
   @Deprecated
   public static void destroyClientSidedBlock(Player var0, Location var1) {
      BackgroundAPI.destroyClientSidedBlock(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static void removeClientSidedBlocks(Player var0) {
      BackgroundAPI.removeClientSidedBlocks(var0);
   }

   /** @deprecated */
   @Deprecated
   public static boolean containsClientSidedBlock(Player var0, Location var1) {
      return BackgroundAPI.containsClientSidedBlock(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static Material getClientSidedBlockMaterial(Player var0, Location var1) {
      return BackgroundAPI.getClientSidedBlockMaterial(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static byte getClientSidedBlockData(Player var0, Location var1) {
      return BackgroundAPI.getClientSidedBlockData(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static void disableVelocityProtection(Player var0, int var1) {
      BackgroundAPI.disableVelocityProtection(var0, var1);
   }

   public static String getConfiguredCheckName(Enums.HackType var0) {
      return BackgroundAPI.getConfiguredCheckName(var0);
   }

   public static void setConfiguredCheckName(Enums.HackType var0, String var1) {
      BackgroundAPI.setConfiguredCheckName(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static void setOnGround(Player var0, int var1) {
      BackgroundAPI.setOnGround(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   public static int getMaxPunishmentViolation(Enums.HackType var0) {
      return BackgroundAPI.getMaxPunishmentViolation(var0);
   }

   /** @deprecated */
   @Deprecated
   public static int getMinPunishmentViolation(Enums.HackType var0) {
      return BackgroundAPI.getMinPunishmentViolation(var0);
   }

   /** @deprecated */
   @Deprecated
   public static boolean mayPunishPlayer(Player var0, Enums.HackType var1) {
      return BackgroundAPI.mayPunishPlayer(var0, var1);
   }
}
