package me.vagdedes.spartan.api;

import java.util.UUID;
import me.vagdedes.spartan.api.system.Enums;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BackgroundAPI {
   static String licenseID() {
      return ai.idealistic.vacan.api.BackgroundAPI.licenseID();
   }

   static String getVersion() {
      return ai.idealistic.vacan.api.BackgroundAPI.getVersion();
   }

   static String getMessage(String var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.getMessage(var0);
   }

   static boolean getSetting(String var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.getSetting(var0);
   }

   /** @deprecated */
   @Deprecated
   static String getCategory(Player var0, Enums.HackType var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.getCategory(var0, var1.getHackType());
   }

   static boolean hasVerboseEnabled(Player var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.hasVerboseEnabled(var0);
   }

   static boolean hasNotificationsEnabled(Player var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.hasNotificationsEnabled(var0);
   }

   /** @deprecated */
   @Deprecated
   static int getViolationResetTime() {
      return ai.idealistic.vacan.api.BackgroundAPI.getViolationResetTime();
   }

   static void setVerbose(Player var0, boolean var1) {
      ai.idealistic.vacan.api.BackgroundAPI.setVerbose(var0, var1);
   }

   static void setNotifications(Player var0, boolean var1) {
      ai.idealistic.vacan.api.BackgroundAPI.setNotifications(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   static void setVerbose(Player var0, boolean var1, int var2) {
      ai.idealistic.vacan.api.BackgroundAPI.setVerbose(var0, var1, var2);
   }

   static void setNotifications(Player var0, int var1) {
      ai.idealistic.vacan.api.BackgroundAPI.setNotifications(var0, var1);
   }

   static int getPing(Player var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.getPing(var0);
   }

   /** @deprecated */
   @Deprecated
   static double getTPS() {
      return ai.idealistic.vacan.api.BackgroundAPI.getTPS();
   }

   static boolean hasPermission(Player var0, Enums.Permission var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.hasPermission(var0, var1.getPermission());
   }

   static boolean isEnabled(Enums.HackType var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.isEnabled(var0.getHackType());
   }

   static boolean isSilent(Enums.HackType var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.isSilent(var0.getHackType());
   }

   static int getVL(Player var0, Enums.HackType var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.getVL(var0, var1.getHackType());
   }

   static double getCertainty(Player var0, Enums.HackType var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.getCertainty(var0, var1.getHackType());
   }

   static double getDecimalVL(Player var0, Enums.HackType var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.getDecimalVL(var0, var1.getHackType());
   }

   static int getVL(Player var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.getVL(var0);
   }

   static double getDecimalVL(Player var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.getDecimalVL(var0);
   }

   /** @deprecated */
   @Deprecated
   static void setVL(Player var0, Enums.HackType var1, int var2) {
      ai.idealistic.vacan.api.BackgroundAPI.setVL(var0, var1.getHackType(), var2);
   }

   /** @deprecated */
   @Deprecated
   static int getCancelViolation(Enums.HackType var0, String var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.getCancelViolation(var0.getHackType(), var1);
   }

   /** @deprecated */
   @Deprecated
   static int getCancelViolation(Enums.HackType var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.getCancelViolation(var0.getHackType());
   }

   /** @deprecated */
   @Deprecated
   static int getViolationDivisor(Player var0, Enums.HackType var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.getViolationDivisor(var0, var1.getHackType());
   }

   static void reloadConfig() {
      ai.idealistic.vacan.api.BackgroundAPI.reloadConfig();
   }

   /** @deprecated */
   @Deprecated
   static void reloadPermissions() {
      ai.idealistic.vacan.api.BackgroundAPI.reloadPermissions();
   }

   /** @deprecated */
   @Deprecated
   static void reloadPermissions(Player var0) {
      ai.idealistic.vacan.api.BackgroundAPI.reloadPermissions(var0);
   }

   static void enableCheck(Enums.HackType var0) {
      ai.idealistic.vacan.api.BackgroundAPI.enableCheck(var0.getHackType());
   }

   static void disableCheck(Enums.HackType var0) {
      ai.idealistic.vacan.api.BackgroundAPI.disableCheck(var0.getHackType());
   }

   static void cancelCheck(Player var0, Enums.HackType var1, int var2) {
      ai.idealistic.vacan.api.BackgroundAPI.cancelCheck(var0, var1.getHackType(), var2);
   }

   static void cancelCheckPerVerbose(Player var0, String var1, int var2) {
      ai.idealistic.vacan.api.BackgroundAPI.cancelCheckPerVerbose(var0, var1, var2);
   }

   static void enableSilentChecking(Enums.HackType var0) {
      ai.idealistic.vacan.api.BackgroundAPI.enableSilentChecking(var0.getHackType());
   }

   static void disableSilentChecking(Enums.HackType var0) {
      ai.idealistic.vacan.api.BackgroundAPI.disableSilentChecking(var0.getHackType());
   }

   static void enableSilentChecking(Player var0, Enums.HackType var1) {
      ai.idealistic.vacan.api.BackgroundAPI.enableSilentChecking(var0, var1.getHackType());
   }

   static void disableSilentChecking(Player var0, Enums.HackType var1) {
      ai.idealistic.vacan.api.BackgroundAPI.disableSilentChecking(var0, var1.getHackType());
   }

   static void startCheck(Player var0, Enums.HackType var1) {
      ai.idealistic.vacan.api.BackgroundAPI.startCheck(var0, var1.getHackType());
   }

   static void stopCheck(Player var0, Enums.HackType var1) {
      ai.idealistic.vacan.api.BackgroundAPI.stopCheck(var0, var1.getHackType());
   }

   static void resetVL() {
      ai.idealistic.vacan.api.BackgroundAPI.resetVL();
   }

   static void resetVL(Player var0) {
      ai.idealistic.vacan.api.BackgroundAPI.resetVL(var0);
   }

   static boolean isBypassing(Player var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.isBypassing(var0);
   }

   static boolean isBypassing(Player var0, Enums.HackType var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.isBypassing(var0, var1.getHackType());
   }

   /** @deprecated */
   @Deprecated
   static void banPlayer(UUID var0, String var1) {
      ai.idealistic.vacan.api.BackgroundAPI.banPlayer(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   static boolean isBanned(UUID var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.isBanned(var0);
   }

   /** @deprecated */
   @Deprecated
   static void unbanPlayer(UUID var0) {
      ai.idealistic.vacan.api.BackgroundAPI.unbanPlayer(var0);
   }

   /** @deprecated */
   @Deprecated
   static String getBanReason(UUID var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.getBanReason(var0);
   }

   /** @deprecated */
   @Deprecated
   static String getBanPunisher(UUID var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.getBanPunisher(var0);
   }

   /** @deprecated */
   @Deprecated
   static boolean isHacker(Player var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.isHacker(var0);
   }

   /** @deprecated */
   @Deprecated
   static boolean isLegitimate(Player var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.isLegitimate(var0);
   }

   /** @deprecated */
   @Deprecated
   static boolean hasMiningNotificationsEnabled(Player var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.hasMiningNotificationsEnabled(var0);
   }

   /** @deprecated */
   @Deprecated
   static void setMiningNotifications(Player var0, boolean var1) {
      ai.idealistic.vacan.api.BackgroundAPI.setMiningNotifications(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   static int getCPS(Player var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.getCPS(var0);
   }

   /** @deprecated */
   @Deprecated
   static UUID[] getBanList() {
      return ai.idealistic.vacan.api.BackgroundAPI.getBanList();
   }

   static boolean addToWave(UUID var0, String var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.addToWave(var0, var1);
   }

   static void removeFromWave(UUID var0) {
      ai.idealistic.vacan.api.BackgroundAPI.removeFromWave(var0);
   }

   static void clearWave() {
      ai.idealistic.vacan.api.BackgroundAPI.clearWave();
   }

   static void runWave() {
      ai.idealistic.vacan.api.BackgroundAPI.runWave();
   }

   static UUID[] getWaveList() {
      return ai.idealistic.vacan.api.BackgroundAPI.getWaveList();
   }

   static int getWaveSize() {
      return ai.idealistic.vacan.api.BackgroundAPI.getWaveSize();
   }

   static boolean isAddedToTheWave(UUID var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.isAddedToTheWave(var0);
   }

   static void warnPlayer(Player var0, String var1) {
      ai.idealistic.vacan.api.BackgroundAPI.warnPlayer(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   static void addPermission(Player var0, Enums.Permission var1) {
      ai.idealistic.vacan.api.BackgroundAPI.addPermission(var0, var1.getPermission());
   }

   /** @deprecated */
   @Deprecated
   static void sendClientSidedBlock(Player var0, Location var1, Material var2, byte var3) {
      ai.idealistic.vacan.api.BackgroundAPI.sendClientSidedBlock(var0, var1, var2, var3);
   }

   /** @deprecated */
   @Deprecated
   static void destroyClientSidedBlock(Player var0, Location var1) {
      ai.idealistic.vacan.api.BackgroundAPI.destroyClientSidedBlock(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   static void removeClientSidedBlocks(Player var0) {
      ai.idealistic.vacan.api.BackgroundAPI.removeClientSidedBlocks(var0);
   }

   /** @deprecated */
   @Deprecated
   static boolean containsClientSidedBlock(Player var0, Location var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.containsClientSidedBlock(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   static Material getClientSidedBlockMaterial(Player var0, Location var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.getClientSidedBlockMaterial(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   static byte getClientSidedBlockData(Player var0, Location var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.getClientSidedBlockData(var0, var1);
   }

   static String getConfiguredCheckName(Enums.HackType var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.getConfiguredCheckName(var0.getHackType());
   }

   static void setConfiguredCheckName(Enums.HackType var0, String var1) {
      ai.idealistic.vacan.api.BackgroundAPI.setConfiguredCheckName(var0.getHackType(), var1);
   }

   /** @deprecated */
   @Deprecated
   static void disableVelocityProtection(Player var0, int var1) {
      ai.idealistic.vacan.api.BackgroundAPI.disableVelocityProtection(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   static void setOnGround(Player var0, int var1) {
      ai.idealistic.vacan.api.BackgroundAPI.setOnGround(var0, var1);
   }

   /** @deprecated */
   @Deprecated
   static int getMaxPunishmentViolation(Enums.HackType var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.getMaxPunishmentViolation(var0.getHackType());
   }

   /** @deprecated */
   @Deprecated
   static int getMinPunishmentViolation(Enums.HackType var0) {
      return ai.idealistic.vacan.api.BackgroundAPI.getMinPunishmentViolation(var0.getHackType());
   }

   /** @deprecated */
   @Deprecated
   static boolean mayPunishPlayer(Player var0, Enums.HackType var1) {
      return ai.idealistic.vacan.api.BackgroundAPI.mayPunishPlayer(var0, var1.getHackType());
   }
}
