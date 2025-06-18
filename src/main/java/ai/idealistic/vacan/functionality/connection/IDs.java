package ai.idealistic.vacan.functionality.connection;

import java.util.Objects;

public class IDs {
   public static final String user = "%%__USER__%%";
   public static final String file = "%%__NONCE__%%";
   public static final String resource = "%%__RESOURCE__%%";
   public static final boolean enabled = ai.idealistic.vacan.utils.b.a.al("25638");
   public static final boolean builtByBit = "%%__BUILTBYBIT__%%".length() != 18;
   public static final boolean polymart = "%%__POLYMART__%%".length() == 1;
   public static final boolean spigot;
   private static String userModified;
   private static String fileModified;

   static void set(int var0, int var1) {
      userModified = Integer.toString(var0);
      fileModified = Integer.toString(var1);
   }

   public static String user() {
      return userModified != null ? userModified : "1897975";
   }

   public static String file() {
      if (enabled) {
         String var0 = fileModified != null ? fileModified : "844662288525";
         if (!var0.startsWith("%%__") && !ai.idealistic.vacan.utils.b.a.al(var0)) {
            var0 = String.valueOf(Objects.hash(new Object[]{var0}));
         }

         return var0;
      } else {
         return user();
      }
   }

   static String platform() {
      return builtByBit ? "BuiltByBit" : (polymart ? "Polymart" : "SpigotMC");
   }

   public static boolean canAdvertise() {
      return !enabled || builtByBit || polymart;
   }

   static {
      spigot = !builtByBit && !polymart;
      userModified = null;
      fileModified = null;
   }
}
