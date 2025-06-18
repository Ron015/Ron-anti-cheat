package ai.idealistic.vacan.compatibility.b;

import ai.idealistic.vacan.compatibility.Compatibility;
import ai.idealistic.vacan.utils.a.e;
import java.util.UUID;
import org.geysermc.floodgate.api.FloodgateApi;

public class b {
   private static boolean hu = false;

   public static void eq() {
      hu = e.aa("org.geysermc.floodgate.api.FloodgateApi");
   }

   static boolean a(UUID var0, String var1) {
      return Compatibility.CompatibilityType.FLOODGATE.isFunctional() && hu && FloodgateApi.getInstance().isFloodgatePlayer(var0) || var1 != null && E(var1);
   }

   private static boolean E(String var0) {
      String var1 = ai.idealistic.vacan.functionality.server.a.iZ.l("Important.bedrock_player_prefix");
      return !var1.isEmpty() && var0.startsWith(var1);
   }
}
