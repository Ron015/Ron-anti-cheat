package ai.idealistic.vacan.compatibility.b;

import ai.idealistic.vacan.compatibility.Compatibility;
import org.bukkit.entity.Player;
import protocolsupport.api.Connection;
import protocolsupport.api.ProtocolSupportAPI;

public class c {
   static boolean d(Player var0) {
      if (Compatibility.CompatibilityType.PROTOCOL_SUPPORT.isFunctional()) {
         try {
            Connection var1 = ProtocolSupportAPI.getConnection(var0);
            return var1 != null && var1.getVersion().toString().contains("_PE_");
         } catch (Exception var2) {
         }
      }

      return false;
   }
}
