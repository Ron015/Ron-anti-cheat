package ai.idealistic.vacan.functionality.server;

import com.comphenix.protocol.ProtocolLibrary;
import com.viaversion.viaversion.api.Via;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class MultiVersion {
   private static final boolean je = ai.idealistic.vacan.utils.a.e.aa("com.destroystokyo.paper.network.NetworkClient");
   public static final MultiVersion.MCVersion jf = eY();
   public static final boolean jg = Bukkit.getVersion().toLowerCase().contains("folia");

   public static boolean c(MultiVersion.MCVersion var0) {
      return jf.ordinal() >= var0.ordinal();
   }

   public static MultiVersion.MCVersion f(Player var0) {
      int var1;
      if (ai.idealistic.vacan.compatibility.b.a.b.a(var0)) {
         var1 = -1;
      } else if (ai.idealistic.vacan.utils.minecraft.c.b.h("viaversion")) {
         var1 = Via.getAPI().getPlayerVersion(var0);
      } else if (je) {
         var1 = var0.getProtocolVersion();
      } else if (c.bW()) {
         var1 = ProtocolLibrary.getProtocolManager().getProtocolVersion(var0);
      } else {
         var1 = -1;
      }

      if (var1 >= 0) {
         MultiVersion.MCVersion[] var2 = MultiVersion.MCVersion.values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            MultiVersion.MCVersion var5 = var2[var4];
            if (var1 <= var5.maxProtocol) {
               return var5;
            }
         }
      }

      return MultiVersion.MCVersion.OTHER;
   }

   private static MultiVersion.MCVersion eY() {
      String var0 = Bukkit.getVersion();
      var0 = var0.substring(0, var0.length() - 1);

      try {
         for(int var1 = 0; var1 <= var0.length(); ++var1) {
            if (var0.substring(var1).startsWith("(MC: ")) {
               var0 = var0.substring(var1 + 5);

               for(int var2 = 0; var2 <= var0.length(); ++var2) {
                  MultiVersion.MCVersion[] var3 = MultiVersion.MCVersion.values();
                  int var4 = var3.length;

                  for(int var5 = 0; var5 < var4; ++var5) {
                     MultiVersion.MCVersion var6 = var3[var5];
                     if (var6.defaultString().equalsIgnoreCase("V" + var0.substring(0, var0.length() - var2).replace(".", "_"))) {
                        return var6;
                     }
                  }
               }
            }
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      return MultiVersion.MCVersion.OTHER;
   }

   public static enum MCVersion {
      V1_7(5),
      V1_8(47),
      V1_9(110),
      V1_10(210),
      V1_11(316),
      V1_12(340),
      V1_13(404),
      V1_14(498),
      V1_15(578),
      V1_16(754),
      V1_17(756),
      V1_18(758),
      V1_19(762),
      V1_20(766),
      V1_21(Integer.MAX_VALUE),
      OTHER(-1);

      public final int maxProtocol;

      private MCVersion(int var3) {
         this.maxProtocol = var3;
      }

      public String toString() {
         return this.maxProtocol == -1 ? "Unknown" : this.defaultString().substring(1).replace("_", ".");
      }

      private String defaultString() {
         return super.toString();
      }

      // $FF: synthetic method
      private static MultiVersion.MCVersion[] $values() {
         return new MultiVersion.MCVersion[]{V1_7, V1_8, V1_9, V1_10, V1_11, V1_12, V1_13, V1_14, V1_15, V1_16, V1_17, V1_18, V1_19, V1_20, V1_21, OTHER};
      }
   }
}
